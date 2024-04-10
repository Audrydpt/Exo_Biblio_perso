package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class ExemplaireViewConsole extends AbstractViewExemplaire {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(exemplaireController.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void retirer() {
        int nl = choixElt(le) - 1;
        Exemplaire e = le.get(nl);
        boolean ok = exemplaireController.remove(e);
        if (ok) affMsg("Exemplaire effacé");
        else affMsg("Exemplaire non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("Matricule ");
            String matricule = sc.nextLine();
            Exemplaire e = exemplaireController.search(new Exemplaire(matricule));
            if (e != null) {
                System.out.println(e);
            } else {
                System.out.println("Exemplaire non trouvé");
            }
        } catch (Exception e) {
            System.out.println("Erreur de saisie");
        }
    }

    public void modifier() {
        int choix = choixElt(le);
        Exemplaire e = le.get(choix - 1);
        do {
            try {
                String matricule = modifyIfNotBlank("Matricule", e.getMatricule());
                String descriptionEtat = modifyIfNotBlank("Description Etat", e.getDescriptionEtat());
                e.setMatricule(matricule);
                e.setDescriptionEtat(descriptionEtat);
                break;
            } catch (Exception ex) {
                System.out.println("Erreur :" + ex);
            }
        } while (true);
        exemplaireController.update(e);
    }

    public void ajouter() {
        Exemplaire e;
        do {
            try {
                System.out.println("Matricule ");
                String matricule = sc.nextLine();
                System.out.println("Description Etat ");
                String descriptionEtat = sc.nextLine();
                e = new Exemplaire(matricule, descriptionEtat);
                break;
            } catch (Exception ex) {
                System.out.println("Une erreur est survenue : " + ex.getMessage());
            }
        } while (true);
        exemplaireController.add(e);
    }

    @Override
    public void affList(List le) {
        System.out.println("Liste des exemplaires");
        for (int i = 0; i < le.size(); i++) {
            System.out.println((i + 1) + " : " + le.get(i));
        }
    }

    public static void main(String[] args) {
        ExemplaireViewConsole evc = new ExemplaireViewConsole();
        evc.menu();
    }
}