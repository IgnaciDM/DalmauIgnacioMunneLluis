package prog2.model;

import java.util.ArrayList;

public class AccesAsfaltat extends Acces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;  // Superfície asfaltada en metres quadrats

    // Constructor de la classe AccesAsfalt
    public AccesAsfaltat(String nom, boolean estat, boolean accesibilitat, ArrayList<Allotjament> allotjaments, float mcuadrats) {
        super(nom, estat, accesibilitat, allotjaments);  // Crida al constructor de la classe base Acces
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = allotjaments;
        this.mcuadrats = mcuadrats;
    }

    // Getter i Setter per a la superfície asfaltada
    public float getMcuadrats() {
        return mcuadrats;
    }

    public void setMcuadrats(float mcuadrats) {
        this.mcuadrats = mcuadrats;
    }

    // Mètode toString per mostrar la informació de l'accés asfaltat
    @Override
    public String toString() {
        return "AccesAsfalt{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + isAccessibilitat() +
                ", mcuadrats=" + mcuadrats +
                ", allotjaments=" + allotjaments.size() +
                '}';
    }
}
