package marcos;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Punto {
	private int x;
	private int y;
	
	public Punto () {
		x = 0;
		y = 0;
	}
	
	public Punto (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto (int p[]) {
		this.x = p[0];
		this.y = p[1];
	}
	
	public Punto(Punto punto) {
		this.x = punto.x;
		this.y = punto.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void leerDatos () {
		x = Teclado.leerInt("X :");
		y = Teclado.leerInt("Y :");
	}

	public void mostrarDatos () {
		Pantalla.escribirString("X :" + x);
		Pantalla.escribirString("Y :" + y);
	}
	
	public boolean esIgual (Punto p) {
		boolean igual = true;
		
		if (this.x != p.x || this.y != p.y)
			igual = false;
		
		return igual;
	}
}