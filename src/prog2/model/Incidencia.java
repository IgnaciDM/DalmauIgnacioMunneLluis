package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Incidencia {
    private int idIncidencia;
    private String Tipus;
    private Allotjament Allotjament;
    private String data;

    public Incidencia(int idIncidencia, String Tipus, Allotjament Allotjament, String data) {
        this.idIncidencia = idIncidencia;
        this.Allotjament = Allotjament;
        this.Tipus = Tipus;
        this.data = data;
    }

    public int getidIncidencia() {
        return idIncidencia;
    }

    public void setidIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Allotjament getAllotjament() {
        return Allotjament;
    }

    public void setAllotjament(Allotjament idAllotjament) {
        this.Allotjament = idAllotjament;
    }

    public String getTipus() {
        return Tipus;
    }

    public void setTipus(String Tipus) {
        this.Tipus = Tipus;
    }

    public String getdata() {
        return data;
    }

    public void setdata(String data) {
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
