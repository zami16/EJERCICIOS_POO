package poo.parcial;

public class AvionCarga extends Avion {
    private int cargaMaximaKg;

    public AvionCarga(String nombre, String matricula, int autonomiaKm, int cargaMaximaKg) {
        super(nombre, matricula, autonomiaKm);
        this.cargaMaximaKg = cargaMaximaKg;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Avión de Carga: " + getNombre());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Autonomía: " + getAutonomiaKm() + " km");
        System.out.println("Carga máxima: " + cargaMaximaKg + " kg");
    }
}