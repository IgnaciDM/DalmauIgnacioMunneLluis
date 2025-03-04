package prog2.model;

import java.time.LocalDate;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        setEstadaMinima(estadaMinimaAlta, estadaMinimaBaixa);
    }

    @Override
    public String getNom() {
        System.out.println("NOM Allotjament");
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaMinimaAlta : estadaMinimaBaixa;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    @Override
    public boolean correcteFuncionament() {
        // Com que és una classe abstracta, deixem que les subclasses implementin aquest mètode.
        return true;
    }

    @Override
    public String toString() {
        return "Nom="+nom+", Id="+id+", estada mínima en temp ALTA: "+estadaMinimaAlta+", estada mínima en temp BAIXA: "+estadaMinimaBaixa+".";
    }
    public Temp determinarTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        return (mes >= 6 && mes <= 8) ? Temp.ALTA : Temp.BAIXA; // Exemple: juny-agost és temporada alta
    }

}
