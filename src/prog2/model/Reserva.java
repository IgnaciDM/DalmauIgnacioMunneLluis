package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import prog2.vista.ExcepcioReserva;

public class Reserva {
    // Atributs de la classe Reserva.
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor que inicialitza la reserva amb l'allotjament, el client i les dates d'entrada i sortida.
    // Si la data de sortida és anterior a la data d'entrada, llança una excepció.
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        if (dataSortida.isBefore(dataEntrada)) {  // Comprova si la data de sortida és anterior a la de entrada.
            // Llança una excepció amb un missatge d'error si la data de sortida és incorrecta.
            throw new ExcepcioReserva("La data de sortida no pot ser anterior a la data d'entrada.");
        }
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    // Mètodes getters per obtenir els valors dels atributs de la classe Reserva.

    public LocalDate getDataEntrada() {
        return dataEntrada;  // Retorna la data d'entrada de la reserva.
    }

    public LocalDate getDataSortida() {
        return dataSortida;  // Retorna la data de sortida de la reserva.
    }

    public Allotjament getAllotjament() {
        return allotjament;  // Retorna l'allotjament de la reserva.
    }

    public Client getClient() {
        return client;  // Retorna el client que ha fet la reserva.
    }

    // Mètodes setters per modificar els valors dels atributs de la classe Reserva.

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;  // Modifica la data d'entrada de la reserva.
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;  // Modifica la data de sortida de la reserva.
    }

    public void setAllotjament_(Allotjament nouAllotjament) {
        this.allotjament = nouAllotjament;  // Modifica l'allotjament associat a la reserva.
    }

    public void setClient(Client nouClient) {
        this.client = nouClient;  // Modifica el client associat a la reserva.
    }
}
