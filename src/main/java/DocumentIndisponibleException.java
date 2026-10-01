public class DocumentIndisponibleException extends MediathequeException {

    public DocumentIndisponibleException(String titre) {
        super("Document deja emprunte : " + titre);
    }
}