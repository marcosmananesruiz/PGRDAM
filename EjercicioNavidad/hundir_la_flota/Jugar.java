package marcos.EjercicioNavidad.hundir_la_flota;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Jugar {

    public static void main(String[] args) {

        int intentos = 0;

        Tablero tablero = new Tablero();
        tablero.colocarBarco(2);
        tablero.colocarBarco(3);
        tablero.colocarBarco(4);
        tablero.colocarBarco(5);


        tablero.mostrarEstado();
        System.out.println("Introduce las coordenadas X Y (Separados por comas. Por ejemplo: 6,4 -> Fila 6, Columna 4)");
        System.out.println("Introduce 'Info' para mas informacion, o 'shipmap' para ver los barcos.");
        while (!tablero.completado()) {
            String coords = Teclado.leerString("[*]>");
            if (coords.contains(",")) {
                int row;
                int col;
                String[] c = coords.split(",");
                if (c.length == 2) {
                    if (esNumero(c[0]) && esNumero(c[1])) {
                        row = Integer.parseInt(c[0]);
                        col = Integer.parseInt(c[1]);
                        if (row < tablero.getArea() && col < tablero.getArea()) {
                            System.out.println("=========================");
                            switch (tablero.bombardeen(row, col)) {
                                case VACIO -> System.out.println("[ ~ AGUA ~ ]");
                                case TOCADO -> System.out.println("[ # TOCADO # ]");
                                case HUNDIDO -> System.out.println("[ X TOCADO Y HUNDIDO X ]");
                            }
                            System.out.println("=========================");
                            tablero.mostrarEstado();
                            intentos++;
                        } else {
                            System.out.println("[ERROR] Posicion fuera del tablero.");
                        }
                    } else {
                        System.out.println("[ERROR] No has introducido cordenadas validas!");
                    }
                } else {
                    System.out.println("[ERROR] No has introducido las cordenaadas correctamente!");
                }
            } else if (coords.equalsIgnoreCase("shipmap")) {
                tablero.mostrarBarcos();
            } else if (coords.equalsIgnoreCase("info")) {
                System.out.println("Informacion del Juego:");
                System.out.println("[ ] -> Celda sin descubrir.");
                System.out.println("[~] -> Celda descubierta con agua.");
                System.out.println("[#] -> Celda descubierta con un barco.");
                System.out.println("[X] -> Barco Hundido");
            } else {
                System.out.println("[ERROR] No has introducido cordenadas validas!");
            }

        }

        Pantalla.escribirSaltoLinea();
        System.out.println("VICTORIA");
        System.out.println("Has ganado en " + intentos + " intentos");
    }

    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
