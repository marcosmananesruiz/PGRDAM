package marcos.EjercicioNavidad.ruleta;

public class Casilla {

    private final ColorCasilla color;
    private final int numero;

    public Casilla(int numero, ColorCasilla color) {
        this.numero = numero;
        this.color = color;
    }


    public ColorCasilla getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

}
