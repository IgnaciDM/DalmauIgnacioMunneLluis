package prog2.model;

public class Parcela {
    // Atributos de la clase Bungalow
    private String nom;
    private String idAllotjament;
    private float metres;
    private boolean connexioElectrica;

    // Constructor para inicializar los atributos
    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica) {
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters y setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdAllotjament() {
        return idAllotjament;
    }

    public void setIdAllotjament(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    public float getmetres() {
        return metres;
    }

    public void setmetres(float metres) {
        this.metres = metres;
    }

    public boolean getHabitacions() {
        return connexioElectrica;
    }

    public void setHabitacions(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    // Método toString para imprimir el objeto en formato legible
    @Override
    public String toString() {
        return "Parcela [nom=" + nom + ", idAllotjament=" + idAllotjament + ", mida=" + metres + ", habitacions="
                + connexioElectrica + "]";
    }
}
