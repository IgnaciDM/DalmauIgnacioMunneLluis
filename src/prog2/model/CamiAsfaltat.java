package prog2.model;

import java.util.ArrayList;

public class CamiAsfaltat extends AccesAsfaltat {// Metres quadrats d'asfalt

    public CamiAsfaltat(String nom, boolean estat,float asfalt) {
        super(nom, estat, true, new ArrayList<>(), asfalt);
    }
}
