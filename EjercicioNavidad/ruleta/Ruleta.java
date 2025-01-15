package marcos.EjercicioNavidad.ruleta;

import java.util.Random;

public class Ruleta {

    private final Casilla[] casillas = new Casilla[37];

    public Ruleta() {
        this.llenarTablero();
    }

    public void llenarTablero() {
        for (int i = 0; i < this.casillas.length; i++) {
            switch (i) {
                case 0 -> {
                    this.casillas[i] = new Casilla(0, ColorCasilla.VERDE);
                }
                case 1,3,5,9,12,14,16,18,19,21,23,25,27,30,32,34,36 -> {
                    this.casillas[i] = new Casilla(i, ColorCasilla.ROJO);
                }
                default -> {
                    this.casillas[i] = new Casilla(i, ColorCasilla.NEGRO);
                }
            }
        }
    }

    public Casilla girar() {
        return this.casillas[new Random().nextInt(this.casillas.length)];
    }
}
