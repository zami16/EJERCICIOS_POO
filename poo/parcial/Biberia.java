package poo.parcial;

public class Biberia {
    private Aeropuerto[] aeropuertos;
    public Biberia() {
        aeropuertos = new Aeropuerto[3];

        aeropuertos[0] = new AeropuertoMilitar("Base Aérea Alfa", "Madrid", "Águila Real");
        aeropuertos[1] = new AeropuertoComercial("Aeropuerto Internacional", "Barcelona", 4);
        aeropuertos[2] = new AeropuertoComercial("Aeropuerto del Norte", "Bilbao", 2);
    }
    public void consultarPasajero(String nombrePasajero) {
        boolean encontrado = false;   
        for (Aeropuerto aeropuerto : aeropuertos) {
            Avion[] aviones = aeropuerto.getAviones();
            for (Avion avion : aviones) {
                if (avion instanceof TransportePasajeros) {
                    TransportePasajeros avionPasajeros = (TransportePasajeros) avion;
                    Pasajero[] pasajeros = avionPasajeros.getPasajeros();
                    for (Pasajero pasajero : pasajeros) {
                        if (pasajero != null && pasajero.getNombre().equals(nombrePasajero)) {
                            System.out.println("Pasajero encontrado:");
                            System.out.println("Nombre: " + pasajero.getNombre());
                            System.out.println("Avión: " + avion.getNombre() + " (" + avion.getMatricula() + ")");
                            System.out.println("Aeropuerto: " + aeropuerto.getNombre() + " - " + aeropuerto.getCiudad());
                            encontrado = true;
                            return;
                        }
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Pasajero no encontrado en ningún avión.");
        }
    }
    public static void main(String[] args) {
        Biberia biberia = new Biberia();
        AvionPasajeros avion1 = new AvionPasajeros("Vuelo 123", "ABC-123", 5000, 150);
        avion1.agregarPasajero(new Pasajero("Juan Pérez", "12345678A", 35));
        avion1.agregarPasajero(new Pasajero("María García", "87654321B", 28));
        biberia.aeropuertos[1].agregarAvion(avion1);
        Avioneta avioneta1 = new Avioneta("SkyRunner", "XYZ-987", 800, 4);
        avioneta1.agregarPasajero(new Pasajero("Carlos López", "11223344C", 42));
        biberia.aeropuertos[0].agregarAvion(avioneta1);
        biberia.consultarPasajero("Juan Pérez");
        biberia.consultarPasajero("Pedro Sánchez");
    }
}