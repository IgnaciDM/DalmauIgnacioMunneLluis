package prog2.model;

public class CamiAsfaltat extends Acces {
    private float asfalt; // Metres quadrats d'asfalt

    public CamiAsfaltat(String nom, boolean estat, float asfalt) {
        super(nom, estat);
        this.asfalt = asfalt;
    }

    public float getAsfalt() {
        return asfalt;
    }

    public void setAsfalt(float asfalt) {
        this.asfalt = asfalt;
    }
}
