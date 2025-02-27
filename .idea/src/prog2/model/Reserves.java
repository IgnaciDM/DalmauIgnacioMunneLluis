package prog2.model;

import java.time.LocalDate;

public class Reserves {
    private String id;
    private String dni;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor
    public Reserves(String id, String dni, LocalDate dataEntrada, LocalDate dataSortida) {
        this.id = id;
        this.dni = dni;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    // Getters y setters (si es necesario)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

}
