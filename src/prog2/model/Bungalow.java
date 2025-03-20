package prog2.model;

import java.time.LocalDate;

public class Bungalow extends Casa {
    // Atributos de la clase Bungalow
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    // Constructor para inicializar los atributos
    public Bungalow(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean estat, String iluminacio) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, estat, iluminacio);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }



    // Getters y setters


    public int getPlacesParquing() {
        return placesParquing;
    }

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    public boolean esOperatiu() {
        return aireFred;
    }

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return super.toString()  + ", placesParquing=" + placesParquing
                + ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + "]";
    }
}
