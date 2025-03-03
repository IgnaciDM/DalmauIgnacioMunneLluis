package prog2.model;

import prog2.vista.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private ArrayList<Reserves> llistaReserves = new ArrayList<>();

    public Camping(String campingDelMar) {
        this.nom = "campingDelMar";
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaClients = new ArrayList<Client>();
        this.llistaReserves = new ArrayList<Reserves>();
    }

    @Override
    public String getNom() {
        System.out.println("Nom del camping: " + nom);
        return nom;
    }
    public ArrayList<Reserves> getLlistaReserves(){
        return llistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return null;
    }

    public ArrayList<Client> getLlistaClients(){
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
    };

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = null;//IMPLEMENTA LA CLASE CLIENT
        try {
            client = new Client(nom_, dni_);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        llistaClients.add(client);
        System.out.println("Client afegit: " + nom_ + " amb DNI " + dni_);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        // Crear una nova instància de Parcela
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        // Afegir-la a la llista d'allotjaments
        llistaAllotjaments.add(novaParcela);
        System.out.println("Parcela afegida: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassa, tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
        System.out.println("Bungalow afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(nouBungalowPremium);
        System.out.println("Bungalow Premium afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping nouGlamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(nouGlamping);
        System.out.println("Glamping afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome nouMobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(nouMobilHome);
        System.out.println("Mobilehome afegit: " + nom_ + ", ID Allotjament: " + idAllotjament_);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Reserva nouReserva = new Reserva(id_, dni_, dataEntrada, dataSortida);
        llistaReserves.add(nouReserva);
        System.out.println();
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
