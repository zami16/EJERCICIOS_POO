package poo.Garege;

public class Coche extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;
    
    /**
     * Constructor
     * @param marca Marca del coche
     * @param precio Precio del coche
     * @param cilindrada Cilindrada del coche
     * @param tieneRadio Indica si el coche tiene radio
     * @param tieneNavegador Indica si el coche tiene navegador
     */
    public Coche(String marca, double precio, int cilindrada, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindrada);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        
        // Modificaciones específicas para coches
        if (cilindrada > 2999) {
            try {
                // Aumentar cuota en 20% si la cilindrada es mayor de 2999
                setCuotaMesGarage(getCuotaMesGarage() * 1.2);
            } catch (CuotaNegativaException e) {
                // Este caso no debería ocurrir ya que estamos multiplicando por un valor positivo
                System.err.println("Error al ajustar la cuota: " + e.getMessage());
            }
        }
        
        // Recalcular impuesto con los criterios específicos de coche
        calcularImpuestoCirculacion();
    }
    
    public boolean isTieneRadio() {
        return tieneRadio;
    }
    
    public boolean isTieneNavegador() {
        return tieneNavegador;
    }
    
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion(); // Calcula el impuesto base (2% del precio)
        
        double impuestoActual = getImpuestoCirculacion();
        double impuestoAdicional = 0;
        
        // Incrementa en 1% si tiene radio
        if (tieneRadio) {
            impuestoAdicional += getPrecio() * 0.01;
        }
        
        // Incrementa en 2% si tiene navegador
        if (tieneNavegador) {
            impuestoAdicional += getPrecio() * 0.02;
        }
        
        setImpuestoCirculacion(impuestoActual + impuestoAdicional);
    }
    
    private void setImpuestoCirculacion(double impuesto) {
        // Método para uso interno que permite modificar el impuesto desde esta subclase
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
        return "Coche: " + getMarca() + ", Matrícula: " + (getMatricula() != null ? getMatricula() : "Sin matricular") +
               ", Precio: " + getPrecio() + ", Radio: " + (tieneRadio ? "Sí" : "No") + 
               ", Navegador: " + (tieneNavegador ? "Sí" : "No") + ", Cuota mensual: " + getCuotaMesGarage();
    }
}