package marcos.ejerciciosTema5.ejercicio3;

import daw.com.Pantalla;

public class Funcion {

    private String nombre;
    private double duracion;
    private double precio;


    public Funcion(String nombre, double duracion, double precio) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Funcion(Funcion copia) {
        this.nombre = copia.getNombre();
        this.duracion = copia.getDuracion();
        this.precio = copia.getPrecio();
    }

    public double getDuracion() {
        return this.duracion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println(this.getNombre() + " - " + this.getPrecio() + "€ - " + this.getDuracion() + "h");
    }

}
