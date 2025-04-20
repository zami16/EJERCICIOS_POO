package poo.Garege;

import java.io.*;
import java.util.*;

public class Garaje implements iGarage, Serializable {
    private static final int NUM_PLAZAS = 20; 
    private Vehiculo[] plazas;
    
 
    public Garaje() {
        plazas = new Vehiculo[NUM_PLAZAS];
    }
    

    public boolean alquilarPlaza(Vehiculo vehiculo) throws SinMatriculaException {
        // Verificar si el vehículo tiene matrícula
        if (vehiculo.getMatricula() == null) {
            throw new SinMatriculaException("No se puede alquilar un vehículo sin matrícula");
        }
      
        int plazasOcupadas = 0;
        int plazasMotos = 0;
        int plazaLibre = -1;
        
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                plazasOcupadas++;
                if (plazas[i] instanceof Moto) {
                    plazasMotos++;
                }
            } else if (plazaLibre == -1) {
                plazaLibre = i; // Guardamos la primera plaza libre que encontremos
            }
        }
        
        if (plazaLibre == -1) {
            return false;
        }
        
        if (vehiculo instanceof Moto) {
            if ((plazasMotos + 1) > (NUM_PLAZAS * 0.8)) {
                return false;
            }
        }
        plazas[plazaLibre] = vehiculo;
        return true;
    }

    public boolean darBajaAlquiler(String matricula) {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null && plazas[i].getMatricula() != null && 
                plazas[i].getMatricula().equals(matricula)) {
                plazas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public double calcularIngresos() throws VamosALaQuiebraException {
        double totalIngresos = 0;
        
        for (Vehiculo v : plazas) {
            if (v != null) {
                totalIngresos += v.getCuotaMesGarage();
            }
        }
        
        if (totalIngresos < 400) {
            throw new VamosALaQuiebraException("¡Alerta! Los ingresos mensuales son inferiores a 400€");
        }
        
        return totalIngresos;
    }
 
    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        Class<?> tipo = v.getClass();
        
        for (Vehiculo vehiculo : plazas) {
            if (vehiculo != null && vehiculo.getClass() == tipo) {
                contador++;
            }
        }
        
        return contador;
    }
    
 
    public int contarPlazasOcupadas() {
        int contador = 0;
        for (Vehiculo v : plazas) {
            if (v != null) {
                contador++;
            }
        }
        return contador;
    }
 
    public void guardarVehiculosEnFichero(String nombreFichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(plazas);
            System.out.println("Vehículos guardados correctamente en " + nombreFichero);
        } catch (IOException e) {
            System.err.println("Error al guardar vehículos: " + e.getMessage());
        }
    }

    public void recuperarVehiculosDeFichero(String nombreFichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            plazas = (Vehiculo[]) ois.readObject();
            System.out.println("Vehículos recuperados correctamente desde " + nombreFichero);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al recuperar vehículos: " + e.getMessage());
        }
    }

    public Vehiculo[] getPlazas() {
        return plazas;
    }
    
    public List<Vehiculo> listarVehiculosOrdenados() {
        List<Vehiculo> vehiculosOrdenados = new ArrayList<>();
        
        for (Vehiculo v : plazas) {
            if (v != null && v.getMatricula() != null) {
                vehiculosOrdenados.add(v);
            }
        }
        
        Collections.sort(vehiculosOrdenados, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo v1, Vehiculo v2) {
                return v1.getMatricula().compareTo(v2.getMatricula());
            }
        });
        
        return vehiculosOrdenados;
    }
}