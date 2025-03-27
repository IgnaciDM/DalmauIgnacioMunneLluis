package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments,Serializable {
    private ArrayList<Allotjament> llistaAllotjament;

    // Constructor
    public LlistaAllotjaments() {
        this.llistaAllotjament = new ArrayList<>();
    }

    public ArrayList<Allotjament> getLlistaAllotjament() {
        return llistaAllotjament;
    }
    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     */
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjament.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    public void buidar() {
        llistaAllotjament = new ArrayList<>();
    }

    /**
     * Retorna una llista amb els allotjaments que coincideixen amb l'estat donat.
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder llista = new StringBuilder();

        for (Allotjament allotjament : llistaAllotjament) {
            boolean operatiu = allotjament.getEstat(); // Suponiendo que devuelve true si está operativo

            // Filtrar en función del parámetro estat
            if (estat.equals("Tots") || (estat.equals("Operatiu") && operatiu==true) || (estat.equals("NoOperatiu") && operatiu==false)) {
                llista.append(allotjament.toString()).append("\n");
            }
        }
        if (llista.length() == 0) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat.");
        }
        return llista.toString();
    }


    /**
     * Retorna si hi ha algun allotjament operatiu.
     */
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : llistaAllotjament) {
            if (allotjament.getEstat()==true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un allotjament específic està a la llista.
     */
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjament.contains(allotjament);
    }

    /**
     * Retorna un allotjament pel seu ID. Llança una excepció si no existeix.
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament allotjament : llistaAllotjament) {
            if (allotjament.getId().equalsIgnoreCase(id)) {
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No hi ha cap allotjament amb aquest nom.");
    }
}
