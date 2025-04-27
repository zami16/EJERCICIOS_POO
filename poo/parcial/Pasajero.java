package poo.parcial;

public class Pasajero {
    private String nombre;
    private String dni;
    private int edad;

    public Pasajero(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public int getEdad() { return edad; }
}