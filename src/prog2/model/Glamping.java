package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casamascota;

    // Constructor para inicializar los atributos
    public Glamping(String nom, String idAllotjament,boolean estat,String iluminacio, float mida, int habitacions, int placesPersones, String material, boolean casamascota) {
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

    @Override
    public String toString() {
        return super.toString() + ", material=" + material + ", casamascota=" + casamascota + "]";
    }

    public String getMaterial() {
        return material;
    }

    public boolean isCasamascota() {
        return casamascota;
    }
}