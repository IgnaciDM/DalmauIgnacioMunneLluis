//La classe LlistaReserves encapsula la llista de reserves del càmping. Ha de definir com a
//atribut un ArrayList<Reserva> i s’ha de definir fent servir la interfície InLlistaReserves.
//public class LlistaReserves implements InLlistaReserves{
//}
//A més a més, s’han d’implementar els següents mètodes de suport: - -
//Un mètode anomenat allotjamentDisponible. Aquest mètode rep com a paràmetres
//un objecte de tipus Allotjament i dos objectes de tipus LocalDate  (les dates de
//entrada i de sortida) i retornarà un booleà per indicar si l’allotjament passat està
//disponible per fer la reserva en el dia indicat.
//Un mètode isEstadaMinima. Aquest mètode rep com a paràmetres un objecte de
//tipus Allotjament i dos objectes de tipus LocalDate  (les dates d’entrada i de sortida)
//i retornarà un booleà per indicar si l’estada sol·licitada compleix que és més llarga o
//igual que l’estada mínima de l’allotjament en la temporada corresponent a la data
//d’entrada.
//Aquests dos mètodes s’utilitzaran al mètode afegirReserva de la mateixa classe. El
//mètode afegirReserva rep un allotjament, un client i la data d’entrada i de sortida per
//fer la reserva (com a tipus LocalDate) i ha de fer el següent:  -
//Comprovar que l’allotjament estigui disponible pel període entre el dia d’entrada i
//de sortida. En cas negatiu, llança una excepció de tipus ExcepcioReserva amb el
//missatge: “L’allotjament amb identificador ID no està disponible en la data
//demanada DATA pel client CLIENT amb DNI: DNI.”, a on ID, DATA, CLIENT i DNI
//canviaran en funció de l’execució. Un exemple és: “L’allotjament amb identificador
//100P no està disponible en la data demanada 2025-02-20 pel client Lluís Plans amb
//DNI: 789101A.”
//9kkjj
//Programació 2. Pràctica 1
//Grau d’Enginyeria Informàtica. Facultat de Matemàtiques i Informàtica. UB
//Curs 2024-2025.  - -
//Comprovar que l’estada que s’està sol·licitant compleixi que és d’un número de dies
//major o igual que l’estada mínima per aquell tipus d’allotjament i per la temporada
//corresponent a la data d’entrada. En cas negatiu, llança una excepció de tipus
//ExcepcioReserva amb el missatge: “Les dates sol·licitades pel client CLIENT amb DNI:
//DNI no compleixen l'estada mínima per l'allotjament amb identificador ID.”, a on ID,
//DATA, CLIENT i DNI canviaran en funció de l’execució.
//En cas afirmatiu de les dues comprovacions, crea la reserva i l’afegeix a la llista de
//reserves del càmping.
package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LlistaReserves implements InLlistaReserves {
    private List<Reserva> reserves;

    public LlistaReserves() {
        this.reserves = new ArrayList<>();
    }

    public boolean allotjamentDisponible(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        for (Reserva reserva : reserves) {
            if (reserva.getAllotjament().equals(plaça)) {
                LocalDate entrada = reserva.getDataEntrada();
                LocalDate sortida = reserva.getDataSortida();

                if (!(Final.isBefore(entrada) || Inici.isAfter(sortida))) {
                    return false; // L’allotjament ja està reservat en aquest període
                }
            }
        }
        return true;
    }

    public boolean isEstadaMinima(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        long dies = ChronoUnit.DAYS.between(Inici, Final);
        int estadaMinima = plaça.getEstadaMinima(Inici); // Suponem que aquest mètode retorna la mínima per la temporada
        return dies >= estadaMinima;
    }

    @Override
    public void afegirReserva(Allotjament plaça, Client primo, LocalDate Inici, LocalDate Final) throws ExcepcioReserva {
        if (!allotjamentDisponible(plaça, Inici, Final)) {
            throw new ExcepcioReserva("L’allotjament amb identificador " + plaça.getId() +
                    " no està disponible en la data demanada " + Inici + " pel client " +
                    primo.getNom() + " amb DNI: " + primo.getDni() + ".");
        }

        if (!isEstadaMinima(plaça, Inici, Final)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + primo.getNom() +
                    " amb DNI: " + primo.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + plaça.getId() + ".");
        }

        Reserva reserva1 = new Reserva(plaça, primo, Inici, Final);
        reserves.add(reserva1);
    }
}
