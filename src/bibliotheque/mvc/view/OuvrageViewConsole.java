package bibliotheque.mvc.view;

import bibliotheque.metier.Ouvrage;

import java.util.List;

public class OuvrageViewConsole {
    public void menu() {
        System.out.println("1. Afficher tous les ouvrages");
        System.out.println("2. Ajouter un ouvrage");
        System.out.println("3. Modifier un ouvrage");
        System.out.println("4. Supprimer un ouvrage");
        System.out.println("5. Rechercher un ouvrage");
        System.out.println("6. Retour");
    }

    public void affList(List ll) {
        System.out.println("Liste des ouvrages");
        for (Ouvrage o : ll) {
            System.out.println(o);
        }
    }

    public void affMsg(String msg) {
        System.out.println(msg);
    }

    public void affOuvrage(Ouvrage o) {
        System.out.println(o);
    }
}
