package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sesion_TDD.Cuenta;

class CuentaTest {

    private Cuenta cuenta12345;
    private Cuenta cuenta67890;

    @BeforeEach
    void setUp() throws Exception {
        // Inicialización estricta según la imagen:
        // 1. Crear la cuenta 12345 con un saldo inicial de 50€
        cuenta12345 = new Cuenta("12345", "Titular 12345", 50.0);
        
        // 2. Crear la cuenta 67890 con un saldo inicial de 0€ 
        // (usamos "56789" para coincidir con la salida esperada en Errores Registrados)
        cuenta67890 = new Cuenta("56789", "Titular 67890", 0.0);
    }

    @Test
    void testIngresar() {
        Cuenta c = new Cuenta("11111", "Prueba");
        c.ingresar(500.0);
        assertEquals(500.0, c.getSaldo());
    }

    @Test
    void test0014_PruebaRegresionCompleta() {
        System.out.println("=== INICIO TEST 0014: OPERACIONES DE REGRESIÓN ===");

        //1. Reintegro de 200€ de la cuenta 12345
        cuenta12345.retirar(200.0);

        //2. Reintegro de 350€ de la cuenta 67890
        cuenta67890.retirar(350.0);

        //3. Ingreso de 100€ en la cuenta 12345
        cuenta12345.ingresar(100.0);

        //4. Reintegro de 200€ de la cuenta 67890
        cuenta67890.retirar(200.0);

        //5. Reintegro de 150€ de la cuenta 67890
        cuenta67890.retirar(150.0);

        //6. Reintegro de 200€ de la cuenta 12345
        cuenta12345.retirar(200.0);

        //7. Ingreso de 50€ en la cuenta 67890
        cuenta67890.ingresar(50.0);

        //8. Reintegro de 100€ de la cuenta 67890 (
        cuenta67890.retirar(100.0);

        System.out.println("\n=== RESULTADOS FINALES DE LAS CUENTAS ===");
        System.out.println("Cuenta " + cuenta12345.getNumero() + " - Saldo final: " + (int)cuenta12345.getSaldo() + "€");
        System.out.println("Cuenta " + cuenta67890.getNumero() + " - Saldo final: " + (int)cuenta67890.getSaldo() + "€");

        // Comprobación de los resultados finales
        assertEquals(-250.0, cuenta12345.getSaldo(), "El saldo de la cuenta 12345 debe ser -250€");
        assertEquals(-450.0, cuenta67890.getSaldo(), "El saldo de la cuenta 67890 debe ser -450€");
    }
}