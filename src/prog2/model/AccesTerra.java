package prog2.model;

import java.util.ArrayList;

public class AccesTerra extends Acces{
    private int longitud;

    public AccesTerra(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> acces_a_Allotjaments, int longitud) {
        super(nom, accesibilitat, estat, acces_a_Allotjaments);
        this.longitud = longitud;
    }

    public int getlongitud() {
        return longitud;
    }

    public void setlongitud(int longitud) {
        this.longitud = longitud;
    }
    public String toString() {
        return super.toString() + "longitud=" + longitud;
    }
}
