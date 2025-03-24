package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.time.LocalDate;
import java.util.ArrayList;

public class Incidencia {
    private int idIncidencia;
    private TipusIncidencia Tipus;
    private Allotjament Allotjament;
    private String data;

    public Incidencia(int idIncidencia, String Tipus, Allotjament Allotjament, String data) {
        this.idIncidencia = idIncidencia;
        this.Allotjament = Allotjament;
        this.data = data;
        switch (Tipus) {
            case "Reparacio":
                this.Tipus = TipusIncidencia.Reparacio;
                break;
            case "Neteja":
                this.Tipus = TipusIncidencia.Neteja;
                break;
            case "Tancament":
                this.Tipus = TipusIncidencia.Tancament;
                break;
        }
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

    public TipusIncidencia getTipus() {
        return Tipus;
    }

    public void setTipus(TipusIncidencia Tipus) {
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
        switch (Tipus) {
            case Reparacio:
                return "100%";
            case Neteja:
                return "50%";
            case Tancament:
                return "0%";
        }
        return null;
    }

    public String toString() {
        String TipusIncidencia="";
        return "Id=" + idIncidencia + ", Allotjament=" + Allotjament + ", Tipus= " + Tipus + ", data= " + data + ", tipus de Incidencia= " + TipusIncidencia + ".";
    }
}
