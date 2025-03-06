package prog2.model;

// Classe que representa un Bungalow Premium, que és un tipus d'allotjament
public class BungalowPremium extends Allotjament {

    // Atributs propis del Bungalow Premium
    private String nom;
    private String idAllotjament;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor per inicialitzar els atributs del Bungalow Premium
    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        // Crida al constructor de la classe pare amb valors fixos per defecte
        super(nom, idAllotjament, 7, 4);
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // Mètodes getters i setters per accedir i modificar els atributs
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

    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    // Mètode per determinar si el bungalow és operatiu
    public boolean esOperatiu() {
        // El bungalow es considera operatiu si té aire condicionat i un codi wifi vàlid (entre 8 i 16 caràcters)
        return aireFred && codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }

    // Mètode toString per representar l'objecte en format text
    @Override
    public String toString() {
        return "Bungalow [nom=" + nom + ", idAllotjament=" + idAllotjament + ", mida=" + mida + ", habitacions="
                + habitacions + ", placesPersones=" + placesPersones + ", placesParquing=" + placesParquing
                + ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + "]";
    }
}
