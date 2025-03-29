package model;
import prog2.vista.*;
import prog2.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidenciaTest {
    private Incidencia incidenciaReparacio;
    private Incidencia incidenciaNeteja;
    private Incidencia incidenciaTancament;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        allotjament = new Bungalow("Bungalow 1", "A101", true, "LED", 30.5f, 2, 4, 1, true, true, false); // Usar una subclase concreta // Suponiendo que Allotjament tiene un constructor con un String
        incidenciaReparacio = new Incidencia(1, "Reparacio", allotjament, "2025-03-29");
        incidenciaNeteja = new Incidencia(2, "Neteja", allotjament, "2025-03-30");
        incidenciaTancament = new Incidencia(3, "Tancament", allotjament, "2025-03-31");
    }

    @Test
    void testGetIdIncidencia() {
        assertEquals(1, incidenciaReparacio.getidIncidencia());
        assertEquals(2, incidenciaNeteja.getidIncidencia());
        assertEquals(3, incidenciaTancament.getidIncidencia());
    }

    @Test
    void testGetAllotjament() {
        assertEquals(allotjament, incidenciaReparacio.getAllotjament());
    }

    @Test
    void testGetTipus() {
        assertEquals(Incidencia.TipusIncidencia.Reparacio, incidenciaReparacio.getTipus());
        assertEquals(Incidencia.TipusIncidencia.Neteja, incidenciaNeteja.getTipus());
        assertEquals(Incidencia.TipusIncidencia.Tancament, incidenciaTancament.getTipus());
    }

    @Test
    void testGetData() {
        assertEquals("2025-03-29", incidenciaReparacio.getdata());
        assertEquals("2025-03-30", incidenciaNeteja.getdata());
        assertEquals("2025-03-31", incidenciaTancament.getdata());
    }

    @Test
    void testGetIluminacioAllotjament() {
        assertEquals("100%", incidenciaReparacio.getIluminacioAllotjament());
        assertEquals("50%", incidenciaNeteja.getIluminacioAllotjament());
        assertEquals("0%", incidenciaTancament.getIluminacioAllotjament());
    }

    @Test
    void testToString() {
        String expected = "Id=1, Allotjament=A101, Tipus= Reparacio, data= 2025-03-29, tipus de Incidencia= .";
        assertTrue(incidenciaReparacio.toString().contains("Id=1"));
        assertTrue(incidenciaReparacio.toString().contains("Tipus= Reparacio"));
        assertTrue(incidenciaReparacio.toString().contains("data= 2025-03-29"));
    }
}
