public class Main {

    public static void main(String[] args) {

        // ==============================
        // 1. Création des documents
        // ==============================

        Livre livre1 = new Livre(
                "Clean Code",
                2008,
                "Robert C. Martin",
                464
        );

        Livre livre2 = new Livre(
                "Refactoring",
                1999,
                "Martin Fowler",
                448
        );

        Revue revue1 = new Revue(
                "Science",
                2026,
                412
        );

        // ==============================
        // 2. Création du catalogue
        // ==============================

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(livre1);
        catalogue.ajouter(livre2);
        catalogue.ajouter(revue1);

        // ==============================
        // 3. Affichage du catalogue
        // ==============================

        System.out.println("===== CATALOGUE =====");

        catalogue.afficherTout();

        // ==============================
        // 4. Recherche d'un document
        // ==============================

        System.out.println("\n===== RECHERCHE =====");

        catalogue.rechercherParTitre("Clean Code")
                .ifPresent(document ->
                        System.out.println(
                                "Document trouvé : "
                                        + document.descriptionCourte()
                        )
                );

        // ==============================
        // 5. Bibliothécaire par composition
        // ==============================

        System.out.println("\n===== BIBLIOTHÉCAIRE =====");

        Bibliothecaire bibliothecaire =
                new Bibliothecaire("Aya", catalogue);

        bibliothecaire.accueillir();

        // ==============================
        // 6. Gestionnaire des emprunts
        // ==============================

        System.out.println("\n===== EMPRUNTS =====");

        EmpruntManager manager =
                new EmpruntManager(catalogue);

        // Premier emprunt
        try {
            manager.emprunter("Clean Code");

            System.out.println(
                    "Emprunt réussi : Clean Code"
            );

        } catch (MediathequeException e) {

            System.out.println(
                    "Erreur : " + e.getMessage()
            );
        }

        // ==============================
        // 7. Tentative de double emprunt
        // ==============================

        System.out.println("\n===== DOUBLE EMPRUNT =====");

        try {
            manager.emprunter("Clean Code");

        } catch (MediathequeException e) {

            System.out.println(
                    "Erreur : " + e.getMessage()
            );
        }

        // ==============================
        // 8. Emprunt d'un document inexistant
        // ==============================

        System.out.println("\n===== DOCUMENT INEXISTANT =====");

        try {
            manager.emprunter("Document Fantôme");

        } catch (MediathequeException e) {

            System.out.println(
                    "Erreur : " + e.getMessage()
            );
        }

        // ==============================
        // 9. Vérification de disponibilité
        // ==============================

        System.out.println("\n===== DISPONIBILITÉ =====");

        System.out.println(
                "Clean Code disponible : "
                        + livre1.estDisponible()
        );

        System.out.println(
                "Refactoring disponible : "
                        + livre2.estDisponible()
        );
    }
}