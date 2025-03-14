package prog2.model;

// La classe Parcela és una subclasse d'Allotjament que representa un tipus d'allotjament específic anomenat Parcela.
public class Parcela extends Allotjament {

    // Atributs específics de la classe Parcela.
    private float metres;
    private boolean connexioElectrica;

    // Constructor per inicialitzar els atributs de la classe Parcela.
    // Crida al constructor de la classe pare (Allotjament) per establir alguns valors predeterminats (4 i 2).
    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica, boolean estat, String iluminacio) {
        super(nom, idAllotjament, 4, 2, estat, iluminacio);
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    // Mètodes getters i setters per accedir i modificar els atributs de la classe Parcela.

    public float getMida() {
        return metres;  // Retorna la mida de la parcel·la en metres quadrats.
    }

    public void setMida(float metres) {
        this.metres = metres;  // Assigna una nova mida a la parcel·la.
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;  // Retorna si la parcel·la té connexió elèctrica.
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;  // Assigna un valor per indicar si la parcel·la té connexió elèctrica.
    }

    // Mètode que retorna si la parcel·la és operativa o no. En aquest cas, depèn de si té connexió elèctrica.
    public boolean esOperatiu() {
        return connexioElectrica;  // Retorna si la parcel·la té connexió elèctrica.
    }

    // Mètode toString que retorna una representació textual de l'objecte Parcela.
    // Aquest mètode imprimeix el nom, identificador i les estades mínimes en diferents temporades.
    @Override
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) + ".";  // Retorna una cadena amb informació detallada.
    }

    // Mètode correcteFuncionament que retorna un valor booleà per indicar si la parcel·la funciona correctament.
    // Només serà operativa si té connexió elèctrica.
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;  // Retorna si la parcel·la té connexió elèctrica per considerar-se operativa.
    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
}

