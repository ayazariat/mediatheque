import java.util.*;

public class Catalogue<T extends Document> {

    private final List<T> elements = new ArrayList<>();

    public void ajouter(T element) {
        elements.add(element);
    }

    public T rechercherParTitre(String titre)
            throws TitreIntrouvableException {

        return elements.stream()
                .filter(d -> d.getTitre().equalsIgnoreCase(titre))
                .findFirst()
                .orElseThrow(() -> new TitreIntrouvableException(titre));
    }

    public void afficherTout() {
        elements.forEach(d -> System.out.println(d.descriptionCourte()));
    }

    public static <T extends Comparable<T>> T max(List<T> liste) {

        T m = liste.get(0);

        for (T e : liste) {
            if (e.compareTo(m) > 0) {
                m = e;
            }
        }

        return m;
    }
}