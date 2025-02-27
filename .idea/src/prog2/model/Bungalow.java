package prog2.model;

public class Bungalow {
    // Atributos de la clase Bungalow
    private String nom;
    private String idAllotjament;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    // Constructor para inicializar los atributos
    public Bungalow(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    // Getters y setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdAllotjament() {
        return idAllotjament;
    }

    public void setIdAllotjament(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    public String getMida() {
        return mida;
    }

    public void setMida(String mida) {
        this.mida = mida;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public int getPlacesPersones() {
        return placesPersones;
    }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

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

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return "Bungalow [nom=" + nom + ", idAllotjament=" + idAllotjament + ", mida=" + mida + ", habitacions="
                + habitacions + ", placesPersones=" + placesPersones + ", placesParquing=" + placesParquing
                + ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + "]";
    }
}
