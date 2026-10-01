public class TitreIntrouvableException extends Exception {

    public TitreIntrouvableException(String titre) {
        super("Titre introuvable : " + titre);
    }
}