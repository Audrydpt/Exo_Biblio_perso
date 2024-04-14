package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;

import java.util.List;

public class LecteurViewConsole {
    public void menu() {
        System.out.println("1. Afficher la liste des lecteurs");
        System.out.println("2. Ajouter un lecteur");
        System.out.println("3. Modifier un lecteur");
        System.out.println("4. Supprimer un lecteur");
        System.out.println("5. Retour");
    }

    public void affList(List ll) {
        System.out.println("Liste des lecteurs");
        for (Lecteur l : ll) {
            System.out.println(l);
        }
    }


    public void affMsg(String msg) {
        System.out.println(msg);
    }




}
