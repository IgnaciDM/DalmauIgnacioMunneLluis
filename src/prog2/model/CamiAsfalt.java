package prog2.model;

import java.util.ArrayList;

public class CamiAsfalt extends Acces {
    private float asfalt; // Metres quadrats d'asfalt

    public CamiAsfalt(String nom, boolean estat, float asfalt) {
        super(nom, estat);
        this.asfalt = asfalt;
    }

    public float getAsfalt() {
        return asfalt;
    }

    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }
}
