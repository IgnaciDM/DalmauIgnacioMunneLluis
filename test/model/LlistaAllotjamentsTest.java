package model;
import prog2.vista.*;
import prog2.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llistaAllotjaments;
    private Parcela parcelaOperativa;
    private Bungalow bungalowOperatiu;
    private BungalowPremium bungalowNoOperatiu;

    @BeforeEach
    public void setUp() {
        llistaAllotjaments = new LlistaAllotjaments();

        // Create test accommodations
        parcelaOperativa = new Parcela("Parcela 1", "P1", true, "100%", 50.0f, true);
        bungalowOperatiu = new Bungalow("Bungalow 1", "B1", true, "100%", 30.0f, 2, 4, 1, true, true, true);
        bungalowNoOperatiu = new BungalowPremium("Bungalow Premium", "BP1", false, "50%", 40.0f,
                2, 6, 1, true, true, true, true, "WIFI123");

        // Add to list
        llistaAllotjaments.afegirAllotjament(parcelaOperativa);
        llistaAllotjaments.afegirAllotjament(bungalowOperatiu);
        llistaAllotjaments.afegirAllotjament(bungalowNoOperatiu);
    }

    @Test
    void testConstructor() {
        assertNotNull(llistaAllotjaments);
        assertEquals(3, llistaAllotjaments.getLlistaAllotjament().size());
    }

    @Test
    void testAfegirAllotjament() {
        int initialSize = llistaAllotjaments.getLlistaAllotjament().size();
        MobilHome nouMobilHome = new MobilHome("Mobil Home", "MH1", true, "100%", 35.0f, 2, 4, true);
        llistaAllotjaments.afegirAllotjament(nouMobilHome);
        assertEquals(initialSize + 1, llistaAllotjaments.getLlistaAllotjament().size());
        assertTrue(llistaAllotjaments.contains(nouMobilHome));
    }

    @Test
    void testBuidar() {
        llistaAllotjaments.buidar();
        assertEquals(0, llistaAllotjaments.getLlistaAllotjament().size());
    }

    @Test
    void testLlistarAllotjamentsTots() throws ExcepcioCamping {
        String result = llistaAllotjaments.llistarAllotjaments("Tots");
        assertNotNull(result);
        assertTrue(result.contains("P1"));
        assertTrue(result.contains("B1"));
        assertTrue(result.contains("BP1"));
    }

    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String result = llistaAllotjaments.llistarAllotjaments("Operatiu");
        assertNotNull(result);
        assertTrue(result.contains("P1"));
        assertTrue(result.contains("B1"));
        assertFalse(result.contains("BP1"));
    }

    @Test
    void testLlistarAllotjamentsNoOperatius() throws ExcepcioCamping {
        String result = llistaAllotjaments.llistarAllotjaments("NoOperatiu");
        assertNotNull(result);
        assertFalse(result.contains("P1"));
        assertFalse(result.contains("B1"));
        assertTrue(result.contains("BP1"));
    }

    @Test
    void testLlistarAllotjamentsEmptyList() {
        llistaAllotjaments.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.llistarAllotjaments("Tots");
        });
    }

    @Test
    void testContainsAllotjamentOperatiu() {
        assertTrue(llistaAllotjaments.containsAllotjamentOperatiu());

        // Make all accommodations non-operative
        llistaAllotjaments.buidar();
        llistaAllotjaments.afegirAllotjament(bungalowNoOperatiu);
        assertFalse(llistaAllotjaments.containsAllotjamentOperatiu());
    }

    @Test
    void testContains() {
        assertTrue(llistaAllotjaments.contains(parcelaOperativa));
        assertTrue(llistaAllotjaments.contains(bungalowOperatiu));

        MobilHome mobilHomeNoAfegit = new MobilHome("MH2", "MH2", true, "100%", 40.0f, 2, 4, true);
        assertFalse(llistaAllotjaments.contains(mobilHomeNoAfegit));
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        Allotjament result = llistaAllotjaments.getAllotjament("P1");
        assertEquals(parcelaOperativa, result);

        result = llistaAllotjaments.getAllotjament("b1"); // Test case insensitive
        assertEquals(bungalowOperatiu, result);
    }

    @Test
    void testGetAllotjamentNoExistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.getAllotjament("NO_EXISTE");
        });
    }

    @Test
    void testGetLlistaAllotjament() {
        ArrayList<Allotjament> llista = llistaAllotjaments.getLlistaAllotjament();
        assertEquals(3, llista.size());
        assertTrue(llista.contains(parcelaOperativa));
        assertTrue(llista.contains(bungalowOperatiu));
        assertTrue(llista.contains(bungalowNoOperatiu));
    }

    @Test
    void testLlistarAllotjamentsEstatInvalid() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAllotjaments.llistarAllotjaments("EstatInvalid");
        });
    }
}