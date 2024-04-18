package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvc.controller.ControllerSpecialOuvrage;
import bibliotheque.utilitaires.*;

import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.*;


public class OuvrageViewConsole extends AbstractView<Ouvrage> {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(controller.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher","modifier","fin");
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
        int nl = choixElt(la)-1;
        Ouvrage a = la.get(nl);
        boolean ok = controller.remove(a);
        if(ok) affMsg("ouvrage effacé");
        else affMsg("ouvrage non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        // Ask for the type of ouvrage
        System.out.println("Enter the type of ouvrage:");
        String type = sc.next();

        // Ask for the unique info related to the type
        System.out.println("Enter the unique info related to the type:");
        String uniqueInfo = sc.next();

        // Search for the ouvrage
        for (Ouvrage ouvrage : la) {
            if (ouvrage.getType().equals(TypeOuvrage.valueOf(type.toUpperCase())) && ouvrage.getUniqueInfo().equals(uniqueInfo)) {
                System.out.println("Found ouvrage: " + ouvrage);
                return;
            }
        }

        System.out.println("No ouvrage found with the given type and unique info.");
    }


    public void modifier() {
        int choix = choixElt(la);
        Ouvrage a = la.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+a.getPrixLocation()));
                a.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        controller.update(a);
   }


    public void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage a = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        a = lof.get(choix-1).create();


        System.out.println("Enter the number of authors to assign to this ouvrage:");
        int numAuthors = sc.nextInt();
        for (int i = 0; i < numAuthors; i++) {
            System.out.println("Enter the name of author " + (i + 1) + ":");
            String authorName = sc.next();
            Auteur author = new Auteur(authorName); // Assuming Auteur class has a constructor that takes a name
            a.addAuteur(author);
        }

         List<Auteur> sortedAuthors = new ArrayList<>(a.getLauteurs());
        sortedAuthors.sort(new Comparator<Auteur>() {
            @Override
            public int compare(Auteur a1, Auteur a2) {
                int nameComparison = a1.getNom().compareTo(a2.getNom());
                if (nameComparison != 0) {
                    return nameComparison;
                } else {
                    return a1.getPrenom().compareTo(a2.getPrenom());
                }
            }
        });
        System.out.println("Authors sorted by name and surname: " + sortedAuthors);


        controller.add(a);
    }

    protected void special() {
        int choix =  choixElt(la);
        Ouvrage o = la.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);

    }

    public void enLocation(Ouvrage o, boolean enLocation) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage) controller).listerExemplaire(o, enLocation);
        affList(l);
    }

    public void exemplaires(Ouvrage o) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage)controller).listerExemplaire(o);
        affList(l);
    }
    @Override
    public void affList(List la) {
        affListe(la);
    }
}
