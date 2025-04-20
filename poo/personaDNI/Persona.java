package poo.personaDNI;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public void esMayorDeEdad(int edadMayoria) {
        if (edad >= edadMayoria) {
            System.out.println(nombre + " es mayor de edad");
        } else {
            System.out.println(nombre + " no es mayor de edad");
        }
    }

    public int cuantoHaceMayorEdad(int edadMayoria) {
        if (edad >= edadMayoria) {
            return edad - edadMayoria;
        }
        return 0;
    }

    public boolean asignarDNI(String dni) {
        if (dni != null && dni.length() == 9) {
            this.dni = dni;
            return true;
        }
        return false;
    }

    public boolean estaJubilado(int edadDeJubilacion) {
        return edad >= edadDeJubilacion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }
}