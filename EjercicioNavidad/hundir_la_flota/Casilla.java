package marcos.EjercicioNavidad.hundir_la_flota;

public class Casilla {

    private int columna;
    private int fila;
    private Estado estado;
    private boolean tieneBarco;

    public Casilla(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        this.estado = Estado.SIN_DESCUBRIR;
        this.tieneBarco = false;
    }

    public int getColumna() {
        return this.columna;
    }

    public int getFila() {
        return this.fila;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void tieneBarco(boolean tieneBarco) {
        this.tieneBarco = tieneBarco;
    }
    public boolean tieneBarco() {
        return this.tieneBarco;
    }
}
