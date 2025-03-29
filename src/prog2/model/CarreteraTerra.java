package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float longitud;
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, true, new ArrayList<>(), longitud);
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
        this.longitud = longitud;
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

    @Override
    public String toString() {
        return "CarreteraTerra{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + isAccessibilitat() +
                ", longitud=" + longitud +
                ", amplada=" + amplada +
                ", allotjaments=" + super.getAccesAAIdllotjaments() +
                '}';
    }
}
