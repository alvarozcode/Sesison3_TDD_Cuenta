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

    public void ingresar(double x) {
    	//Vacío,
    }

    public void retirar(double x) {
        //Vacío.
    }

    public double getSaldo() {
        return 500.0; 
    }
}