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

    // Mètode per calcular el nombre de dies d'estada
    public long calcularEstada() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSortida);
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

/*
4.4.1 Classe LocalDate
La classe LocalDate és una classe de la llibreria de Java que permet treballar amb dates.
Per tal d’utilitzar la classe us donem diversos exemples:
- Per definir la data i hora 20 de Febrer del 2025 es fa de la següent manera:
- Donat el dia d’entrada i dia de sortida d’una reserva (LocalDate dataEntrada i
dataSortida) es pot calcular l’estada (en número de dies) de la reserva fent servir la
classe ChronoUnit de Java de la següent manera:
LocalDate date = LocalDate.of (2025, 2, 20);

long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

- Haureu de comparar si l’estada compleix que és més llarga o igual que l’estada
mínima predefinida per l’allotjament en la temporada corresponent a la data
d’entrada (consultar següent secció).

- Haureu de comparar dates i comprovar si les dates sol·licitades per la reserva d’un
allotjament estan dins d’un interval d’una altra reserva del mateix allotjament
(consultar següent secció).
 */
