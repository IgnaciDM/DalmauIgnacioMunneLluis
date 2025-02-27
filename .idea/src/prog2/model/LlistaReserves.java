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
import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class LlistaReserves implements InLlistaReserves{
    ArrayList<Reserva> LlistaReserves = new ArrayList();

    public LlistaReserves(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.LlistaReserves = new ArrayList();
    }

    public boolean allotjamentDisponible(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        boolean disponible = true;
        return disponible;
    }

    public boolean isEstadaMinima(Allotjament plaça, LocalDate Inici, LocalDate Final) {
        boolean estadaMinima = true;
        int R, mínim = 0;
        R = Final - Inici;
        if (R < mínim) {
            estadaMinima = false;
        }
        return estadaMinima;
    }

    @Override
    public void afegirReserva(Allotjament plaça, Client primo, LocalDate Inici, LocalDate Final) {
        try {
            if (!allotjamentDisponible(plaça, Inici, Final)) {
                throw new NoSuchElementException("Reserva no disponible");
            }
        } catch (NoSuchElementException e) {
            System.err.println("L’allotjament amb identificador " + ID + " no està disponible en la data demanada " + DATA + " pel client " + CLIENT + " amb DNI: " + DNI); // Muestra el mensaje de error en la consola
        }
        try {
            if (!isEstadaMinima(plaça, Inici, Final)) {
                throw new NoSuchElementException("Reserva no disponible");
            }
        } catch (NoSuchElementException e) {
            System.err.println("Les dates sol·licitades pel client " + CLIENT + "amb DNI: " + DNI + " no compleixen l'estada mínima per l'allotjament amb identificador " + ID + "."); // Muestra el mensaje de error en la consola
        }
        Reserva reserva1 = Reserva(Allotjament plaça, Client primo, LocalDate Inici, LocalDate Final);
        LlistaReserves.add(reserva1);
    }
    }