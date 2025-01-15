package marcos.EjercicioNavidad.ruleta;

import java.util.ArrayList;
import java.util.List;

public class Apuesta {

    private List<Integer> apuestaNumeros = new ArrayList<>();
    private List<ColorCasilla> apuestaColores = new ArrayList<>();
    private double dinero;
    private int fichas = 0;
    private boolean terminada = false;

    public Apuesta(double dinero) {
        this.dinero = dinero;
    }

    public void añadirNumero(int num) {
        if (!this.apuestaNumeros.contains(num)) this.apuestaNumeros.add(num);
        fichas++;
    }

    public void añadirNumeros(int... nums) {
        for (int i : nums) {
            if (!this.apuestaNumeros.contains(i)) this.apuestaNumeros.add(i);
            fichas++;
        }
    }
    public void añadirNumeros(List<Integer> numeros) {
        for (int i : numeros) {
            if (!this.apuestaNumeros.contains(i)) this.apuestaNumeros.add(i);
            fichas++;
        }
    }
    public void apostarPares() {
        for (int i = 0; i <= 36; i += 2) {
            if (!this.apuestaNumeros.contains(i)) this.apuestaNumeros.add(i);
        }
        fichas++;
    }
    public void apostarImpares() {
        for (int i = 1; i <= 35; i += 2) {
            if (!this.apuestaNumeros.contains(i)) this.apuestaNumeros.add(i);
        }
        fichas++;
    }

    public void añadirColor(ColorCasilla color) {
        if (!this.apuestaColores.contains(color)) {
            this.apuestaColores.add(color);
            fichas++;
        }
    }

    public void terminarApuesta() {
        this.terminada = true;
    }
    public boolean terminada() {
        return this.terminada;
    }

    public List<Integer> numerosApostados() {
        return this.apuestaNumeros;
    }
    public List<ColorCasilla> coloresApostados() {
        return this.apuestaColores;
    }




}
