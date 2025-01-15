package marcos.ejerciciosTema5.ejercicio3;

public class Teatro {

    private String nombre;
    private String direccion;
    public final int FUNCIONES_DIARIAS = 4;
    private final Funcion[] funciones = new Funcion[this.FUNCIONES_DIARIAS];

    public Teatro(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void añadirActuacion(Funcion funcion) {
        if (funcion == null) {
            System.out.println("La funcion introducida es null");
            return;
        }
        boolean added = false;
        for (int i = 0; i < this.funciones.length; i++) {
            if (this.funciones[i] == null) {
                this.funciones[i] = funcion;
                System.out.println("[" + this.getNombre() + "] Se ha añadido la funcion " + funcion.getNombre());
                added = true;
                break;
            }
        }
        if (!added) System.out.println("[" + this.getNombre() + "] Ya no quedan espacios para nuevas funciones!");
    }

    public void añadirFuncion(int index, Funcion funcion) {
        if (funcion == null) {
            System.out.println("La funcion introducia es null");
            return;
        }
        this.funciones[index] = funcion;
        System.out.println("[" + this.getNombre() + "] Se ha añadido la funcion " + funcion.getNombre() + " como " + (index+1) + "ª funcion!");
    }

    public void quitarFuncion(Funcion funcion) {
        if (funcion == null) {
            System.out.println("La funcion introducida es null");
            return;
        }

        boolean removed = false;
        for (int i = 0; i < this.funciones.length; i++) {
            if (this.funciones[i].equals(funcion)) {
                this.funciones[i] = null;
                removed = true;
                System.out.println("[" + this.getNombre() + "] Se ha borrado la funcion " + funcion.getNombre());
            }
        }
        if (!removed) System.out.println("[" + this.getNombre() + "] Esa funcion no esta en el horario diario de hoy!");
    }

    public void quitarFuncion(String nombreFuncion) {
        boolean found = false;
        for (int i = 0; i < this.funciones.length; i++) {
            if (this.funciones[i].getNombre().equalsIgnoreCase(nombreFuncion)) {
                Funcion funcion = this.funciones[i];
                found = true;
                quitarFuncion(funcion);
                break;
            }
        }
        if (!found) System.out.println("[" + this.getNombre() + "] Esa funcion no esta en el horario diario de hoy");
    }

    public void mostrarActuaciones() {
        System.out.println("[" + this.getNombre() + "] Lista de actuaciones de hoy");
        for (int i = 0; i < this.funciones.length; i++) {
            if (this.funciones[i] != null)  {
                Funcion funcion = this.funciones[i];
                System.out.print((i+1) + ". ");
                funcion.mostrarDatos();
            } else {
                System.out.println((i+1) + ". Vacio");
            }
        }
    }

    public void setActuaciones(Funcion[] funciones) {
        this.borrarFunciones();
        for (Funcion funcion : funciones) {
            this.añadirActuacion(funcion);
        }
    }

    public Funcion[] getFunciones() {
        return this.funciones;
    }

    public Funcion obtenerActuacion(String nombre) {
        for (Funcion funcion : this.funciones) {
            if (funcion.getNombre().equalsIgnoreCase(nombre)) {
                return funcion;
            }
        }
        System.out.println("No se ha encontrado la funcion!");
        return null;
    }

    public void borrarFunciones() {
        for (Funcion funcion : this.getFunciones()) {
            this.quitarFuncion(funcion);
        }
    }
}
