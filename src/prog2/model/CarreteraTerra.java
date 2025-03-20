package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra{

    public CarreteraTerra(String nom, boolean accesibilitat, boolean estat,ArrayList<Allotjament> acces_a_Allotjaments, int longitud) {
        super(nom, accesibilitat, estat, acces_a_Allotjaments, longitud);
    }

    public boolean isAccessibilitat() {
        return true;
    }
}
