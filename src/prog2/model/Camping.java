package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;  // Nom del camping
    private ArrayList<Allotjament> llistaAllotjaments;  // Llista d'allotjaments disponibles
    private ArrayList<Client> llistaClients;  // Llista de clients registrats
    private ArrayList<Reserva> llistaReserves = new ArrayList<>();  // Llista de reserves

    // Constructor que inicialitza el camping amb el seu nom
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaClients = new ArrayList<Client>();
        this.llistaReserves = new ArrayList<Reserva>();
    }

    // Retorna la temporada en funció de la data proporcionada
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();

        // Temporada baixa de gener a març i octubre a desembre
        if ((mes >= 1 && mes <= 3) || (mes >= 10 && mes <= 12)) {
            // Temporada alta per Setmana Santa
            if (mes == 3 && dia >= 21) {
                return InAllotjament.Temp.ALTA;
            }
            return InAllotjament.Temp.BAIXA;
        }
        // Temporada alta de abril a setembre
        return InAllotjament.Temp.ALTA;
    }

    @Override
    public String getNom() {
        return nom;  // Retorna el nom del camping
    }

    public ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;  // Retorna la llista de reserves
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;  //Retorna la llista d'allotjaments
    }

    public ArrayList<Client> getLlistaClients() {
        return llistaClients;  // Retorna la llista de clients
    }

    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();  // Retorna el nombre d'allotjaments
    }

    @Override
    public int getNumReserves() {
        return llistaReserves.size();  // Retorna el nombre de reserves
    }

    @Override
    public int getNumClients() {
        return llistaClients.size();  // Retorna el nombre de clients
    }

    @Override
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client client = new Client(nom_, dni_);  // Crea un nou client
        llistaClients.add(client);  // Afegeix el client a la llista
    }

    // Afegeix una nova parcel·la a la llista d'allotjaments
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(novaParcela);
    }

    // Afegeix un nou bungalow a la llista d'allotjaments
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
    }

    // Afegeix un nou bungalow premium a la llista d'allotjaments
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(nouBungalowPremium);
    }

    // Afegeix un nou glamping a la llista d'allotjaments
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping nouGlamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(nouGlamping);
    }

    // Afegeix un nou mobil home a la llista d'allotjaments
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome nouMobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(nouMobilHome);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = null;
        for (Allotjament a : llistaAllotjaments) {
            if (a.getId().equals(id_)) {
                allotjament = a;
                break;
            }
        }

        if (allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb ID " + id_ + " no existeix.");
        }

        Client client = null;
        for (Client c : llistaClients) {
            if (c.getDni().equals(dni_)) {
                client = c;
                break;
            }
        }
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix.");
        }

        // Comprova si ja hi ha una reserva per les mateixes dates
        for (Reserva r : llistaReserves) {
            if (r.getAllotjament().getId().equals(id_) && !(dataSortida.isBefore(r.getDataEntrada()) || dataEntrada.isAfter(r.getDataSortida()))) {
                throw new ExcepcioReserva("L'allotjament ja està reservat en aquestes dates.");
            }
        }

        // Afegir la nova reserva
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llistaReserves.add(reserva);
    }

    @Override
    public float calculMidaTotalParceles() {
        float midaTotal = 0;
        // Calcula la mida total de totes les parcel·les
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament instanceof Parcela) {
                midaTotal += ((Parcela) allotjament).getMida();
            }
        }
        return midaTotal;
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int allotjamentsOp = 0;
        // Compta els allotjaments operatius
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament.esOperatiu()) {
                allotjamentsOp++;
            }
        }
        return allotjamentsOp;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta() {
        // Obté l'allotjament amb l'estada més curta
        if (llistaAllotjaments.isEmpty()) {
            return null;
        }

        Allotjament estadaMesCurta = llistaAllotjaments.get(0);

        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament.getDiesEstada() < estadaMesCurta.getDiesEstada()) {
                estadaMesCurta = allotjament;
            }
        }
        return estadaMesCurta;
    }
}
