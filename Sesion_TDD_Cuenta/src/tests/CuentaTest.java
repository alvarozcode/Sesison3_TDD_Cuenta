package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Importación necesaria para conectar con la clase Cuenta del paquete sesion_TDD
import sesion_TDD.Cuenta;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        cuenta = new Cuenta("12345", "Juan Pérez");
    }
    

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testIngresar() {
        cuenta.ingresar(500.0);
        assertEquals(500.0, cuenta.getSaldo());
    }
}