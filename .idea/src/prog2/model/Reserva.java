/*
4.4 Classe Reserva
La classe Reserva guardarà els atributs que s’han descrit a l’enunciat. Dos dels atributs
seran la data d’entrada i data de sortida de la reserva, fent servir el tipus LocalDate
(consultar la secció 5.4.1).
El seu constructor ha de rebre els paràmetres en el mateix ordre que els rep el mètode
afegirReserva de la classe LlistaReserves.
 */
package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor que rep les dates d'entrada i sortida
    public Reserva(LocalDate dataEntrada, LocalDate dataSortida) {
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    // Mètode per calcular el nombre de dies d'estada
    public long calcularEstada() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    }

    // Getters per obtenir les dates (opcional)
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
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
