package prog2.model;

import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfaltat {// Metres quadrats d'asfalt
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;

    public CamiAsfaltat(String nom, boolean estat,float asfalt) {
        super(nom, estat, true, new ArrayList<>(), asfalt);
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
        this.mcuadrats = mcuadrats;
    }
    public boolean isAccessibilitat() {
        return false;
    }

    public float getMcuadrats() {
        return super.getMcuadrats();
    }

    @Override
    public String toString() {
        return "CamiAsfalt{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + isAccessibilitat() +
                ", mcuadrats=" + mcuadrats +
                ", allotjaments=" + super.getAccesAAIdllotjaments() +
                '}';
    }
}
