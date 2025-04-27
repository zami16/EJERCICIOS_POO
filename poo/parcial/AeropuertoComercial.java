package poo.parcial;

public class AeropuertoComercial extends Aeropuerto {
    private int numeroTerminales;

    public AeropuertoComercial(String nombre, String ciudad, int numeroTerminales) {
        super(nombre, ciudad, 100); 
        this.numeroTerminales = numeroTerminales;
    }

    public int getNumeroTerminales() { return numeroTerminales; }
}