package bibliotheque.mvc.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.controller.OuvrageController;

import java.util.List;

public class AbstractViewOuvrage {
    protected OuvrageController ouvrageController;
    protected List<Ouvrage> ll;

    public void setController(OuvrageController ouvrageController) {
        this.ouvrageController = ouvrageController;
    }

    public abstract void menu();

    public abstract void affList(List ll);

    public List<Ouvrage> getAll(){
        return ll;
    }

    @Override
    public void update(List ll) {
        this.ll = ll;
        affList(ll);
    }

    public void create() {
        ouvrageController.create();
    }
}
