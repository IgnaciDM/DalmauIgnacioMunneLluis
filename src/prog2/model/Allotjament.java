package prog2.model;

import java.time.LocalDate;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    // Constructor que inicialitza els atributs i les estades mínimes per temporada
    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        setEstadaMinima(estadaMinimaAlta, estadaMinimaBaixa);
    }

    @Override
    public String getNom() {
        return nom;  // Retorna el nom de l'allotjament
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;  // Estableix el nom de l'allotjament
    }

    @Override
    public String getId() {
        return id;  // Retorna l'identificador de l'allotjament
    }

    @Override
    public void setId(String id) {
        this.id = id;  // Estableix l'identificador de l'allotjament
    }

    // Retorna l'estada mínima segons la temporada (ALTA o BAIXA)
    @Override
    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaMinimaAlta : estadaMinimaBaixa;
    }

    // Estableix les estades mínimes per temporada alta i baixa
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    // Retorna els dies mínims d'estada segons la temporada actual
    public long getDiesEstada() {
        LocalDate avui = LocalDate.now();  // Data actual
        Temp temporada = determinarTemporada(avui);  // Determina la temporada actual
        return getEstadaMinima(temporada);  // Retorna l'estada mínima per la temporada
    }

    // Sempre retorna true, indicant que l'allotjament funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return true;
    }

    // Retorna una descripció llegible de l'allotjament
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaAlta + ", estada mínima en temp BAIXA: " + estadaMinimaBaixa + ".";
    }

    // Determina la temporada (ALTA o BAIXA) segons el mes actual
    public Temp determinarTemporada(LocalDate data) {
        int mes = data.getMonthValue();  // Obté el mes de la data proporcionada
        return (mes >= 6 && mes <= 8) ? Temp.ALTA : Temp.BAIXA;  // Temporada alta: juny-agost
    }

    // Verifica si l'allotjament està operatiu
    public boolean esOperatiu() {
        return correcteFuncionament();
    }
}

