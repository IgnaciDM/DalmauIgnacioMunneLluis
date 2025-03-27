package prog2.model;

import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfaltat {// Metres quadrats d'asfalt
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float asfalt;

    public CamiAsfaltat(String nom, boolean estat,float asfalt) {
        super(nom, estat, asfalt);
    }


    public float getAsfalt() {
        return asfalt;
    }

    public void setAsfalt(float mcuadrats) {
        this.asfalt = asfalt;
    }
}
