package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private static ArrayList<Allotjament> llistaAllotjament;
    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     * @param allotjament Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        llistaAllotjament.add(allotjament);
    }


    /**
     * Buida la llista d'allotjaments.
     */
    public void buidar(){
        llistaAllotjament = new ArrayList<>();
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     * @param estat
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping{
        String llista = "";
        for (int i = 0; i < llistaAllotjament.size(); i++) {
            if((llistaAllotjament.get(i).esOperatiu()).equals(estat)) {
                llista += llistaAllotjament.get(i).toString();
            }
        }
        if (llista.equals("")) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat");
        }
        return llista;
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     * @return boolean
     */
    public boolean containsAllotjamentOperatiu(){
        for (int i = 0; i < llistaAllotjament.size(); i++) {
            if (llistaAllotjament.get(i).getestat() == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     * @param allotjament
     * @return boolean
     */

    public boolean contains(Allotjament allotjament){
        for (int i = 0; i < llistaAllotjament.size(); i++) {
            if (llistaAllotjament.get(i) == allotjament) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     * @param id String amb el nom de l'allotjament
     * @return  Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping{
        for (int i = 0; i < llistaAllotjament.size(); i++) {
            if (llistaAllotjament.get(i).getNom().equals(id)) {
                return llistaAllotjament.get(i);
            }
        }
        throw new ExcepcioCamping("No hi ha cap allotjament amb aquest nom");
    }
}
