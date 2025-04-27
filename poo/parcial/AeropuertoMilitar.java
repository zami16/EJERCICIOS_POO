package poo.parcial;

public class AeropuertoMilitar extends Aeropuerto {
    private String nombreClave;

    public AeropuertoMilitar(String nombre, String ciudad, String nombreClave) {
        super(nombre, ciudad, 50); 
        this.nombreClave = nombreClave;
    }

    public String getNombreClave() { return nombreClave; }
}