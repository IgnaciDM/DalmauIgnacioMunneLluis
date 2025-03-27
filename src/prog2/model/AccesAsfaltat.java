package prog2.model;

import java.util.ArrayList;

public class AccesAsfaltat {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> allotjaments;
    private float mcuadrats;  // Superfície asfaltada en metres quadrats

    // Constructor de la classe AccesAsfalt
    public AccesAsfaltat(String nom, boolean estat, boolean accesibilitat, ArrayList<Allotjament> allotjaments, float mcuadrats) {
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.allotjaments = allotjaments;
        this.mcuadrats = mcuadrats;
    }

    // Getter i Setter per al nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter i Setter per a la accessibilitat
    public boolean getAccesibilitat() {
        return accesibilitat;
    }

    public void setAccesibilitat(boolean accesibilitat) {
        this.accesibilitat = accesibilitat;
    }

    // Getter i Setter per l'estat
    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    // Getter i Setter per a llistat de allotjaments
    public ArrayList<Allotjament> getAccesAAllotjaments() {
        return allotjaments;
    }

    public void setAccesAAllotjaments(ArrayList<Allotjament> accesAAllotjaments) {
        this.allotjaments = accesAAllotjaments;
    }

    // Getter i Setter per a la superfície asfaltada
    public float getMcuadrats() {
        return mcuadrats;
    }

    public void setMcuadrats(float mcuadrats) {
        this.mcuadrats = mcuadrats;
    }

    // Mètode toString per mostrar la informació de l'accés asfaltat
    @Override
    public String toString() {
        return "AccesAsfalt{" +
                "nom='" + nom + '\'' +
                ", accesibilitat=" + accesibilitat +
                ", estat=" + estat +
                ", mcuadrats=" + mcuadrats +
                ", allotjaments=" + allotjaments.size() +
                '}';
    }
}
