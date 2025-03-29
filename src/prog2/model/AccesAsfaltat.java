package prog2.model;

import java.util.ArrayList;

public class AccesAsfaltat extends Acces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;  // Superfície asfaltada en metres quadrats

    // Constructor de la classe AccesAsfalt
    public AccesAsfaltat(String nom, boolean estat, boolean accesibilitat, ArrayList<Allotjament> accesAAllotjaments, float mcuadrats) {
        super(nom, accesibilitat, mcuadrats);  // Crida al constructor de la classe base Acces
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = allotjaments;
        this.mcuadrats = mcuadrats;
        // Si la lista pasada es null, inicializamos una vacía
        this.allotjaments = (accesAAllotjaments != null) ? accesAAllotjaments : new ArrayList<>();
    }

    // Getter i Setter per a la superfície asfaltada
    public float getMquadrats() {
        return mcuadrats;
    }

    public void setMquadrats(float mcuadrats) {
        this.mcuadrats = mcuadrats;
    }

    // Mètode toString per mostrar la informació de l'accés asfaltat
    @Override
    public String toString() {
        return "AccesAsfalt{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + accesibilitat +
                ", estat=" + estat +
                ", mcuadrats=" + mcuadrats +
                ", allotjaments=" + allotjaments.size() +
                '}';
    }

}
