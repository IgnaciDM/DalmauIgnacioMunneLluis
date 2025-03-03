package prog2.model;

public class Glamping extends Allotjament {
    // Atributos de la clase Bungalow
    private String nom;
    private String idAllotjament;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private String material;
    private boolean casamascota;

    // Constructor para inicializar los atributos
    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casamascota, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, idAllotjament, estadaMinimaAlta, estadaMinimaBaixa);
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.material = material;
        this.casamascota = casamascota;
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

    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        this.material = material;
    }

    public boolean iscasamascota() {
        return casamascota;
    }

    public void setCasamascota(boolean casamascota) {
        this.casamascota = casamascota;
    }

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return "Glamping [nom=" + nom + ", idAllotjament=" + idAllotjament + ", mida=" + mida + ", habitacions="
                + habitacions + ", placesPersones=" + placesPersones + ", material=" + material
                + ", casmascota=" + casamascota + "]";
    }
}
