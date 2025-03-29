// Classe CarreteraAsfaltada
package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfaltada extends AccesAsfaltat {
    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat,  float mcuadrats, float pesMaxim) {
        super(nom, estat, true, new ArrayList<>(), mcuadrats);
        this.pesMaxim = pesMaxim;
    }

    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public float getMcuadrats() {
        return super.getMcuadrats();
    }
}