package marcos.EjercicioNavidad.hundir_la_flota;

import java.util.Random;

public enum Direccion {
    UP,
    DOWN,
    LEFT,
    RIGHT;


    public static Direccion getRandomDir() {
        Direccion[] directions = values();
        return directions[new Random().nextInt(directions.length)];
    }

}
