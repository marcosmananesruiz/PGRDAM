package marcos;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Circulo {
	
	private int radio;
	private Punto centro;
	private int color;
	
	public static final float MIPI = 3.14f;
	
	
	public Circulo(int radio, Punto centro, int color) {

		this.radio = radio;
		this.centro = centro;
		this.color = color;
	}
	
	public Circulo() {
		
		this.radio = 0;
		this.centro = new Punto ();
		this.color = 0;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public float area ()
	{
		return (float)Math.PI * radio * radio;
	}
	
	public void mostrarDatos()
	{
		this.centro.mostrarDatos();
		Pantalla.escribirString("Radio :" + radio);
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("Color :" + color);
	}
	
	public void leerDatos()
	{
		centro.leerDatos();
		setRadio (Teclado.leerInt("radio :"));
		setColor (Teclado.leerInt("color :"));
	}
}
