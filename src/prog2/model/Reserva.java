package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import prog2.vista.ExcepcioReserva;

public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor amb validació de dates
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        if (dataSortida.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data de sortida no pot ser anterior a la data d'entrada.");
        }
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }
    // Getters
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public Client getClient() {
        return client;
    }

    // Setters
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    public void setAllotjament_(Allotjament nouAllotjament) {
        this.allotjament = nouAllotjament;
    }

    public void setClient(Client nouClient) {
        this.client = nouClient;
    }
}