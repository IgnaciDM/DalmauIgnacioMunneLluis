package prog2.model;

import java.util.ArrayList;

public class AccesTerra extends Acces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> accesAAllotjaments;
    private float longitud;  // Longitud del camí de terra en metres

    // Constructor de la classe AccesTerra
    public AccesTerra(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> accesAAllotjaments, float longitud) {
        super(nom, accesibilitat, estat, accesAAllotjaments);  // Crida al constructor de la classe base Acces
        this.longitud = longitud;  // Inicialitza la longitud del camí de terra
    }

    // Getter per a la longitud
    public float getLongitud() {
        return longitud;
    }

    // Setter per a la longitud
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    // Mètode toString per representar la informació de l'accés terra
    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud + " metres";
    }
}
