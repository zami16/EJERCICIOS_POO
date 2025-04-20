package poo.Garege;

public interface iGarage {
    double calcularIngresos() throws VamosALaQuiebraException;
    int calcularOcupacionPorTipoVehiculo(Vehiculo v);
}