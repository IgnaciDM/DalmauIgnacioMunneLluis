package prog2.model;

public class Casa extends Allotjament {
    // Atributos de la clase Casa
    private String mida;
    private int habitacions;
    private int placesPersones;

    // Constructor para inicializar los atributos
    public Casa(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean estat, String iluminacio) {
        super(nom, idAllotjament,7,4, estat, iluminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    // Getters y setters

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

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return super.toString()  + ", mida=" + mida + ", habitacions="
                + habitacions + ", placesPersones=" + placesPersones + "]";
    }
}
