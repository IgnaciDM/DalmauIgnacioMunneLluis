package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> llistaAccessos;
    private ArrayList<AccesAsfalt> llistaAccessosAsfalt;

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        llistaAccessos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    public void buidar() {
        llistaAccessos = new ArrayList<>();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     */
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String llista = "";
        for (int i = 0; i < llistaAccessos.size(); i++) {
            if (llistaAccessos.get(i).getestat() == estat) {
                llista += llistaAccessos.get(i).toString();
            }
        }
        if (llista.equals("")) {
            throw new ExcepcioCamping("No hi ha cap acces amb aquest estat");
        }
        return llista;
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (int i = 0; i < llistaAccessos.size(); i++) {
            boolean operatiu = false;
            for (int j = i + 1; j < llistaAccessos.get(i).getacces_a_Allotjaments().size(); j++) {
                if (llistaAccessos.get(i).getacces_a_Allotjaments().get(j).esOperatiu() == true) {
                    llistaAccessos.get(i).setestat(true);
                    operatiu = true;
                }
            }
            if (!operatiu) {
                llistaAccessos.get(i).setestat(false);
            }
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos amb accessibilitat.
     *
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int num = 0;
        for (int i = 0; i < llistaAccessos.size(); i++) {
            if (llistaAccessos.get(i).getaccesibilitat() == true) {
                num++;
            }
        }
        return num;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos asfaltats suma els metres quadrats d'asfalt i ho retorna.
     * @return float amb els metres quadrats d'asfalt.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        int num = 0;
        for (int i = 0; i < llistaAccessosAsfalt.size(); i++) {
            num += llistaAccessosAsfalt.get(i).getmcuadrats();
        }
        return num;
    }
}
