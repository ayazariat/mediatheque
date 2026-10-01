import java.util.*;

public class Main {

    public static void main(String[] args) {

        Livre livre1 = new Livre("Clean Code", 2008, "R. Martin", 464);
        Livre livre2 = new Livre("Refactoring", 1999, "M. Fowler", 448);
        Revue revue1 = new Revue("Science", 2026, 412);

        System.out.println("=== DOCUMENTS ===");

        System.out.println(livre1.descriptionCourte());
        System.out.println(livre2.descriptionCourte());
        System.out.println(revue1.descriptionCourte());


        System.out.println("\n=== EMPRUNT ===");

        System.out.println("Disponible : " + livre1.estDisponible());

        try {
            livre1.emprunter();
            System.out.println("Après emprunt : " + livre1.estDisponible());

            livre1.rendre();
            System.out.println("Après retour : " + livre1.estDisponible());

        } catch (LivreIndisponibleException e) {
            System.out.println("Exception : " + e.getMessage());
        }


        System.out.println("\n=== DOUBLE EMPRUNT ===");

        try {
            livre2.emprunter();
            System.out.println("Livre 2 emprunté.");

            livre2.emprunter();

        } catch (LivreIndisponibleException e) {
            System.out.println("Exception : " + e.getMessage());
        }


        System.out.println("\n=== CATALOGUE ===");

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(livre1);
        catalogue.ajouter(livre2);
        catalogue.ajouter(revue1);

        catalogue.afficherTout();


        System.out.println("\n=== RECHERCHE ===");

        try {

            Document resultat =
                    catalogue.rechercherParTitre("Science");

            System.out.println("Document trouvé : "
                    + resultat.descriptionCourte());

        } catch (TitreIntrouvableException e) {
            System.out.println("Exception : " + e.getMessage());
        }


        System.out.println("\n=== RECHERCHE TITRE INEXISTANT ===");

        try {

            Document resultat =
                    catalogue.rechercherParTitre("Nature");

            System.out.println("Document trouvé : "
                    + resultat.descriptionCourte());

        } catch (TitreIntrouvableException e) {
            System.out.println("Exception : " + e.getMessage());
        }


    }
}