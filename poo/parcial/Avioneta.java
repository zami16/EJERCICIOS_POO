package poo.parcial;

public class Avioneta extends Avion implements TransportePasajeros {
    private int capacidadPasajeros;
    private Pasajero[] pasajeros;
    private int cantidadPasajeros;

    public Avioneta(String nombre, String matricula, int autonomiaKm, int capacidadPasajeros) {
        super(nombre, matricula, autonomiaKm);
        this.capacidadPasajeros = capacidadPasajeros;
        this.pasajeros = new Pasajero[capacidadPasajeros];
        this.cantidadPasajeros = 0;
    }

    public void agregarPasajero(Pasajero pasajero) {
        if (cantidadPasajeros < capacidadPasajeros) {
            pasajeros[cantidadPasajeros] = pasajero;
            cantidadPasajeros++;
        } else {
            System.out.println("No hay espacio para más pasajeros en esta avioneta.");
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Avioneta: " + getNombre());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Autonomía: " + getAutonomiaKm() + " km");
        System.out.println("Capacidad de pasajeros: " + capacidadPasajeros);
        System.out.println("Pasajeros a bordo:");
        
        for (Pasajero pasajero : pasajeros) {
            if (pasajero != null) {
                System.out.println(" - " + pasajero.getNombre() + " (DNI: " + pasajero.getDni() + ")");
            }
        }
    }

    @Override
    public Pasajero[] getPasajeros() {
        return pasajeros;
    }
}