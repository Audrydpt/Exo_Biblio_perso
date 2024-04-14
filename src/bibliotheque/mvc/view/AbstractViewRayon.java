package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.controller.RayonController;

import java.util.List;

public class AbstractViewRayon {
    protected RayonController rayonController;
    protected List<Rayon> rl;

    public void setController(RayonController rayonController) {
        this.rayonController = rayonController;
    }

    public abstract void menu();

    public abstract void affList(List rl);

    public List<Rayon> getAll(){
        return rl;
    }

    @Override
    public void update(List rl) {
        this.rl = rl;
        affList(rl);
    }
}
