package marcos.EjercicioNavidad.hundir_la_flota;

import daw.com.Pantalla;

import java.util.Random;

public class Tablero {

    private final int AREA = 10;
    private final Casilla[][] casillas = new Casilla[AREA][AREA];
    private final Barco[] barcos = new Barco[10];

    public Tablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(i, j);
            }
        }
    }

    public int añadirBarco(Barco barco, int col, int row, Direccion direccion) {

        if (col > AREA || row > AREA) return -2;

        for (int i = 0; i < this.barcos.length; i++) {
            if (this.barcos[i] == null) {
                this.barcos[i] = barco;
                break;
            }
        }

        Casilla casilla = this.getCasilla(col, row);
        if (barcoEnMedio(barco, casilla, direccion)) {
            System.out.println("Barco Fallido!");
            return -1;
        }



        switch (direccion) {
            case UP -> {
                for (int i = 0; i < barco.getNumCasillas(); i++) {
                    if (casilla.getColumna() - barco.getNumCasillas() >= 0) {
                        casillas[casilla.getColumna()-i][casilla.getFila()].tieneBarco(true);
                        barco.añadirCasilla(casillas[casilla.getColumna()-i][casilla.getFila()]);
                    } else {
                        System.out.println("Barco Fallido!");
                        break;
                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < barco.getNumCasillas(); i++) {
                    if (casilla.getColumna() + barco.getNumCasillas() < AREA) {
                        casillas[casilla.getColumna()+i][casilla.getFila()].tieneBarco(true);
                        barco.añadirCasilla(casillas[casilla.getColumna()+i][casilla.getFila()]);
                    } else {
                        System.out.println("Barco Fallido!");
                        break;
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < barco.getNumCasillas(); i++) {
                    if (casilla.getFila() + barco.getNumCasillas() < AREA) {
                        casillas[casilla.getColumna()][casilla.getFila()+i].tieneBarco(true);
                        barco.añadirCasilla(casillas[casilla.getColumna()][casilla.getFila()+i]);
                    } else {
                        System.out.println("Barco Fallido!");
                        break;
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < barco.getNumCasillas(); i++) {
                    if (casilla.getFila() - barco.getNumCasillas() >= 0) {
                        casillas[casilla.getColumna()][casilla.getFila()-i].tieneBarco(true);
                        barco.añadirCasilla(casillas[casilla.getColumna()][casilla.getFila()-i]);
                    } else {
                        System.out.println("Barco Fallido!");
                        break;
                    }
                }
            }
            default -> {

            }
        }
        return 0;
    }

    public boolean puedeColocarBarco(int largo, int col, int row, Direccion direccion) {

        Casilla casilla = getCasilla(col, row);

        if (barcoEnMedio(new Barco(largo), casilla, direccion)) return false;

        switch (direccion) {
            case UP -> {
                if (casilla.getColumna() - largo < 0) {
                    return false;
                }
            }
            case DOWN -> {
                if (casilla.getColumna() + largo >= AREA) {
                    return false;
                }
            }
            case RIGHT -> {
                if (casilla.getFila() + largo >= AREA) {
                    return false;
                }
            }
            case LEFT -> {
                if (casilla.getFila() - largo < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean tieneBarco(Casilla casilla) {
        return casilla.tieneBarco();
    }

    public Result bombardeen(int col, int row) {
        if (this.casillas[col][row].tieneBarco()) {
            this.casillas[col][row].setEstado(Estado.TOCADO);
            Barco barco = this.barcoEn(this.casillas[col][row]);

            if (barco.debeHundirse()) {
                barco.hundir();
                return Result.HUNDIDO;
            }

            return Result.TOCADO;

        } else {
            this.casillas[col][row].setEstado(Estado.VACIO);
            return Result.VACIO;
        }

    }

    public Barco barcoEn(Casilla casilla) {
        for (Barco barco : this.barcos) {
            if (barco.estaEn(casilla)) {
                return barco;
            }
        }
        return null;
    }

    public Casilla getCasilla(int col, int row) {
        for (Casilla[] casilla : this.casillas) {
            for (Casilla value : casilla) {
                if (value.getColumna() == col && value.getFila() == row) {
                    return value;
                }
            }
        }
        return null;
    }

    private boolean barcoEnMedio(Barco barco, Casilla casilla, Direccion direccion) {
        try {
            switch (direccion) {
                case UP -> {
                    for (int i = 0; i < barco.getNumCasillas(); i++) {
                        if (this.casillas[casilla.getColumna()-i][casilla.getFila()].tieneBarco()) {
                            return true;
                        }
                    }
                    return false;
                }
                case DOWN -> {
                    for (int i = 0; i < barco.getNumCasillas(); i++) {
                        if (this.casillas[casilla.getColumna()+i][casilla.getFila()].tieneBarco()) {
                            return true;
                        }
                    }
                    return false;
                }
                case RIGHT -> {
                    for (int i = 0; i < barco.getNumCasillas(); i++) {
                        if (this.casillas[casilla.getColumna()][casilla.getFila()+i].tieneBarco()) {
                            return true;
                        }
                    }
                    return false;
                }
                case LEFT -> {
                    for (int i = 0; i < barco.getNumCasillas(); i++) {
                        if (this.casillas[casilla.getColumna()][casilla.getFila()-i].tieneBarco()) {
                            return true;
                        }
                    }
                    return false;
                }
                default -> {

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    public void mostrarBarcos() {
        System.out.println("TABLERO CON BARCOS");
        Pantalla.escribirString("  ");
        for (int i = 0; i < this.casillas[0].length; i++) {
            Pantalla.escribirString(" " + i + " ");
        }
        Pantalla.escribirSaltoLinea();
        for (int i = 0; i < this.casillas.length; i++) {
            Pantalla.escribirString(i + " ");
            for (int j = 0; j < this.casillas[i].length; j++) {
                if (this.casillas[i][j].tieneBarco()) {
                    Pantalla.escribirString("[#]");
                } else {
                    Pantalla.escribirString("[ ]");
                }
            }
            Pantalla.escribirSaltoLinea();
        }
    }

    public void mostrarEstado() {
        System.out.println("ESTADO DEL TABLERO");
        Pantalla.escribirString("    ");
        for (int i = 0; i < this.casillas[0].length; i++) {
            Pantalla.escribirString(i + "  ");
        }
        Pantalla.escribirSaltoLinea();
        for (int i = 0; i < this.casillas.length; i++) {
            Pantalla.escribirString(" " + i + " ");
            for (int j = 0; j < this.casillas[i].length; j++) {
                switch (this.casillas[i][j].getEstado()) {
                    case SIN_DESCUBRIR -> Pantalla.escribirString("[ ]");
                    case VACIO -> Pantalla.escribirString("[~]");
                    case TOCADO -> Pantalla.escribirString("[#]");
                    case HUNDIDO -> Pantalla.escribirString("[X]");
                    case null, default -> Pantalla.escribirString("[E]");
                }
            }
            Pantalla.escribirSaltoLinea();
        }
    }

    public void colocarBarco(int largo) {


        Random random = new Random();
        int col;
        int row;
        Direccion direccion;

        do {
            col = random.nextInt(AREA);
            row = random.nextInt(AREA);
            direccion = Direccion.getRandomDir();
        } while (!this.puedeColocarBarco(largo, col, row, direccion));
        this.añadirBarco(new Barco(largo), col, row, direccion);
    }

    public boolean completado() {
        for (Barco barco : this.barcos) {
            if (barco != null) {
                if (!barco.hundido()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getArea() {
        return this.AREA;
    }

}
