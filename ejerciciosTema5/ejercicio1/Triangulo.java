package marcos.ejerciciosTema5.ejercicio1;

import marcos.oop.Punto;

public class Triangulo {

    private double base;
    private double lados;

    public Triangulo() {
        this.base = 0;
        this.lados = 0;
    }

    public Triangulo (double base, double lados) {
        this.base = base;
        this.lados = lados;
    }

    public Triangulo(Triangulo copia) {
        this.setLados(copia.getLados());
        this.setBase(copia.getBase());
    }



    public double getAltura() {
        // a² = b² + c² -------> b² = c² - a²
        // a = this.lados
        // b = altura
        // c = this.base / 2;
        return Math.sqrt(Math.abs(Math.pow( this.base / 2, 2) - Math.pow(this.lados, 2)));

    }


    public double getBase() {
        return this.base;
    }

    public double getLados() {
        return this.lados;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setLados(double lados) {
        this.lados = lados;
    }

    public void mostrarDatos() {
        System.out.println("Base: " + this.base);
        System.out.println("Lados: " + this.lados);
        System.out.println("Altura: " + this.getAltura());
        System.out.println("Area: " + this.getArea());
    }
    public double getPerimetro()  {
        return (this.lados * 2) + this.base;
    }
    public double getArea() {
        return Math.abs(this.base * this.getAltura()) / 2;
    }
}
