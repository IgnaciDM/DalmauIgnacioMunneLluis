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
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// La classe LlistaReserves encapsula la llista de reserves del càmping. Aquesta classe implementa la interfície InLlistaReserves.
public class LlistaReserves implements InLlistaReserves {

    // S'instància una llista de tipus Reserva per emmagatzemar totes les reserves realitzades.
    private List<Reserva> reserves;

    // Constructor de la classe LlistaReserves. Inicialitza la llista de reserves com un ArrayList buit.
    public LlistaReserves() {
        this.reserves = new ArrayList<>();
    }

    // Mètode que comprova si un allotjament està disponible en un període de temps determinat.
    // Rep com a paràmetres un objecte Allotjament i dues dates (entrada i sortida).
    public boolean allotjamentDisponible(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        // Itera per totes les reserves actuals per veure si l'allotjament està reservat per les dates especificades.
        for (Reserva reserva : reserves) {
            // Obtenim la reserva actual i les dates d'entrada i sortida.
            if (reserva.getAllotjament().equals(plaça)) {  // Comprova si l'allotjament de la reserva coincideix amb l'allotjament passat com a paràmetre.
                LocalDate entrada = reserva.getDataEntrada();
                LocalDate sortida = reserva.getDataSortida();

                // Comprova si les dates de la reserva es solapen amb les dates sol·licitades (si la data de sortida és abans de l'entrada o la data d'entrada és després de la sortida, l'allotjament està disponible).
                if (!(Final.isBefore(entrada) || Inici.isAfter(sortida))) {
                    return false; // L’allotjament ja està reservat en aquest període.
                }
            }
        }
        return true; // L'allotjament està disponible.
    }

    // Mètode que comprova si l'estada d'un client compleix la durada mínima requerida per l'allotjament.
    // Rep com a paràmetres un objecte Allotjament i dues dates (entrada i sortida).
    public boolean isEstadaMinima(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        long dies = ChronoUnit.DAYS.between(Inici, Final);  // Calcula el nombre de dies entre les dates d'entrada i sortida.
        long estadaMinima = plaça.getEstadaMinima(plaça.determinarTemporada(Inici)); // Obté l'estada mínima per l'allotjament en la temporada corresponent.
        return dies >= estadaMinima; // Retorna si l'estada sol·licitada és superior o igual a l'estada mínima.
    }

    // Mètode que afegeix una nova reserva a la llista de reserves del càmping.
    // Rep un objecte Allotjament, un Client, i les dates d'entrada i sortida.
    @Override
    public void afegirReserva(Allotjament plaça, Client primo, LocalDate Inici, LocalDate Final) throws ExcepcioReserva {
        // Comprova si l'allotjament està disponible en les dates sol·licitades.
        if (!allotjamentDisponible(plaça, Inici, Final)) {
            // Si no està disponible, llança una excepció amb el missatge corresponent.
            throw new ExcepcioReserva("L’allotjament amb identificador " + plaça.getId() +
                    " no està disponible en la data demanada " + Inici + " pel client " +
                    primo.getNom() + " amb DNI: " + primo.getDni() + ".");
        }

        // Comprova si l'estada complerta és més llarga o igual a l'estada mínima per l'allotjament.
        if (!isEstadaMinima(plaça, Inici, Final)) {
            // Si no compleix l'estada mínima, llança una excepció amb el missatge corresponent.
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + primo.getNom() +
                    " amb DNI: " + primo.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + plaça.getId() + ".");
        }

        // Si ambdues comprovacions són correctes (l'allotjament està disponible i l'estada és vàlida),
        // crea una nova reserva i l'afegeix a la llista de reserves.
        Reserva reserva1 = new Reserva(plaça, primo, Inici, Final);
        reserves.add(reserva1);
    }

    // Mètode que retorna el nombre total de reserves realitzades.
    @Override
    public int getNumReserves() {
        return reserves.size();  // Retorna la mida de la llista de reserves, que representa el nombre total de reserves.
    }
}

