package prog2.model;

public class Parcela extends Allotjament {
    // Atributos de la clase Bungalow
    private float metres;
    private boolean connexioElectrica;

    // Constructor para inicializar los atributos
    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica) {
        super(nom, idAllotjament, 4, 2);//FALLA
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters y setters
    public float getMida() {
        return metres;
    }

    public void setMida(float metres) {
        this.metres = metres;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) + ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) + ".";
    }
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica; // Només funciona correctament si té connexió elèctrica
    }

}
