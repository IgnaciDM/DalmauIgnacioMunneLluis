package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.*;
import prog2.model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CampingTest {

    private Camping camping;
    private Client client;
    private Parcela parcela;
    private Bungalow bungalow;
    private BungalowPremium bungalowPremium;
    private Glamping glamping;
    private MobilHome mobilHome;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    @BeforeEach
    public void setUp() throws ExcepcioReserva, ExcepcioCamping {
        // Initialize a Camping
        camping = new Camping("Camping La Playa");

        // Initialize access paths (needed for some tests)
        camping.inicialitzaDadesCamping();

        // Create and add clients
        client = new Client("Laura", "123456789");
        camping.afegirClient(client.getNom(), client.getDni());

        // Create and add accommodations
        parcela = new Parcela("Parcela 1", "P001", true, "100%", 100.0f, true);
        bungalow = new Bungalow("Bungalow 1", "B001", true, "100%", 22.0f, 2, 4, 1, true, true, true);
        bungalowPremium = new BungalowPremium("Bungalow Premium", "BP001", true, "100%", 27.0f, 2, 6, 1, true, true, true, true, "WiFi123");
        glamping = new Glamping("Glamping 1", "G001", true, "100%", 20.0f, 1, 2, "Tela", true);
        //AFEGIM UN QUE NO ESTIGUI OPERATIU PER DEFECTA
        mobilHome = new MobilHome("Mobil Home 1", "MH001", false, "100%", 20.0f, 2, 4, true);

        camping.afegirParcela(parcela.getNom(), parcela.getId(), parcela.getMida(), parcela.isConnexioElectrica(), parcela.getEstat(), parcela.getIluminacio());
        camping.afegirBungalow(bungalow.getNom(), bungalow.getId(), bungalow.getMida(), bungalow.getHabitacions(),
                bungalow.getPlacesPersones(), bungalow.getPlacesParquing(), bungalow.isTerrassa(),
                bungalow.isTv(), bungalow.isAireFred(), bungalow.getEstat(), bungalow.getIluminacio());
        camping.afegirBungalowPremium(bungalowPremium.getNom(), bungalowPremium.getId(), bungalowPremium.getMida(),
                bungalowPremium.getHabitacions(), bungalowPremium.getPlacesPersones(),
                bungalowPremium.getPlacesParquing(), bungalowPremium.isTerrassa(),
                bungalowPremium.isTv(), bungalowPremium.isAireFred(), bungalowPremium.isServeisExtra(),
                bungalowPremium.getCodiWifi(), bungalowPremium.getEstat(), bungalowPremium.getIluminacio());
        camping.afegirGlamping(glamping.getNom(), glamping.getId(), glamping.getMida(), glamping.getHabitacions(),
                glamping.getPlacesPersones(), glamping.getMaterial(), glamping.isCasamascota(),
                glamping.getEstat(), glamping.getIluminacio());
        camping.afegirMobilHome(mobilHome.getNom(), mobilHome.getId(), mobilHome.getMida(), mobilHome.getHabitacions(),
                mobilHome.getPlacesPersones(), mobilHome.isTerrassaBarbacoa(), mobilHome.getEstat(),
                mobilHome.getIluminacio());

        // Dates for reservations
        dataEntrada = LocalDate.of(2024, 5, 1);
        dataSortida = LocalDate.of(2024, 5, 10);
    }

    @Test
    void testGetNomCamping() {
        assertEquals("Camping La Playa", camping.getNomCamping());
    }

    @Test
    void testAfegirClient() {
        assertEquals(1, camping.getNumClients());
        assertEquals("Laura", camping.getLlistaClients().get(0).getNom());
        assertEquals("123456789", camping.getLlistaClients().get(0).getDni());
    }

    @Test
    void testAfegirAllotjaments() {
        assertEquals(11, camping.getNumAllotjaments()); // 1 parcel·la + 1 bungalow + 1 premium + 1 glamping + 1 mobil home + 6 from inicialitzaDades
    }

    @Test
    void testAfegirReservaCorrecta() throws ExcepcioReserva {
        camping.afegirReserva(parcela.getId(), client.getDni(), dataEntrada, dataSortida);
        assertEquals(1, camping.getNumReserves());

        Reserva reserva = camping.getLlistaReserves().get(0);
        assertEquals(parcela.getId(), reserva.getAllotjament().getId());
        assertEquals(client.getDni(), reserva.getClient().getDni());
        assertEquals(dataEntrada, reserva.getDataEntrada());
        assertEquals(dataSortida, reserva.getDataSortida());
    }

    @Test
    void testAfegirReservaAllotjamentNoExistent() {
        assertThrows(ExcepcioReserva.class, () -> {
            camping.afegirReserva("ID_INEXISTENT", client.getDni(), dataEntrada, dataSortida);
        });
    }

    @Test
    void testAfegirReservaClientNoExistent() {
        assertThrows(ExcepcioReserva.class, () -> {
            camping.afegirReserva(parcela.getId(), "DNI_INEXISTENT", dataEntrada, dataSortida);
        });
    }

    @Test
    void testAfegirReservaDatesSolapades() throws ExcepcioReserva {
        camping.afegirReserva(parcela.getId(), client.getDni(), dataEntrada, dataSortida);

        // Same dates
        assertThrows(ExcepcioReserva.class, () -> {
            camping.afegirReserva(parcela.getId(), client.getDni(), dataEntrada, dataSortida);
        });

        // Overlapping dates
        assertThrows(ExcepcioReserva.class, () -> {
            camping.afegirReserva(parcela.getId(), client.getDni(),
                    dataEntrada.minusDays(2), dataSortida.minusDays(2));
        });

        // Contained within existing reservation
        assertThrows(ExcepcioReserva.class, () -> {
            camping.afegirReserva(parcela.getId(), client.getDni(),
                    dataEntrada.plusDays(1), dataSortida.minusDays(1));
        });
    }

    @Test
    void testCalculMidaTotalParceles() {
        float midaTotal = camping.calculMidaTotalParceles();
        //Inicialitzar dades :ALL1 (Parcela): 64.0f, ALL2 (Parcela): 64.0f
        //setUp() añade: P001 (Parcela): 100.0f
        //Total: 64 + 64 + 100 = 228
        assertEquals(228, midaTotal, 0.01);
    }

    @Test
    void testCalculAllotjamentsOperatius() {
        int operatius = camping.calculAllotjamentsOperatius();
        assertEquals(10, operatius); // 6 de inicialitzaDades + 4 operatius afegits
    }

    @Test
    void testGetAllotjamentEstadaMesCurta() throws ExcepcioCamping {
        // First, let's get the current season to know which minimum stay to set
        LocalDate today = LocalDate.now();
        InAllotjament.Temp currentSeason = Camping.getTemporada(today);

        // Create new accommodations with different minimum stays
        Parcela p1 = new Parcela("Parcela 1", "P1", true, "100%", 50.0f, true);
        p1.setEstadaMinima(5, 3); // High season: 5, Low season: 3

        Bungalow b1 = new Bungalow("Bungalow 1", "B1", true, "100%", 30.0f, 2, 4, 1, true, true, true);
        b1.setEstadaMinima(3, 2); // High season: 3, Low season: 2

        BungalowPremium bp1 = new BungalowPremium("Bungalow Premium 1", "BP1", true, "100%", 40.0f,
                2, 6, 1, true, true, true, true, "WIFI123");
        bp1.setEstadaMinima(7, 5); // High season: 7, Low season: 5

        // Add them to camping (need to clear existing ones first)
        camping.getLlistaAllotjaments().clear();
        camping.getLlistaAllotjaments().add(p1);
        camping.getLlistaAllotjaments().add(b1);
        camping.getLlistaAllotjaments().add(bp1);

        // Get the accommodation with shortest stay
        Allotjament estadaMesCurta = camping.getAllotjamentEstadaMesCurta();

        // Verify based on current season
        if (currentSeason == InAllotjament.Temp.ALTA) {
            // In high season, b1 should have shortest stay (3 days)
            assertEquals(b1.getId(), estadaMesCurta.getId());
        } else {
            // In low season, b1 should have shortest stay (2 days)
            assertEquals(b1.getId(), estadaMesCurta.getId());
        }
    }

    @Test
    void testGetTemporada() {
        // High season
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(LocalDate.of(2024, 6, 1)));
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(LocalDate.of(2024, 4, 15)));
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(LocalDate.of(2024, 3, 21))); // Start of high season

        // Low season
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(LocalDate.of(2024, 1, 15)));
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(LocalDate.of(2024, 11, 30)));
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(LocalDate.of(2024, 3, 20))); // Day before high season starts
    }

    @Test
    void testIncidencies() throws ExcepcioCamping {
        // Add an incidence
        camping.afegirIncidencia(1, "Averia electrica", parcela.getId(), "2024-05-01");

        // Check incidence was added
        assertEquals(1, camping.llistarIncidencies().length());

        // Check parcel is now closed
        assertFalse(parcela.esOperatiu());

        // Remove incidence
        camping.eliminarIncidencia(1);

        // Check incidence was removed and parcel is open again
        assertEquals(0, camping.llistarIncidencies().length());
        assertTrue(parcela.esOperatiu());
    }

    @Test
    void testAccessos() throws ExcepcioCamping {
        // Reiniciamos los accesos para tener un estado conocido
        camping.inicialitzaDadesCamping();

        // 1. Test de accesos accesibles
        int accessibles = camping.calculaAccessosAccessibles();
        /*
         * En inicialitzaDadesCamping() se crean 12 accesos:
         * - 6 accesos asfaltados (todos accesibles)
         * - 6 accesos de tierra (todos accesibles)
         * Total: 12 accesos accesibles
         */
        assertEquals(12, accessibles);

        // 2. Test de metros cuadrados asfaltados
        float asfalt = camping.calculaMetresQuadratsAsfalt();
        /*
         * Suma de los accesos asfaltados:
         * - A1: 200
         * - A2: 800
         * - A5: 350
         * - A6: 800
         * - A7: 100
         * - A8: 800
         * Total: 200+800+350+800+100+800 = 3050
         */
        assertEquals(3050.0f, asfalt, 0.01f);

        // 3. Test de listado de accesos abiertos
        String llistaOberts = camping.llistarAccessos("Oberts");
        assertNotNull(llistaOberts);
        assertFalse(llistaOberts.isEmpty());
        // Verificamos que aparecen algunos accesos conocidos
        assertTrue(llistaOberts.contains("A1"));
        assertTrue(llistaOberts.contains("A12"));
    }

    @Test
    void testSaveAndLoad() throws ExcepcioCamping {
        // Add some data
        try {
            camping.afegirReserva(parcela.getId(), client.getDni(), dataEntrada, dataSortida);
        } catch (ExcepcioReserva e) {
            fail("Failed to add reservation for save/load test");
        }

        // Save camping
        camping.save("testCamping");

        // Load camping
        Camping loadedCamping = Camping.load("testCamping");

        // Verify loaded data
        assertNotNull(loadedCamping);
        assertEquals(camping.getNomCamping(), loadedCamping.getNomCamping());
        assertEquals(camping.getNumClients(), loadedCamping.getNumClients());
        assertEquals(camping.getNumAllotjaments(), loadedCamping.getNumAllotjaments());
        assertEquals(camping.getNumReserves(), loadedCamping.getNumReserves());
    }
}