package poo.Garege;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindrada, boolean tieneSidecar) {
        super(marca, precio, cilindrada);
        this.tieneSidecar = tieneSidecar;

        if (tieneSidecar) {
            try {
  
                setCuotaMesGarage(getCuotaMesGarage() * 1.5);
            } catch (CuotaNegativaException e) {
               
                System.err.println("Error al ajustar la cuota: " + e.getMessage());
            }
        }
        calcularImpuestoCirculacion();
    }
    
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
    
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion(); // Calcula el impuesto base (2% del precio)

        if (tieneSidecar) {

            this.setImpuestoCirculacion(getImpuestoCirculacion() * 1.1);
        }
    }
    
    private void setImpuestoCirculacion(double impuesto) {

        try {
            java.lang.reflect.Field field = Vehiculo.class.getDeclaredField("impuestoCirculacion");
            field.setAccessible(true);
            field.set(this, impuesto);
        } catch (Exception e) {
            System.err.println("Error al ajustar el impuesto: " + e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return "Moto: " + getMarca() + ", Matrícula: " + (getMatricula() != null ? getMatricula() : "Sin matricular") +
               ", Precio: " + getPrecio() + ", Sidecar: " + (tieneSidecar ? "Sí" : "No") + 
               ", Cuota mensual: " + getCuotaMesGarage();
    }
}