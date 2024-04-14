package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;

import java.util.List;

public class LivreViewConsole {
    public void menu() {
        System.out.println("1. Afficher les livres");
        System.out.println("2. Ajouter un livre");
        System.out.println("3. Modifier un livre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Retour");
    }

    public void affList(List ll) {
        System.out.println("Liste des livres");
        for (Livre l : ll) {
            System.out.println(l);
        }
    }

    public void affMsg(String msg) {
        System.out.println(msg);
    }

    public void affLivre(Livre l) {
        System.out.println(l);
    }
}
