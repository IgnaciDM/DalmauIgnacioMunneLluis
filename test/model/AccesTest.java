package model;
import prog2.vista.*;
import prog2.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class AccesTest {

    private Acces acces;
    private Allotjament parcela;
    private Allotjament bungalow;

    @BeforeEach
    void setUp() {
        // Create a basic access path
        acces = new Acces("A1", true, 100.0f);

        // Create test accommodations
        parcela = new Parcela("Parcela 1", "P1", true, "100%", 50.0f, true);
        bungalow = new Bungalow("Bungalow 1", "B1", true, "100%", 30.0f, 2, 4, 1, true, true, true);
    }

    @Test
    void testConstructor() {
        assertNotNull(acces);
        assertEquals("A1", acces.getNom());
        assertTrue(acces.getEstat());
        assertTrue(acces.isAccessibilitat());
        assertNotNull(acces.getAccesAAllotjaments());
        assertEquals(0, acces.getAccesAAllotjaments().size());
    }

    @Test
    void testAfegirAllotjament() {
        acces.afegirAllotjament(parcela);
        assertEquals(1, acces.getAccesAAllotjaments().size());
        assertEquals(parcela, acces.getAccesAAllotjaments().get(0));

        acces.afegirAllotjament(bungalow);
        assertEquals(2, acces.getAccesAAllotjaments().size());
        assertEquals(bungalow, acces.getAccesAAllotjaments().get(1));
    }

    @Test
    void testAfegirAllotjamentNull() {
        acces.afegirAllotjament(null);
        assertEquals(0, acces.getAccesAAllotjaments().size());
    }

    @Test
    void testTancarAcces() {
        acces.tancarAcces();
        assertFalse(acces.getEstat());
    }

    @Test
    void testObrirAcces() {
        acces.tancarAcces(); // First close it
        acces.obrirAcces();  // Then open it
        assertTrue(acces.getEstat());
    }

    @Test
    void testSetEstat() {
        acces.setEstat(false);
        assertFalse(acces.getEstat());

        acces.setEstat(true);
        assertTrue(acces.getEstat());
    }

    @Test
    void testSetNom() {
        acces.setNom("New Access");
        assertEquals("New Access", acces.getNom());
    }

    @Test
    void testSetAllotjaments() {
        ArrayList<Allotjament> newList = new ArrayList<>();
        newList.add(parcela);
        newList.add(bungalow);

        acces.setAllotjaments(newList);
        assertEquals(2, acces.getAccesAAllotjaments().size());
        assertEquals(parcela, acces.getAccesAAllotjaments().get(0));
        assertEquals(bungalow, acces.getAccesAAllotjaments().get(1));
    }

    @Test
    void testSetAllotjamentsNull() {
        acces.afegirAllotjament(parcela); // Add something first
        acces.setAllotjaments(null);      // Try to set null
        assertEquals(1, acces.getAccesAAllotjaments().size()); // Should remain unchanged
    }

    @Test
    void testIsAccessibilitat() {
        assertTrue(acces.isAccessibilitat());

        Acces inaccessibleAcces = new Acces("A2", false, 50.0f);
        assertFalse(inaccessibleAcces.isAccessibilitat());
    }
}