package prog2.model;

import java.util.ArrayList;

public class AccesTerra extends Acces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float longitud;  // Longitud del camí de terra en metres

    // Constructor de la classe AccesTerra
    public AccesTerra(String nom, boolean estat, boolean accesibilitat, ArrayList<Allotjament> allotjaments, float longitud) {
        super(nom, accesibilitat, estat, allotjaments);  // Crida al constructor de la classe base Acces
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = allotjaments;
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
}
