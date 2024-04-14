package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.controller.LecteurController;

import java.util.List;

public class AbstractViewLecteur {
    protected LecteurController lecteurController;
    protected List<Lecteur> ll;

    public void setController(LecteurController lecteurController) {
        this.lecteurController = lecteurController;
    }

    public abstract void menu();

    public abstract void affList(List ll);

    public List<Lecteur> getAll(){
        return ll;
    }

    @Override
    public void update(List ll) {
        this.ll = ll;
        affList(ll);
    }
}
