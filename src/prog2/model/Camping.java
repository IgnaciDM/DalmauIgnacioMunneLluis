package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private ArrayList<Reserva> llistaReserves = new ArrayList<>();

    public Camping(String campingDelMar) {
        this.nom = "campingDelMar";
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaClients = new ArrayList<Client>();
        this.llistaReserves = new ArrayList<Reserva>();
    }

    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();

        // Temporada baixa: Gener - Març i Octubre - Desembre (excepte dates especials)
        if ((mes >= 1 && mes <= 3) || (mes >= 10 && mes <= 12)) {
            // Temporada alta per Setmana Santa (exemple: 21 de març a 31 de març)
            if (mes == 3 && dia >= 21) {
                return InAllotjament.Temp.ALTA;
            }
            return InAllotjament.Temp.BAIXA;
        }

        // Temporada alta: Abril - Setembre
        return InAllotjament.Temp.ALTA;
    }



    @Override
    public String getNom() {
        System.out.println("Nom del camping: " + nom);
        return nom;
    }

    public ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return null;
    }

    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    @Override
    public int getNumAllotjaments() {
        System.out.println("Número d'allotjaments: " + llistaAllotjaments.size());
        return llistaAllotjaments.size();
    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    @Override
    public int getNumClients() {
        System.out.println("Número de clients: " + llistaClients.size());
        return llistaClients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_)throws ExcepcioReserva{
        Client client = null;//IMPLEMENTA LA CLASE CLIENT
        try {
            client = new Client(nom_, dni_);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        llistaClients.add(client);
        System.out.println("Client afegit: " + nom_ + " amb DNI " + dni_);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        // Crear una nova instància de Parcela
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        // Afegir-la a la llista d'allotjaments
        llistaAllotjaments.add(novaParcela);
        System.out.println("Parcela afegida: " + nom_ + ", ID Allotj2ament: " + idAllotjament_);
    }


    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
        System.out.println("Bungalow afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }


    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(nouBungalowPremium);
        System.out.println("Bungalow Premium afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping nouGlamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(nouGlamping);
        System.out.println("Glamping afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }


    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome nouMobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(nouMobilHome);
        System.out.println("Mobilehome afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // Buscar l'allotjament per ID
        Allotjament allotjament = null;
        for (Allotjament a : llistaAllotjaments) {
            if (a.getId().equals(id_)) {
                allotjament = a;
                break;
            }
        }

        // Si no es troba l'allotjament, llançar excepció
        if (allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb ID " + id_ + " no existeix.");
        }

        // Buscar el client per DNI
        Client client = null;
        for (Client c : llistaClients) {
            if (c.getDni().equals(dni_)) {
                client = c;
                break;
            }
        }

        // Si no es troba el client, llançar excepció
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix.");
        }

        // Crear la reserva i afegir-la a la llista
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llistaReserves.add(reserva);
        System.out.println("Reserva afegida per al client " + dni_ + " a l'allotjament " + id_);
    }


    @Override
    public float calculMidaTotalParceles() {
        System.out.println("Calculant mida total de parcel·les.");
        return 0; // Aquí simplemente se verifica el flujo, sin cálculos reales
    }

    @Override
    public int calculAllotjamentsOperatius() {
        System.out.println("Calculant allotjaments operatius.");
        return 0; // Aquí también solo se verifica el flujo
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta() {
        System.out.println("Obtenint allotjament amb estada més curta.");
        return null; // Retorna null ya que no se está implementando la lógica
    }

}