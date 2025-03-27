package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra {
    private float longitud; // Longitud en metres
    private float amplada; // Amplada de la carretera

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat);
        this.longitud = longitud;
        this.amplada = amplada;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }
}
