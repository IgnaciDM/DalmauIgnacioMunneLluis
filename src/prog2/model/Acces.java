package prog2.model;

import java.util.ArrayList;

public class Acces {
    private String nom;
    private String Tipus;
    private String caracteristiques;
    private boolean accesibilitat;
    private boolean estat;
    private ArrayList<Allotjament> acces_a_Allotjaments;

    public Acces(String nom, String Tipus, String caracteristiques, boolean accesibilitat, boolean estat, ArrayList<Allotjament> acces_a_Allotjaments) {
        this.nom = nom;
        this.Tipus = Tipus;
        this.caracteristiques = caracteristiques;
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

    public String getTipus() {
        return Tipus;
    }

    public void setTipus(String Tipus) {
        this.Tipus = Tipus;
    }

    public String getcaracteristiques() {
        return caracteristiques;
    }

    public void setcaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
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

    public void setAcces_a_Allotjaments(ArrayList<Allotjament> acces_a_Allotjaments) {
        this.acces_a_Allotjaments = acces_a_Allotjaments;
    }

    public void afegirAllotjament(Allotjament allotjament) {
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

