package prog2.model;
import java.util.Scanner;
import prog2.vista.ExcepcioCamping;
import prog2.vista.ExcepcioReserva;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;  // Nom del camping
    private LlistaAllotjaments llistaAllotjaments;  // Llista d'allotjaments disponibles
    private ArrayList<Client> llistaClients;  // Llista de clients registrats
    private ArrayList<Reserva> llistaReserves = new ArrayList<>();// Llista de reserves
    private LlistaAccessos llistaAccessos;
    private LlistaIncidencies llistaIncidencies;

    // Llista d'accessos


    // Constructor que inicialitza el camping amb el seu nom
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaClients = new ArrayList<Client>();
        this.llistaReserves = new ArrayList<Reserva>();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaIncidencies = new LlistaIncidencies();
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


    public String getNomCamping() {
        return nom;  // Retorna el nom del camping
    }



    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }


    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return llistaAccessos.llistarAccessos(infoEstat.equals("Oberts"));//Comproba si es igual a oberts si es aixi envia a LlistaAccesos un true
    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        return llistaIncidencies.llistarIncidencies();
    }

    @Override
    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        try{
            llistaIncidencies.afegirIncidencia(num, tipus, llistaAllotjaments.getAllotjament(idAllotjament), data);
            //llistaAccessos.actualitzaEstatAccessos();
        }catch(Exception e){
            throw new ExcepcioCamping(e.getMessage());
        }
    }

    @Override
    public void eliminarIncidencia(int num) throws ExcepcioCamping {
        llistaIncidencies.eliminarIncidencia(llistaIncidencies.getIncidencia(num));
        //llistaAccessos.actualitzaEstatAccessos();
    }

    @Override
    public int calculaAccessosAccessibles() {
        try {
            return llistaAccessos.calculaAccessosAccessibles();
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float calculaMetresQuadratsAsfalt() {
        try {
            return llistaAccessos.calculaMetresQuadratsAsfalt();
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    static Camping load(String camiOrigen) throws ExcepcioCamping {
        throw new UnsupportedOperationException("Aquest mètode està implementat a la classe Camping");
    }

    public ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;  // Retorna la llista de reserves
    }

    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments.getLlistaAllotjament();  //Retorna la llista d'allotjaments
    }

    public ArrayList<Client> getLlistaClients() {
        return llistaClients;  // Retorna la llista de clients
    }

    public int getNumAllotjaments() {
        return llistaAllotjaments.getLlistaAllotjament().size();  // Retorna el nombre d'allotjaments
    }

    public int getNumReserves() {
        return llistaReserves.size();  // Retorna el nombre de reserves
    }

    public int getNumClients() {
        return llistaClients.size();  // Retorna el nombre de clients
    }

    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client client = new Client(nom_, dni_);  // Crea un nou client
        llistaClients.add(client);  // Afegeix el client a la llista
    }

    // Afegeix una nova parcel·la a la llista d'allotjaments
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica, boolean estat,String iluminacio) {
        Parcela novaParcela = new Parcela(nom_, idAllotjament_, estat, iluminacio,metres, connexioElectrica);
        llistaAllotjaments.getLlistaAllotjament().add(novaParcela);
    }

    // Afegeix un nou bungalow a la llista d'allotjaments
    public void afegirBungalow(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean estat, String iluminacio) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_,estat,iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.getLlistaAllotjament().add(nouBungalow);
    }

    // Afegeix un nou bungalow premium a la llista d'allotjaments
    public void afegirBungalowPremium(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi, boolean estat, String iluminacio) {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom_, idAllotjament_, estat, iluminacio,mida,habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.getLlistaAllotjament().add(nouBungalowPremium);
    }

    // Afegeix un nou glamping a la llista d'allotjaments
    public void afegirGlamping(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones, String material, boolean casamascota, boolean estat, String iluminacio) {
        Glamping nouGlamping = new Glamping(nom_, idAllotjament_, estat,iluminacio,mida, habitacions, placesPersones, material, casamascota);
        llistaAllotjaments.getLlistaAllotjament().add(nouGlamping);
    }

    // Afegeix un nou mobil home a la llista d'allotjaments
    public void afegirMobilHome(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones, boolean terrassaBarbacoa,boolean estat, String iluminacio) {
        MobilHome nouMobilHome = new MobilHome(nom_, idAllotjament_,estat,iluminacio, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.getLlistaAllotjament().add(nouMobilHome);
    }




    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = null;
        for (Allotjament a : llistaAllotjaments.getLlistaAllotjament()) {
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

    public float calculMidaTotalParceles() {
        float midaTotal = 0;
        // Calcula la mida total de totes les parcel·les
        for (Allotjament allotjament : llistaAllotjaments.getLlistaAllotjament()) {
            if (allotjament instanceof Parcela) {
                midaTotal += ((Parcela) allotjament).getMida();
            }
        }
        return midaTotal;
    }


    public int calculAllotjamentsOperatius() {
        int allotjamentsOp = 0;
        // Compta els allotjaments operatius
        for (Allotjament allotjament : llistaAllotjaments.getLlistaAllotjament()) {
            if (allotjament.esOperatiu()) {
                allotjamentsOp++;
            }
        }
        return allotjamentsOp;
    }

    public Allotjament getAllotjamentEstadaMesCurta() {
        // Obté l'allotjament amb l'estada més curta
        if (llistaAllotjaments.getLlistaAllotjament().isEmpty()) {
            return null;
        }

        Allotjament estadaMesCurta = llistaAllotjaments.getLlistaAllotjament().get(0);

        for (Allotjament allotjament : llistaAllotjaments.getLlistaAllotjament()) {
            if (allotjament.getDiesEstada() < estadaMesCurta.getDiesEstada()) {
                estadaMesCurta = allotjament;
            }
        }
        return estadaMesCurta;
    }

    // Método para guardar el objeto Camping en un archivo

    public void save(String camiDesti) throws ExcepcioCamping; {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(camiDesti));
        out.writeObject(this);
        System.out.println("Dades del càmping guardades correctament en: " + camiDesti);
    }


    // Método para cargar un objeto Camping desde un archivo
    public static Camping carregar(String nomFitxer) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFitxer))) {
            return (Camping) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en carregar les dades: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void inicialitzaDadesCamping() throws ExcepcioCamping {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);

    }

}
