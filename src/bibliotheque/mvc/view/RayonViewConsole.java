package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;

import java.util.List;

public class RayonViewConsole {
    public void menu() {
        System.out.println("1. Afficher les rayons");
        System.out.println("2. Ajouter un rayon");
        System.out.println("3. Modifier un rayon");
        System.out.println("4. Supprimer un rayon");
        System.out.println("5. Retour");
    }

    public void affList(List rl) {
        System.out.println("Liste des rayons");
        for (Rayon r : rl) {
            System.out.println(r);
        }
    }
}
