package prog2.model;

// La classe MobilHome és una subclasse de Allotjament que representa un tipus d'allotjament amb característiques particulars.
public class MobilHome extends Casa {

    // Atributs de la classe MobilHome, que defineixen les característiques específiques d'un MobilHome.
    private String nom;
    private String idAllotjament;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private boolean terrassaBarbacoa;

    // Constructor que inicialitza els atributs de la classe MobilHome.
    // Es crida el constructor de la classe pare Allotjament per establir alguns valors per defecte (nom, idAllotjament, 5, 3).
    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, mida, habitacions, placesPersones);  // Crida al constructor de la classe pare (Allotjament).
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Mètodes getters i setters per accedir i modificar els atributs de la classe MobilHome.

    public String getNom() {
        return nom;  // Retorna el nom del MobilHome.
    }

    public void setNom(String nom) {
        this.nom = nom;  // Assigna un nou valor al nom del MobilHome.
    }

    public String getIdAllotjament() {
        return idAllotjament;  // Retorna l'identificador de l'allotjament.
    }

    public void setIdAllotjament(String idAllotjament) {
        this.idAllotjament = idAllotjament;  // Assigna un nou identificador a l'allotjament.
    }

    public String getMida() {
        return mida;  // Retorna la mida de l'allotjament.
    }

    public void setMida(String mida) {
        this.mida = mida;  // Assigna una nova mida a l'allotjament.
    }

    public int getHabitacions() {
        return habitacions;  // Retorna el nombre d'habitacions de l'allotjament.
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;  // Assigna un nou nombre d'habitacions.
    }

    public int getPlacesPersones() {
        return placesPersones;  // Retorna el nombre de places disponibles per a persones.
    }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;  // Assigna un nou nombre de places per a persones.
    }

    public boolean isTerrassaBarbacoa() {
        return terrassaBarbacoa;  // Retorna si l'allotjament té terrassa amb barbacoa.
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;  // Assigna un nou valor per indicar si té terrassa amb barbacoa.
    }

    // Mètode que retorna si el MobilHome és operatiu o no. En aquest cas, depèn de si té terrassa amb barbacoa.
    public boolean esOperatiu() {
        return terrassaBarbacoa;  // Retorna si el MobilHome té terrassa amb barbacoa.
    }

    // Mètode toString que retorna una representació textual de l'objecte MobilHome per poder imprimir-lo de manera legible.
    @Override
    public String toString() {
        return "Bungalow [nom=" + nom + ", idAllotjament=" + idAllotjament + ", mida=" + mida + ", habitacions="
                + habitacions + ", placesPersones=" + placesPersones + ", placesParquing="
                + ", terrassa=" + terrassaBarbacoa +"]";  // Retorna una cadena amb els atributs de l'allotjament.
    }
}

