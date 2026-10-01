public class LivreIndisponibleException extends Exception {

    public LivreIndisponibleException(String titre) {
        super("Livre indisponible : " + titre);
    }
}
