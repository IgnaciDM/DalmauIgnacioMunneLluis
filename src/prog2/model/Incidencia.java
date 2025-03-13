package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Incidencia {
    private String idIncidencia;
    private String idAllotjament;
    private String Tipus;
    private LocalDate data;

    public Incidencia(String idIncidencia, String idAllotjament, String Tipus, LocalDate data) {
        this.idIncidencia = idIncidencia;
        this.idAllotjament = idAllotjament;
        this.Tipus = Tipus;
        this.data = data;
    }

    public String getidIncidencia() {
        return idIncidencia;
    }

    public void setidIncidencia(String idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getidAllotjament() {
        return idAllotjament;
    }

    public void setidAllotjament(String idAllotjament) {
        this.idAllotjament = idAllotjament;
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
}
