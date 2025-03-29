// Classe CarreteraAsfaltada
package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfaltada extends AccesAsfaltat {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;
    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat,  float mcuadrats, float pesMaxim) {
        super(nom, estat, true, new ArrayList<>(), mcuadrats);
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
        this.mcuadrats = mcuadrats;
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

    @Override
    public String toString() {
        return "CarreteraAsfalt{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + isAccessibilitat() +
                ", mcuadrats=" + mcuadrats +
                ", PesMaxim=" + pesMaxim +
                ", allotjaments=" + super.getAccesAAIdllotjaments() +
                '}';
    }
}