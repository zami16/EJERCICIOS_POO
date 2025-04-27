package poo.parcial;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private Avion[] aviones;
    private int cantidadAviones;

    public Aeropuerto(String nombre, String ciudad, int capacidadAviones) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.aviones = new Avion[capacidadAviones];
        this.cantidadAviones = 0;
    }

    public void agregarAvion(Avion avion) {
        if (cantidadAviones < aviones.length) {
            aviones[cantidadAviones] = avion;
            cantidadAviones++;
        } else {
            System.out.println("No hay espacio para más aviones en este aeropuerto.");
        }
    }

    public void mostrarInformacionAviones() {
        System.out.println("Aviones en " + nombre + ":");
        for (Avion avion : aviones) {
            if (avion != null) {
                avion.mostrarInformacion();
            }
        }
    }

    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public Avion[] getAviones() { return aviones; }
}