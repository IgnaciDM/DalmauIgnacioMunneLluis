package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfalt extends AccesAsfalt{

    public CarreteraAsfalt(String nom, boolean accesibilitat, boolean estat,ArrayList<Allotjament> acces_a_Allotjaments, int mcuadrats) {
        super(nom, accesibilitat, estat, acces_a_Allotjaments, mcuadrats);
    }

    public boolean isAccessibilitat() {
        return true;
    }
}
