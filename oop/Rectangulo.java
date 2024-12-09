package marcos.oop;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Rectangulo {
	private int b;
	private int h;
	private Punto centro;
	private int color;
	
	public Rectangulo() {
		this.b = 0;
		this.h = 0;
		this.centro = new Punto();
		this.color = 0;
	}
	
	public Rectangulo(int b, int h, Punto centro, int color) {
		this.b = b;
		this.h = h;
		this.centro = centro;
		this.color = color;
	}
	public Rectangulo(Rectangulo copy) {
		this.b = copy.getBase();
		this.h = copy.getAltura();
	}



	public int getBase() {
		return b;
	}
	public void setBase(int b) {
		this.b = b;
	}
	public int getAltura() {
		return h;
	}
	public void setAltura(int h) {
		this.h = h;
	}
	public Punto getCentro() {
		return this.centro;
	}
	public void setCentro(Punto punto) {
		this.centro = punto;
	}
	public int getColor() {
		return this.color;
	}
	public void setColot(int color) {
		this.color = color;
	}
	public int area() {
		return this.b * this.h;
	}
	public int perimetro() {
		return this.b * 2 + this.h * 2;
	}
	
	public void mostrarDatos() {
		this.centro.mostrarDatos();
		Pantalla.escribirString("Base: " + b);
		Pantalla.escribirString("Altura: " + h);
	}
	public void cambiarDatos() {
		setBase(Teclado.leerInt("Introduce la base del rectangulo"));
		setAltura(Teclado.leerInt("Introduce la altura del rectanguo"));

		this.mostrarDatos();
	}
}
