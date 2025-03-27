package prog2.model;

import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfaltat {// Metres quadrats d'asfalt
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;

    public CamiAsfaltat(String nom, boolean estat, boolean accesibilitat, ArrayList<Allotjament> allotjaments, float mcuadrats) {
        super(nom, estat, accesibilitat, allotjaments, mcuadrats);
    }

    public float getAsfalt() {
        return mcuadrats;
    }

    public void setAsfalt(float mcuadrats) {
        this.mcuadrats = mcuadrats;
    }
}
