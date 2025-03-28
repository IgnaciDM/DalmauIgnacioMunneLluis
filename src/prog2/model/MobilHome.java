package prog2.model;

// La classe MobilHome és una subclasse de Allotjament que representa un tipus d'allotjament amb característiques particulars.
public class MobilHome extends Casa {

    // Atributs de la classe MobilHome, que defineixen les característiques específiques d'un MobilHome.

    private boolean terrassaBarbacoa;

    // Constructor que inicialitza els atributs de la classe MobilHome.
    // Es crida el constructor de la classe pare Allotjament per establir alguns valors per defecte (nom, idAllotjament, 5, 3).
    public MobilHome(String nom, String idAllotjament,boolean estat, String iluminacio,float mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, estat, iluminacio);  //nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa
        this.terrassaBarbacoa = terrassaBarbacoa;
    }


    // Mètodes getters i setters per accedir i modificar els atributs de la classe MobilHome.


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

    public void tancarAllotjament(Incidencia in) {
        setEstat(false);
        if (in.getIluminacioAllotjament() != null) {
            setIluminacio(in.getIluminacioAllotjament());
        } else {
            System.out.println("Avís: Il·luminació no especificada.");
        }
        System.out.println("Allotjament tancat");
    }

    public void obrirAllotjament() {
        setEstat(true);
        setIluminacio("100%");
    }

    // Mètode toString que retorna una representació textual de l'objecte MobilHome per poder imprimir-lo de manera legible.
    @Override
    public String toString() {
        return super.toString().replace("]", "") + ", terrassaBarbacoa=" + terrassaBarbacoa + "]";
    }

}

