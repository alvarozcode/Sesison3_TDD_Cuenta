package sesion_TDD;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    String mNumero;
    String nTitular;
    List<Movimiento> mMovimientos;

    public Cuenta(String numero, String titular) {
        this.mNumero = numero;
        this.nTitular = titular;
        this.mMovimientos = new ArrayList<>();
    }

    public Cuenta(String numero, String titular, double saldoInicial) {
        this(numero, titular);
        if (saldoInicial != 0.0) {
            mMovimientos.add(new Movimiento(saldoInicial, Signo.H, "Saldo inicial"));
        }
    }

    public void ingresar(double x) {
        if (x > 0) {
            mMovimientos.add(new Movimiento(x, Signo.H, "Ingreso en efectivo"));
        }
    }

    public void retirar(double x) {
        // Límite de descubierto de 500€ (el saldo no puede bajar de -500.0€)
        if (x > 0 && (getSaldo() - x) >= -500.0) {
            mMovimientos.add(new Movimiento(x, Signo.D, "Retirada de efectivo"));
        } else {
            // Imprime exactamente el formato de error solicitado en la imagen
            System.out.println("Fondos insuficientes (saldo " + (int)getSaldo() + "€) en la cuenta " 
                               + mNumero + " para el reintegro de " + (int)x + "€");
        }
    }

    public double getSaldo() {
        double saldo = 0.0;
        for (Movimiento m : mMovimientos) {
            if (m.getSigno() == Signo.H) {
                saldo += m.getImporte();
            } else if (m.getSigno() == Signo.D) {
                saldo -= m.getImporte();
            }
        }
        return saldo;
    }

    public String getNumero() {
        return mNumero;
    }
}