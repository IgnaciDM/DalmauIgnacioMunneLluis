package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaIncidencies {
    private ArrayList<Incidencia> llistaincidencias;
    /**
     * Aquest mètode crea una incidència amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït i la data) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una incidència si ja té una incidència s'ha de llançar una excepció.
     * Una vegada creada la incidència s'ha de tancar (no operatiu) l'allotjament corresponent.
     * @param num Número d'identificació de la incidència.
     * @param tipus Aquest String permet crear el enum TipusIncidencia
     * @param allotjament Allotjament on es produeix la incidència
     * @param data Data quan es produeix la incidència.
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una incidència o si el tipus d’incidència que es vol afegir no existeix.
     */
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping{
        if (allotjament.getestat() != "correcte") {
            throw new ExcepcioCamping("Aquest allotjament ja te una incidencia");
        } else {
            Incidencia incidencia = new Incidencia (num, tipus, allotjament, data);
            llistaincidencias.add(incidencia);
            allotjament.setestat(tipus);
        }
    }
    /**
     * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param in Objecte de tipus Incidència
     * @throws ExcepcioCamping
     */
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping{
        boolean incidencia = false;
        for (int i = 0; i < llistaincidencias.size(); i++) {
            if (llistaincidencias.get(i).equals(in)) {
                llistaincidencias.remove(i);
                llistaincidencias.get(i).getAllotjament().setestat("correcte");
                incidencia = true;
            }
        }
        if (incidencia == false) {
            throw  new ExcepcioCamping("No s'ha trobat la incidencia");
        }
    }

    /**
     * Itera sobre la llista d'incidències i retorna un String amb la informació de totes les incidències.
     * En cas que no hi hagi cap incidència llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
    public String llistarIncidencies() throws ExcepcioCamping{
        String llista = "";
        for (int i = 0; i < llistaincidencias.size(); i++) {
            llista += llistaincidencias.get(i).toString();
        }
        if (llista.equals("")) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat");
        }
        return llista;
    }

    /**
     * Busca la incidència amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la incidència.
     * @return Objecte de tipus Incidència
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap incidència amb el número passat per paràmetre.
     */
    public Incidencia getIncidencia(int num) throws ExcepcioCamping{
        for (int i = 0; i < llistaincidencias.size(); i++) {
            if (llistaincidencias.get(i).getidIncidencia() == num) {
                return llistaincidencias.get(i);
            }
        }
        throw new ExcepcioCamping("No s'ha trobat la incidencia amb aquest numero");
    }
}
