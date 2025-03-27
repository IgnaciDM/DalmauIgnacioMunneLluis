package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra {
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    public float getamplada() {
        return amplada;
    }

    public void setamplada(float amplada) {
        this.amplada = amplada;
    }

    public boolean isAccessibilitat() {
        return true;
    }
}
