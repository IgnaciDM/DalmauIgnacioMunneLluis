package prog2.model;

import java.util.ArrayList;

public class AccesTerra extends Acces {
    private int longitud;  // Longitud del camí de terra en metres

    // Constructor de la classe AccesTerra
    public AccesTerra(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> accesAAllotjaments, int longitud) {
        super(nom, accesibilitat, estat, accesAAllotjaments);  // Crida al constructor de la classe base Acces
        this.longitud = longitud;  // Inicialitza la longitud del camí de terra
    }

    // Getter per a la longitud
    public int getLongitud() {
        return longitud;
    }

    // Setter per a la longitud
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    // Mètode toString per representar la informació de l'accés terra
    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud + " metres";
    }
}
