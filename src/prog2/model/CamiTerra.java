package prog2.model;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, true, new ArrayList<>(), longitud);
    }
    public boolean isAccessibilitat() {
        return false;
    }
}
