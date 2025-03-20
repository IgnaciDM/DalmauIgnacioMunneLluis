package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casamascota;

    // Constructor para inicializar los atributos
    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casamascota, boolean estat, String iluminacio) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, estat, iluminacio);
        this.material = material;
        this.casamascota = casamascota;
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

    public boolean esOperatiu() {
        return casamascota;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", "") + ", material=" + material + ", casamascota=" + casamascota + "]";
    }
}