package prog2.model;
import prog2.vista.ExcepcioCamping;
import prog2.vista.ExcepcioReserva;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class Camping implements InCamping,Serializable {
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
            Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
            if (idAllotjament == null || idAllotjament.isEmpty()) {
                throw new ExcepcioCamping("L'id de l'allotjament no pot estar buit.");
            }
            if (tipus == null || tipus.isEmpty()) {
                throw new ExcepcioCamping("El tipus d'incidència no pot estar buit.");
            }
            if (data == null || data.isEmpty()) {
                throw new ExcepcioCamping("La data no pot estar buida.");
            }
            llistaIncidencies.afegirIncidencia(num, tipus, allotjament, data);
            Incidencia in = new Incidencia(num, tipus, allotjament, data);
            allotjament.tancarAllotjament(in);
            llistaAccessos.actualitzaEstatAccessos();
            System.out.println("Hola");
        }catch(Exception e){
            throw new ExcepcioCamping(e.getMessage());
        }
    }

    @Override
    public void eliminarIncidencia(int num) throws ExcepcioCamping {
        llistaIncidencies.eliminarIncidencia(llistaIncidencies.getIncidencia(num));
        Incidencia in = llistaIncidencies.getIncidencia(num);
        in.getAllotjament().obrirAllotjament();
        llistaAccessos.actualitzaEstatAccessos();
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


    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti+".txt");

        // Guardar el objeto serializado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxer))) {
            oos.writeObject(this);
            System.out.println("Camping guardado correctamente en " + camiDesti);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al guardar el camping: " + e.getMessage());
        }

        // Ruta para guardar el archivo .txt en el directorio "prog2/model"
        File fitxerText = new File("src/prog2/model/" + camiDesti + ".txt");

        // Verificar si el archivo .txt ya existe
        if (fitxerText.exists()) {
            System.out.println("Archivo de texto encontrado: " + fitxerText.getName());
        } else {
            // Si no existe, creamos el archivo
            try {
                if (fitxerText.createNewFile()) {
                    System.out.println("Archivo de texto creado: " + fitxerText.getName());
                } else {
                    System.out.println("Error al crear el archivo de texto.");
                }
            } catch (IOException e) {
                throw new ExcepcioCamping("Error al crear el archivo de texto: " + e.getMessage());
            }
        }

        // Escribir los detalles en el archivo .txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fitxerText, true))) {
            // Escribir el nombre del Camping
            writer.write("Nom del Camping:");
            writer.newLine();
            writer.write(nom);
            writer.newLine();

            // Guardar la lista de clients
            writer.write("Clients:");
            writer.newLine();
            for (Client client : llistaClients) {
                writer.write("Nom: " + client.getNom() + ", DNI: " + client.getDni());
                writer.newLine();
            }

            // Guardar la lista de allotjaments usando llistarAllotjaments
            writer.write("Allotjaments:");
            writer.newLine();
            writer.write(llistarAllotjaments("Tots")); // Usamos el mismo método que en el menú
            writer.newLine();

            // Guardar la lista de reserves
            writer.write("Reserves:");
            writer.newLine();
            for (Reserva reserva : llistaReserves) {
                writer.write("ID Allotjament: " + reserva.getAllotjament().getId() +
                        ", Client: " + reserva.getClient().getNom() +
                        ", Data Entrada: " + reserva.getDataEntrada() +
                        ", Data Sortida: " + reserva.getDataSortida());
                writer.newLine();
            }

            // Guardar la lista de accessos usando llistarAccessos
            writer.write("Accessos:");
            writer.newLine();
            writer.write(llistarAccessos("Oberts")); // Usamos el mismo método del menú
            writer.newLine();


            /*

            // Guardar las incidències usando llistarIncidencies
            writer.write("Incidències:");
            writer.newLine();
            writer.write(llistarIncidencies()); // Usamos el mismo método del menú
            writer.newLine();
            */

            System.out.println("Dades guardades correctament en " + fitxerText.getName());
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al escribir en el archivo de texto: " + e.getMessage());
        }
    }







    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        Camping camping = null;
        // completar el codi
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(camiOrigen+".txt");
            ois = new ObjectInputStream(fin);
            camping = (Camping) ois.readObject();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ExcepcioCamping("No s'ha trobat la classecamping al ficher.");
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return camping;
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
