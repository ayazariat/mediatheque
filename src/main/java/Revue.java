public class Revue extends Document { // pas d’Empruntable !
private final int numero;
public Revue(String titre, int annee, int numero) {
super(titre, annee);
this.numero = numero;
}
@Override
public String descriptionCourte() {
return "[Revue] " + titre + " n." + numero
+ " (" + annee + ")-consultation sur place";
}
}