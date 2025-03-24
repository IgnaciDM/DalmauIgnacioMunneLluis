package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies{
    private ArrayList<Incidencia> llistaincidencias;
    private LlistaAllotjaments llistaAllotjaments;//Implementem la clase llista Alltjaments

    public LlistaIncidencies() {//CONSTRUCTOR
        this.llistaincidencias = new ArrayList<>();
        this.llistaAllotjaments = llistaAllotjaments;
    }

    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        if (!llistaAllotjaments.contains(allotjament)) {//Comprobacio de que dins de la llista d'aAllotjaments estigui el allotjament al cual volem ferli una incidencia
            throw new ExcepcioCamping("No existeix l'allotjament seleccionat.");
        }else{
            Incidencia incidencia = new Incidencia(num, tipus, allotjament, data);
            llistaincidencias.add(incidencia);
            System.out.println("Incidencia agregada correctament");
        }
    }


    /**
     * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param in Objecte de tipus Incidència
     * @throws ExcepcioCamping
     */
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping{
        llistaincidencias.remove(in);
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
            throw new ExcepcioCamping("No hi ha cap incidencia");
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
            if(llistaincidencias.get(i).getidIncidencia() == num) {//Eliminat estat.equals(TOTS)
                return llistaincidencias.get(i);
            }
        }
        throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat");
    }
}
