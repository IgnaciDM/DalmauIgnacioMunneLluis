package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Incidencia {
    private String idIncidencia;
    private String Allotjament;
    private String Tipus;
    private LocalDate data;

    public Incidencia(String idIncidencia, String Allotjament, String Tipus, LocalDate data) {
        this.idIncidencia = idIncidencia;
        this.Allotjament = Allotjament;
        this.Tipus = Tipus;
        this.data = data;
    }

    public String getidIncidencia() {
        return idIncidencia;
    }

    public void setidIncidencia(String idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getAllotjament() {
        return Allotjament;
    }

    public void setAllotjament(String idAllotjament) {
        this.Allotjament = idAllotjament;
    }

    public String getTipus() {
        return Tipus;
    }

    public void setTipus(String Tipus) {
        this.Tipus = Tipus;
    }

    public LocalDate getdata() {
        return data;
    }

    public void setdata(LocalDate data) {
        this.data = data;
    }

    public static enum TipusIncidencia {Reparacio, Neteja, Tancament}

    public String getIluminacioAllotjament() {
        return"";//MODIFICAR
    }

    public String toString() {
        String TipusIncidencia="";
        return "Id=" + idIncidencia + ", Allotjament=" + Allotjament + ", Tipus= " + Tipus + ", data= " + data + ", tipus de Incidencia= " + TipusIncidencia + ".";
    }
}
