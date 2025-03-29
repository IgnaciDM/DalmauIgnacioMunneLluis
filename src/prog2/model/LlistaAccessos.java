package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos,Serializable {
    private ArrayList<Acces> llistaAccessos;

    public LlistaAccessos() {
        this.llistaAccessos = new ArrayList<>();
    }

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
        StringBuilder llista = new StringBuilder();

        for (Acces acces : llistaAccessos) {
            if (acces.getEstat() == estat) {
                llista.append(acces.toString()).append("\n"); // Agregamos un salto de línea para mayor claridad
            }
        }

        if (llista.length() == 0) {
            throw new ExcepcioCamping("No hi ha cap accés amb aquest estat.");
        }

        return llista.toString();
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces : llistaAccessos) {
            boolean operatiu = false;
            for (Allotjament allotjament : acces.getAccesAAllotjaments()) {
                if (allotjament.esOperatiu()) {
                    acces.obrirAcces();
                    operatiu = true;
                    break;  // Salimos en cuanto encontramos un alojamiento operativo
                }
            }
            if (!operatiu) {
                acces.tancarAcces();
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
            if (llistaAccessos.get(i).isAccessibilitat() == true) {
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
        float num = 0;
        for (Acces acces : llistaAccessos) {
            if (acces instanceof AccesAsfaltat) { // Comprova si és de la subclasse
                num += ((AccesAsfaltat) acces).getMcuadrats(); // Cast per accedir al mètode
            }
        }
        return num;
    }

    public Acces[] getLlistaAccessos() {
        return llistaAccessos.toArray(new Acces[0]);
    }
}
