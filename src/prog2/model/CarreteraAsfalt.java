package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfalt extends Acces {
    private float asfalt; // Metres quadrats d'asfalt
    private float pesMaxim; // Pes màxim permès

    public CarreteraAsfalt(String nom, boolean estat, float asfalt, float pesMaxim) {
        super(nom, estat);
        this.asfalt = asfalt;
        this.pesMaxim = pesMaxim;
    }

    public float getAsfalt() {
        return asfalt;
    }

    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }

    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }
}
