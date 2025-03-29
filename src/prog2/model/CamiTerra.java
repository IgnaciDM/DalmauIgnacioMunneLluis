package prog2.model;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float longitud;

    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, true, new ArrayList<>(), longitud);
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
        this.longitud = longitud;
    }
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString() {
        return "CamiTerra{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + isAccessibilitat() +
                ", longitud=" + longitud +
                ", allotjaments=" + super.getAccesAAIdllotjaments() +
                '}';
    }
}
