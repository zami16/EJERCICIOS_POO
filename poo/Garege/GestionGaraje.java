package poo.Garege;

import java.util.List;
import java.util.Scanner;

public class GestionGaraje {
    private static Garaje garaje = new Garaje();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            try {
                switch (opcion) {
                    case 1:
                        alquilarPlaza();
                        break;
                    case 2:
                        darBajaAlquiler();
                        break;
                    case 3:
                        consultarIngresos();
                        break;
                    case 4:
                        consultarProporcion();
                        break;
                    case 5:
                        listarVehiculos();
                        break;
                    case 6:
                        guardarVehiculos();
                        break;
                    case 7:
                        recuperarVehiculos();
                        break;
                    case 0:
                        salir = true;
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            
            if (!salir) {
                System.out.println("\nPulse Enter para continuar...");
                scanner.nextLine();
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE GARAJE =====");
        System.out.println("1.- Alquilar una plaza");
        System.out.println("2.- Baja de alquiler");
        System.out.println("3.- Consulta de ingresos mensuales");
        System.out.println("4.- Consulta proporción coches / motos");
        System.out.println("5.- Listado de matrículas, cuota mensual y tipo vehículo");
        System.out.println("6.- Guardar vehículos en fichero");
        System.out.println("7.- Recuperar vehículos de fichero");
        System.out.println("0.- Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void alquilarPlaza() {
        System.out.println("\n--- ALQUILAR PLAZA ---");
        System.out.println("Tipo de vehículo (1: Coche, 2: Moto): ");
        int tipo = leerOpcion();
        
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Cilindrada: ");
        int cilindrada = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Matrícula (7 caracteres): ");
        String matricula = scanner.nextLine();
        
        Vehiculo vehiculo = null;
        
        if (tipo == 1) { 
            System.out.print("¿Tiene radio? (S/N): ");
            boolean tieneRadio = scanner.nextLine().equalsIgnoreCase("S");
            
            System.out.print("¿Tiene navegador? (S/N): ");
            boolean tieneNavegador = scanner.nextLine().equalsIgnoreCase("S");
            
            vehiculo = new Coche(marca, precio, cilindrada, tieneRadio, tieneNavegador);
        } else { 
            System.out.print("¿Tiene sidecar? (S/N): ");
            boolean tieneSidecar = scanner.nextLine().equalsIgnoreCase("S");
            
            vehiculo = new Moto(marca, precio, cilindrada, tieneSidecar);
        }
  
        if (!vehiculo.matricular(matricula)) {
            System.out.println("Error: La matrícula debe tener exactamente 7 caracteres.");
            return;
        }
        
        try {
            if (garaje.alquilarPlaza(vehiculo)) {
                System.out.println("Plaza alquilada correctamente.");
            } else {
                System.out.println("No se pudo alquilar la plaza. Verifique disponibilidad o restricciones.");
            }
        } catch (SinMatriculaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    private static void darBajaAlquiler() {
        System.out.println("\n--- BAJA DE ALQUILER ---");
        System.out.print("Introduzca la matrícula del vehículo a dar de baja: ");
        String matricula = scanner.nextLine();
        
        if (garaje.darBajaAlquiler(matricula)) {
            System.out.println("Vehículo con matrícula " + matricula + " dado de baja correctamente.");
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula indicada.");
        }
    }
    
    private static void consultarIngresos() {
        System.out.println("\n--- CONSULTA DE INGRESOS MENSUALES ---");
        try {
            double ingresos = garaje.calcularIngresos();
            System.out.println("Los ingresos mensuales totales son: " + ingresos + " euros");
        } catch (VamosALaQuiebraException e) {
            System.out.println("ALERTA: " + e.getMessage());
            System.out.println("Se recomienda aumentar el número de vehículos o revisar las tarifas.");
        }
    }
    
    private static void consultarProporcion() {
        System.out.println("\n--- CONSULTA PROPORCIÓN COCHES / MOTOS ---");
        int totalVehiculos = garaje.contarPlazasOcupadas();
        
        if (totalVehiculos == 0) {
            System.out.println("No hay vehículos en el garaje.");
            return;
        }
        
        int numCoches = garaje.calcularOcupacionPorTipoVehiculo(new Coche("", 0, 0, false, false));
        int numMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
        
        System.out.println("Total de vehículos: " + totalVehiculos);
        System.out.println("Coches: " + numCoches + " (" + (numCoches * 100.0 / totalVehiculos) + "%)");
        System.out.println("Motos: " + numMotos + " (" + (numMotos * 100.0 / totalVehiculos) + "%)");
    }
 
    private static void listarVehiculos() {
        System.out.println("\n--- LISTADO DE VEHÍCULOS ORDENADOS POR MATRÍCULA ---");
        List<Vehiculo> vehiculosOrdenados = garaje.listarVehiculosOrdenados();
        
        if (vehiculosOrdenados.isEmpty()) {
            System.out.println("No hay vehículos matriculados en el garaje.");
            return;
        }
        
        System.out.println("Matrícula  | Tipo    | Marca      | Cuota Mensual");
        System.out.println("-------------------------------------------------");
        
        for (Vehiculo v : vehiculosOrdenados) {
            String tipo = v instanceof Coche ? "Coche" : "Moto";
            System.out.printf("%-10s | %-7s | %-10s | %.2f€\n", 
                    v.getMatricula(), tipo, v.getMarca(), v.getCuotaMesGarage());
        }
    }

    private static void guardarVehiculos() {
        System.out.println("\n--- GUARDAR VEHÍCULOS EN FICHERO ---");
        System.out.print("Introduzca el nombre del fichero: ");
        String nombreFichero = scanner.nextLine();
        
        garaje.guardarVehiculosEnFichero(nombreFichero);
    }
    
    private static void recuperarVehiculos() {
        System.out.println("\n--- RECUPERAR VEHÍCULOS DE FICHERO ---");
        System.out.print("Introduzca el nombre del fichero: ");
        String nombreFichero = scanner.nextLine();
        
        garaje.recuperarVehiculosDeFichero(nombreFichero);
    }
}