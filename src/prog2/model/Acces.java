package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> acces_a_Allotjaments;

    public Acces(String nom, boolean accesibilitat, boolean estat, ArrayList<Allotjament> acces_a_Allotjaments) {
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
        this.acces_a_Allotjaments = acces_a_Allotjaments;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getaccesibilitat() {
        return accesibilitat;
    }

    public void setAccesibilitat(boolean accesibilitat) {
        this.accesibilitat = accesibilitat;
    }

    public boolean getestat() {return estat;
    }

    public void setestat(boolean estat) {
        this.estat = estat;
    }

    public ArrayList<Allotjament> getacces_a_Allotjaments() {
        return acces_a_Allotjaments;
    }

    public void setacces_a_Allotjaments(ArrayList<Allotjament> acces_a_Allotjaments) {
        this.acces_a_Allotjaments = acces_a_Allotjaments;
    }

    public void afegirAllotjament(Allotjament allotjament) {
    }

    public String toString() {
        return "Nom=" + nom + ", accesibilitat=" + accesibilitat + ", estat= " + estat + ", acces als Allotjaments= " + acces_a_Allotjaments + ".";
    }
    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces() {
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    public void obrirAcces() {
    }


    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return
     */
    public boolean isAccessibilitat() {
        return false;//MODIFICAR
    }
}

