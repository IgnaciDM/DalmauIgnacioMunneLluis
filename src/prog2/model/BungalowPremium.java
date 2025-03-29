package prog2.model;

// Classe que representa un Bungalow Premium, que és un tipus d'allotjament
public class BungalowPremium extends Casa {

    // Atributs propis del Bungalow Premium
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor per inicialitzar els atributs del Bungalow Premium
    public BungalowPremium(String nom, String idAllotjament,boolean estat, String iluminacio, float mida,int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        // Crida al constructor de la classe pare amb valors fixos per defecte
        super(nom, idAllotjament, mida, habitacions, placesPersones, estat, iluminacio);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }


    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    // Mètode per determinar si el bungalow és operatiu
    public boolean esOperatiu() {
        // El bungalow es considera operatiu si té aire condicionat i un codi wifi vàlid (entre 8 i 16 caràcters)
        return getEstat();
    }

    public void tancarAllotjament(Incidencia in) {
        setEstat(false);
        if (in.getIluminacioAllotjament() != null) {
            setIluminacio(in.getIluminacioAllotjament());
        } else {
            System.out.println("Avís: Il·luminació no especificada.");
        }
    }

    public void obrirAllotjament() {
        setEstat(true);
        setIluminacio("100%");
    }

    // Mètode toString per representar l'objecte en format text
    @Override
    public String toString() {
        return super.toString()  + ", placesParquing=" + placesParquing
                + ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + serveisExtra + ", codiWifi=" + codiWifi + "]";
    }

    public String getCodiWifi() {
        return codiWifi;
    }
}
