package prog2.model;

import java.util.ArrayList;
import java.util.List;

public class Acces {
    private String nom;
    private boolean estat; // Si l'accés està obert o tancat
    private List<Allotjament> allotjaments; // Llista d'allotjaments accessibles des d'aquest accés

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
    }

    public Acces(String nom, boolean estat, List<Allotjament> allotjaments) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = allotjaments;
    }

    public Acces(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> accesAAllotjaments) {
    }

    public void afegirAllotjament(Allotjament allotjament) {
        this.allotjaments.add(allotjament);
    }

    // Getters i setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public List<Allotjament> getAccesAAllotjaments() {
        return allotjaments;
    }

    public void setAllotjaments(List<Allotjament> allotjaments) {
        this.allotjaments = allotjaments;
    }

    public boolean getAccesibilitat() {
        return false; // ⚠️ Este método parece incompleto, revisa si necesitas implementarlo correctamente.
    }

    public Allotjament[] getacces_a_Allotjaments() {
        return null;
    }
}