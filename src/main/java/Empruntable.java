public interface Empruntable {

    void emprunter() throws LivreIndisponibleException;

    void rendre();

    boolean estDisponible();
}