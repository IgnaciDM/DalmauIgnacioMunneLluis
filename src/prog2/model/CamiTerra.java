package prog2.model;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra {
    private float longitud; // Longitud en metres

    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
}
