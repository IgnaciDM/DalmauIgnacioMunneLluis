package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Acces implements InAcces, Serializable {
    private String nom;
    private boolean estat; // Si l'accés està obert o tancat
    private boolean accessibilitat;
    private ArrayList<Allotjament> allotjaments; // Llista d'allotjaments accessibles

    public Acces(String nom, boolean accesibilitat, float longitud) {
        this.nom = nom;
        this.estat = true;  // Inicialitza estat a true per defecte (es pot modificar si cal)
        this.accessibilitat = accesibilitat;
        this.allotjaments = new ArrayList<>();  // INICIALITZEM LA LLISTA!!!
    }

    public void afegirAllotjament(Allotjament allotjament) {
        if (allotjament != null) {
            this.allotjaments.add(allotjament);
        }
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
        if (allotjaments != null) {
            this.allotjaments = allotjaments;
        }
    }
}
