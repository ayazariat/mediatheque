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

        livre1.emprunter();

        System.out.println("Après emprunt : " + livre1.estDisponible());

        livre1.rendre();

        System.out.println("Après retour : " + livre1.estDisponible());

        System.out.println("\n=== DOUBLE EMPRUNT ===");

        livre2.emprunter();

        try {
            livre2.emprunter();
        } catch (IllegalStateException e) {
            System.out.println("Exception : " + e.getMessage());
        }

        System.out.println("\n=== CATALOGUE ===");

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(livre1);
        catalogue.ajouter(livre2);
        catalogue.ajouter(revue1);

        catalogue.afficherTout();

        System.out.println("\n=== RECHERCHE ===");

        Optional<Document> resultat =
                catalogue.rechercherParTitre("Science");

        if (resultat.isPresent()) {
            System.out.println("Document trouvé : "
                    + resultat.get().descriptionCourte());
        } else {
            System.out.println("Document non trouvé");
        }

        Optional<Document> resultat2 =
                catalogue.rechercherParTitre("Nature");

        System.out.println("Recherche Nature : "
                + (resultat2.isEmpty() ? "Aucun résultat" : "Trouvé"));

        System.out.println("\n=== COMPARAISON ===");

        List<Document> documents = new ArrayList<>();

        documents.add(livre1);
        documents.add(livre2);
        documents.add(revue1);

        Document maximum = Catalogue.max(documents);

        System.out.println("Maximum selon le titre : "
                + maximum.getTitre());
    }
}