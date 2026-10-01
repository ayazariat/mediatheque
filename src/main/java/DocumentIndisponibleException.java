public class DocumentIndisponibleException
        extends MediathequeException {

    public DocumentIndisponibleException(String titre) {
        super("Document deja emprunte : " + titre);
    }

    public DocumentIndisponibleException(
            String titre,
            Throwable cause) {

        super(
            "Document deja emprunte : " + titre,
            cause
        );
    }
}