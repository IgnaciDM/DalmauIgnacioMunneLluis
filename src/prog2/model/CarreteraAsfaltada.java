package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfaltada extends AccesAsfaltat {
    private float asfalt; // Metres quadrats d'asfalt
    private float pesMaxim; // Pes màxim permès

    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pesMaxim) {
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
