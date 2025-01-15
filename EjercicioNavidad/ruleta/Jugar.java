package marcos.EjercicioNavidad.ruleta;

import com.sun.security.auth.callback.TextCallbackHandler;
import daw.com.Pantalla;
import daw.com.Teclado;

import java.lang.runtime.SwitchBootstraps;

public class Jugar {
    public static void main(String[] args) {
        Ruleta ruleta = new Ruleta();

        Apuesta apuesta = new Apuesta(10);
        while (!apuesta.terminada()) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Apostar numero.");
            System.out.println("2. Apostar Color");
            System.out.println("3. Apostar Pares");
            System.out.println("4. Apostar Impares");
            System.out.println("5. Terminar apuesta.");
            int option = Teclado.leerInt("[*]>");

            while (!validOption(option, 5)) option = Teclado.leerInt("[*]>");

            switch (option) {
                case 1 -> {
                    int numero = Teclado.leerInt("Introduzca el numero a apostar [0-36]:");
                    while (!validOption(numero, 36)) numero = Teclado.leerInt("Numero no valido: Introduzca un numero valido [0-36]:");
                    apuesta.añadirNumero(numero);
                    System.out.println("Se ha añadido el numero " + numero + " a la apuesta.");
                }
                case 2 -> {
                    System.out.println("Seleccione un color:");
                    System.out.println("1. Rojo");
                    System.out.println("2. Negro");
                    System.out.println("3. Verde");
                    int color = Teclado.leerInt("[*]>");
                    while (!validOption(color, 3)) color = Teclado.leerInt("[*]>");
                    switch (color) {
                        case 1 -> {
                            apuesta.añadirColor(ColorCasilla.ROJO);
                            System.out.println("Se ha añadido el color Rojo a la apuesta");
                        }
                        case 2 -> {
                            apuesta.añadirColor(ColorCasilla.NEGRO);
                            System.out.println("Se ha añadido el color Negro a la apuesta");
                        }
                        case 3 -> {
                            apuesta.añadirColor(ColorCasilla.VERDE);
                            System.out.println("Se ha añadido el color Verde a la apuesta");
                        }
                        default -> {
                            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                                System.out.println("XD");
                            }
                        }
                    }
                }
                case 3 -> {
                    apuesta.apostarPares();
                    System.out.println("Se han añadido los numeros pares a la apuesta");
                }
                case 4 -> {
                    apuesta.apostarImpares();
                    System.out.println("Se han añadido los numeros impares a la apuesta");
                }
                case 5 -> {
                    apuesta.terminarApuesta();
                }
            }
        }
        System.out.println("Datos apuesta:");
        System.out.println("Numeros:");
        for (int i : apuesta.numerosApostados()) {
            Pantalla.escribirString(i + " ");
        }
        Pantalla.escribirSaltoLinea();
        System.out.println("Colores:");
        for (ColorCasilla color : apuesta.coloresApostados()) {
            Pantalla.escribirString(color + " ");
        }
        Pantalla.escribirSaltoLinea();


        Casilla casilla = ruleta.girar();

        System.out.println("Ha salido la casilla " + casilla.getNumero() + " " + casilla.getColor());
        
    }

    private static boolean validOption(int opt, int range) {
        return opt > 0 && opt <= range;
    }
}
