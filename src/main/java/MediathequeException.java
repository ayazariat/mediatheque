public abstract class MediathequeException extends Exception {

    protected MediathequeException(String message) {
        super(message);
    }

    protected MediathequeException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
 * Choix : checked exception.
 *
 * Une indisponibilité ou l'absence d'un document est une situation
 * métier attendue et non une erreur de programmation.
 * Le choix d'une exception checked oblige l'appelant à traiter
 * explicitement cette situation ou à la déclarer avec throws.
 */