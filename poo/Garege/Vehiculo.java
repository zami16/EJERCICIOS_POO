package poo.Garege;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String matricula;
    private String marca;
    private double precio;
    private int cilindrada;
    private double impuestoCirculacion;
    private double cuotaMesGarage;

    private static final double CUOTA_DEFECTO = 100;
    

    public Vehiculo(String marca, double precio, int cilindrada) {
        this.matricula = null;
        this.marca = marca;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.cuotaMesGarage = CUOTA_DEFECTO;
        calcularImpuestoCirculacion();
    }
    
    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
        calcularImpuestoCirculacion(); // Recalcular el impuesto al cambiar el precio
    }
    
    public int getCilindrada() {
        return cilindrada;
    }
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }
    
    public double getCuotaMesGarage() {
        return cuotaMesGarage;
    }
    
    public void setCuotaMesGarage(double cuotaMesGarage) throws CuotaNegativaException {
        if (cuotaMesGarage < 0) {
            throw new CuotaNegativaException("No se puede establecer una cuota negativa");
        }
        this.cuotaMesGarage = cuotaMesGarage;
    }
    
   
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = this.precio * 0.02;
    }
    

    public boolean matricular(String matricula) {
        if (matricula != null && matricula.length() == 7) {
            this.matricula = matricula;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Vehículo: " + marca + ", Matrícula: " + (matricula != null ? matricula : "Sin matricular") +
               ", Precio: " + precio + ", Cuota mensual: " + cuotaMesGarage;
    }
}