package marcos.EjercicioNavidad.hundir_la_flota;

public class Barco {

    private final int casillas;
    private final Casilla[] casillasOcupadas;
    private boolean hundido = false;


    public Barco(int casillas) {
        this.casillas = casillas;
        this.casillasOcupadas = new Casilla[this.casillas];
    }

    public int getNumCasillas() {
        return this.casillas;
    }

    public Casilla[] getCasillas() {
        return this.casillasOcupadas;
    }

    public boolean estaEn(Casilla casilla) {
        for (Casilla casillas : this.casillasOcupadas) {
            if (casillas.equals(casilla)) {
                return true;
            }
        }
        return false;
    }

    public void añadirCasilla(Casilla casilla) {
        for (int i = 0; i < this.casillasOcupadas.length; i++)  {
            if (this.casillasOcupadas[i] == null) {
                this.casillasOcupadas[i] = casilla;
                break;
            }
        }
    }

    public boolean debeHundirse() {
        int casillasTocadas = 0;
        for (Casilla casilla : this.getCasillas()) {
            if (casilla.getEstado() == Estado.TOCADO) {
                casillasTocadas++;
            }
        }
        return casillasTocadas >= this.casillas;
    }

    public void hundir() {
        for (Casilla casilla : this.getCasillas()) {
            casilla.setEstado(Estado.HUNDIDO);
        }
        this.hundido = true;
    }

    public boolean hundido() {
        return this.hundido;
    }
}
