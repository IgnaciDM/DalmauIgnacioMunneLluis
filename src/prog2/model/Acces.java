package prog2.model;

import java.util.ArrayList;

public class Acces {
    private String nom;
    private boolean estat; // Si l'accés està obert o tancat
    private boolean accessibilitat;
    private ArrayList<Allotjament> allotjaments; // Llista d'allotjaments accessibles des d'aquest accés

    public Acces(String nom, boolean accesibilitat, float longitud) {
        this.nom = nom;
        this.estat = estat;
        this.accessibilitat = accessibilitat;
        this.allotjaments = allotjaments;
    }


    public void afegirAllotjament(Allotjament allotjament) {
        this.allotjaments.add(allotjament);
    }

    public void tancarAcces() {
        this.estat = false;
    }

    public void obrirAcces() {
        this.estat = true;
    }

    public boolean isAccessibilitat() {
      return accessibilitat;
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

    public ArrayList<Allotjament> getAccesAAllotjaments() {
        return allotjaments;
    }

    public void setAllotjaments(ArrayList<Allotjament> allotjaments) {
        this.allotjaments = allotjaments;
    }
}