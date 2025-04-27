package poo.parcial;

public abstract class Avion {
    private String nombre;
    private String matricula;
    private int autonomiaKm;

    public Avion(String nombre, String matricula, int autonomiaKm) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.autonomiaKm = autonomiaKm;
    }
    public abstract void mostrarInformacion();

    public String getNombre() { return nombre; }
    public String getMatricula() { return matricula; }
    public int getAutonomiaKm() { return autonomiaKm; }
}