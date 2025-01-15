package marcos.ejerciciosTema5.ejercicio3;

import daw.com.Pantalla;
import daw.com.Teclado;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    public static void main(String[] args) {
        List<Teatro> teatros = new ArrayList<>();
        while (true) {
            Pantalla.escribirSaltoLinea();
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Seleccionar un teatro");
            System.out.println("2. Añadir un treatro");
            System.out.println("3. Quitar un teatro");
            System.out.println("4. Salir");
            int option = Teclado.leerInt("[*]>");

            while (!esRango(option, 4)) {
                System.out.println("Opcion no valida!");
                option = Teclado.leerInt("[*]>");
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Lista de Teatros:");
                    boolean vacio = true;
                    for (int i = 0; i < teatros.size(); i++) {
                        System.out.println((i+1) + ". " + teatros.get(i).getNombre());
                        vacio = false;
                    }
                    if (vacio) {
                        System.out.println("No hay teatros registrados aun");
                    } else {
                        int selected = Teclado.leerInt("[*]>");
                        while (!esRango(selected, teatros.size())) {
                            System.out.println("Opcion no valida!");
                            selected = Teclado.leerInt("[*]>");
                        }


                        Teatro teatro = teatros.get(selected-1);
                        abrirTeatro(teatro);
                    }
                }
                case 2 -> {
                    String nombre = Teclado.leerString("Introduce el nombre del teatro:");
                    String direccion = Teclado.leerString("Introduce la direccion del teatro:");
                    Teatro teatro = new Teatro(nombre, direccion);
                    teatros.add(teatro);
                    System.out.println("Se ha registrado el teatro " + teatro.getNombre());
                }
                case 3 -> {
                    boolean vacio = true;
                    for (int i = 0; i < teatros.size(); i++) {
                        System.out.println((i+1) + ". " + teatros.get(i).getNombre());
                        vacio = false;
                    }
                    if (vacio) {
                        System.out.println("No hay teatros registrados aun");
                    } else {
                        int selected = Teclado.leerInt("[*]>");

                        while (!esRango(selected, teatros.size())) {
                            System.out.println("Opcion no valida!");
                            selected = Teclado.leerInt("[*]>");
                        }

                        Teatro teatro = teatros.get(selected-1);
                        teatros.remove(teatro);
                        System.out.println("Se ha eliminado el teatro " + teatro.getNombre());
                    }
                }
                case 4 -> {
                    System.out.println("Cerrando el programa...");
                    System.out.println("Que tenga un buen dia!");
                    return;
                }
                default -> {
                    System.out.println("Enhorabuena, rompiste el programa, te llevaste un chicle");
                }
            }
        }


    }

    private static boolean esRango(int num, int rango) {
        return num > 0 && num <= rango;
    }
    private static void abrirTeatro(Teatro teatro) {

        System.out.println("Teatro " + teatro.getNombre());
        System.out.println("1. Seleccionar una funcion");
        System.out.println("2. Añadir una funcion");
        System.out.println("3. Cancelar una funcion");
        System.out.println("4. Mostrar todas las funciones programdas");
        System.out.println("5. Cambiar nombre del teatro");
        System.out.println("6. Cambiar direccion del teatro");
        System.out.println("7. Volver");
        int option = Teclado.leerInt("[*]>");
        while (!esRango(option, 7)) {
            System.out.println("Opcion no valida!");
            option = Teclado.leerInt("[*]>");
        }

        switch (option) {
            case 1 -> {
                for (int i = 0; i < teatro.getFunciones().length; i++) {
                    System.out.println((i+1) + ". " + teatro.getFunciones()[i]);
                }
                int selected = Teclado.leerInt("[*]>");
                while (!esRango(selected, teatro.getFunciones().length)) {
                    System.out.println("Opcion no valida!");
                    selected = Teclado.leerInt("[*]>");
                }

                Funcion funcion = teatro.getFunciones()[selected-1];
                abrirFuncion(teatro, funcion);
            }
            case 2 -> {

                double duracion;
                double precio;

                String nombre = Teclado.leerString("Introduce el nombre de la funcion:");

                String d = Teclado.leerString("Introduce la duracion de la funcion:");
                while (!esNumero(d) || d.isEmpty()) d = Teclado.leerString("Introduce la duracion de la funcion");
                duracion = Double.parseDouble(d);

                String p = Teclado.leerString("Introduce el precio de la funcion:");
                while (!esNumero(p) || p.isEmpty()) p = Teclado.leerString("Introduce el precio de la funcion");
                precio = Double.parseDouble(p);

                Funcion funcion = new Funcion(nombre, duracion, precio);
                teatro.añadirActuacion(funcion);
            }
            case 3 -> {
                for (int i = 0; i < teatro.getFunciones().length; i++) {
                    System.out.println((i+1) + ". " + teatro.getFunciones()[i].getNombre());
                }
                int selected = Teclado.leerInt("[*]>");
                while (!esRango(selected, teatro.getFunciones().length)) {
                    System.out.println("Opcion no valida!");
                    selected = Teclado.leerInt("[*]>");
                }

                Funcion funcion = teatro.getFunciones()[selected-1];
                teatro.quitarFuncion(funcion);
            }
            case 4 -> {
                teatro.mostrarActuaciones();
            }
            case 5 -> {
                String nuevoNombre = Teclado.leerString("Introduce el nuevo nombre del teatro:");

                if (nuevoNombre.isEmpty()) {
                    System.out.println("Nombre en blanco: No se cambio el nombre del teatro");
                } else {
                    teatro.setNombre(nuevoNombre);
                    System.out.println("Se ha cambiado el nombre del teatro a " + teatro.getNombre());
                }

            }
            case 6 -> {

                String nuevaDireccion = Teclado.leerString("Introduce la nueva direccion del teatro:");

                if (nuevaDireccion.isEmpty()) {
                    System.out.println("Direccion en blanco: No se cambio la direccion del teatro");
                } else {
                    teatro.setDireccion(nuevaDireccion);
                    System.out.println("Se ha cambiado la direccion del teatro a " + teatro.getDireccion());
                }

            }
            case 7 -> {
                // No hace nada para que pueda volver.
            }
            default -> {
                System.out.println("Enhorabuena, rompiste el programa, te ganaste un chicle");
            }
        }
    }

    private static void abrirFuncion(Teatro teatro, Funcion funcion) {
        System.out.println("Actuacion " + funcion.getNombre());
        System.out.println("1. Mostrar Informacion");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Cambiar precio");
        System.out.println("4. Cambiar duracion");
        System.out.println("5. Volver");
        int option = Teclado.leerInt("[*]>");

        while (!esRango(option, 5)) {
            System.out.println("Opcion no valida!");
            option = Teclado.leerInt("[*]>");
        }

        switch (option) {
            case 1 -> {
                System.out.println("Nombre de la funcion: " + funcion.getNombre());
                System.out.println("Duracion de la funcion: " + funcion.getDuracion() + "h");
                System.out.println("Precio de la funcion: " + funcion.getPrecio() + "€");
            }
            case 2 -> {
                String nuevoNombre = Teclado.leerString("Introduce el nuevo nombre de la funcion:");

                if (nuevoNombre.isEmpty()) {
                    System.out.println("Nombre en blanco: No se cambio el nombre de la funcion");
                } else {
                    funcion.setNombre(nuevoNombre);
                    System.out.println("Se ha cambiado el nombre de la funcion a " + funcion.getNombre());
                }
            }

            case 3 -> {
                String nuevoPrecio = Teclado.leerString("Introduce el nuevo precio de la funcion:");

                if (esNumero(nuevoPrecio) && !nuevoPrecio.isEmpty()) {
                    funcion.setPrecio(Double.parseDouble(nuevoPrecio));
                    System.out.println("Se ha cambiado el precio de la funcion a " + Double.parseDouble(nuevoPrecio) + "€");
                } else {
                    System.out.println("Precio en blanco o no valido: No se cambio el precio de la funcion");
                }
            }
            case 4 -> {
                String nuevaDuracion = Teclado.leerString("Introduce la nueva duracion de la funcion:");

                if (esNumero(nuevaDuracion) && !nuevaDuracion.isEmpty()) {
                    funcion.setDuracion(Integer.parseInt(nuevaDuracion));
                    System.out.println("Se ha cambiado la duracion de la funcion a " + Integer.parseInt(nuevaDuracion) + "h");
                } else {
                    System.out.println("Duracion en blanco o no valida: No se cambio la duracion de la funcion");
                }
            }
            case 5 -> {
                abrirTeatro(teatro);
            }
        }


    }
    private static boolean esNumero(String numero) {
        if (numero == null) return false;

        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
