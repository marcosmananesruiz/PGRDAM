package marcos.ejerciciosTema5.ejercicio1;

import daw.com.Pantalla;

public class Ejercicio {

    public static void main(String[] args) {
        Triangulo[] arrayTriangulos = new Triangulo[5];

        double maxArea = 0.0D;

        int numT = 0;
        for (int i = 0; i < arrayTriangulos.length; i++) {
            arrayTriangulos[i] = new Triangulo((Math.random()+1)*5, (Math.random()+1)*5);
            System.out.println("Trinalgulo " + (i+1) + ":");
            arrayTriangulos[i].mostrarDatos();
            if (arrayTriangulos[i].getArea() > maxArea) {
                maxArea = arrayTriangulos[i].getArea();
                numT = i+1;
            }
            Pantalla.escribirSaltoLinea();

        }
        Pantalla.escribirSaltoLinea();
        System.out.println("El Triangulo " + numT + " tiene el area mas grande de " + maxArea);
    }
}
