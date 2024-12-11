package marcos.oop;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Rectangulo {

	private int color;
	private Punto centro;
	private double base;
	private double altura;
	
	public Rectangulo() {
		this.color = 0;
		this.base = 0.0;
		this.altura = 0.0;
		this.centro = new Punto();
	}	
	
	public Rectangulo(int color, Punto centro, double base, double altura) {
		this.color = color;
		this.centro = centro;
		this.base = base;
		this.altura = altura;
	}

	public Rectangulo(Rectangulo r) {
		this.color = r.color;
		this.base = r.base;
		this.altura = r.altura;
		this.centro = new Punto(r.centro);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void mostrarDatos() {
		Pantalla.escribirString("Base del rectángulo: ", String.valueOf(base));
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("Altura del rectángulo: ", String.valueOf(altura));
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("Color del rectángulo: ", String.valueOf(color));
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("");
		this.centro.mostrarDatos();
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirSaltoLinea();
	}

	/*
	 * Código duplicado
	 * Control de errores
	 * No usa métodos, los redefine
	 * No se ha leído la documentación de Teclado
	 *
	 * Crear funciones para evitar código duplicado
	 * Modificar leerDatos() para cumplir especificaciones
	 * Usar los métodos adecuados para cada tipo
	 * Buscar un método para realizar conversiones seguras
	 */


	public void cambiarDatos() {

		do {
			setAltura(this.cambiarPropiedadDouble("Indica la nueva altura"));
		} while (Double.isNaN(this.altura) || this.altura < 0); // Como es el valor de la altura, no deberia tener un valor negativo

		do {
			setBase(this.cambiarPropiedadDouble("Indica la nueva base"));
		} while (Double.isNaN(this.base) || this.base < 0); // Como es el valor de la base, no deberia tener un valor negativo

		do {
			setColor(this.cambiarPropiedadInt("Indica el nuevo color"));
		} while (this.color == Integer.MAX_VALUE || this.color < 0); // Como es el valor del color, no deberia tener un valor negativo

		do {
			this.centro.setX(this.cambiarPropiedadInt("Indica el nuevo valor de X del punto:"));
		} while (this.centro.getX() == Integer.MAX_VALUE);

		do {
			this.centro.setY(this.cambiarPropiedadInt("Indica el nuevo valor de Y del punto:"));
		} while (this.centro.getY() == Integer.MAX_VALUE);

		this.mostrarDatos();
	}

	// Como hay valores int y double, necesito tener una funcion para cada tipo de dato

	private int cambiarPropiedadInt(String mensaje) {
		String num = Teclado.leerString(mensaje);
		if (esNumero(num) && !num.isEmpty())
			return Integer.parseInt(num);
		return Integer.MAX_VALUE;
	}

	private double cambiarPropiedadDouble(String mensaje) {
		String num = Teclado.leerString(mensaje);
		if (esNumero(num) && !num.isEmpty())
			return Double.parseDouble(num);
		return Double.NaN;
	}


	// Funcion de utilidad que me sirve para comprobar si un string se puede transformar a numero
	private boolean esNumero(String numero) {
		if (numero != null) {
			try	{
				Double.parseDouble(numero);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

}
