import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    @Test
    void empruntDocumentInconnu() {

        EmpruntManager manager =
                new EmpruntManager(new Catalogue<>());

        MediathequeException ex =
                assertThrows(
                        DocumentIntrouvableException.class,
                        () -> manager.emprunter("Fantome")
                );

        assertTrue(
                ex.getMessage().contains("Fantome")
        );
    }
    @Test
void doubleEmprunt() throws MediathequeException {

    Catalogue<Document> catalogue =
            new Catalogue<>();

    catalogue.ajouter(
            new Livre(
                    "Clean Code",
                    2008,
                    "R. Martin",
                    464
            )
    );

    EmpruntManager manager =
            new EmpruntManager(catalogue);

    manager.emprunter("Clean Code");

    assertThrows(
            DocumentIndisponibleException.class,
            () -> manager.emprunter("Clean Code")
    );
}
}