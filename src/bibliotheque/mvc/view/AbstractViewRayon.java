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

    public void create() {
        rayonController.create();
    }

    public void read() {
        rayonController.read();
    }

    public void update() {
        rayonController.update();
    }

    public void delete() {
        rayonController.delete();
    }

    public void affList(List rl) {
        rayonController.affList(rl);
    }

    public void affRayon(Rayon r) {
        rayonController.affRayon(r);
    }

    public void addRayon(Rayon r) {
        rayonController.addRayon(r);
    }

    public void removeRayon(Rayon r) {
        rayonController.removeRayon(r);
    }

    public void updateRayon(Rayon r) {
        rayonController.updateRayon(r);
    }

    public void searchRayon(Rayon r) {
        rayonController.searchRayon(r);
    }

    public void sortRayon(Rayon r) {
        rayonController.sortRayon(r);
    }

    public void filterRayon(Rayon r) {
        rayonController.filterRayon(r);
    }

    public void save() {
        rayonController.save();
    }

    public void load() {
        rayonController.load();
    }
}
