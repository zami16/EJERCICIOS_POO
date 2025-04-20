package poo.empleados;

import java.util.Scanner;

public class MainEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[4];

        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Ingrese el nombre del empleado " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el teléfono del empleado " + (i + 1) + ":");
            String telefono = scanner.nextLine();

            empleados[i] = new Empleado(nombre, telefono);
        }

        System.out.println("\nDatos de los empleados:");
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Empleado " + (i + 1) + ": Nombre = " + empleados[i].getNombre() +
                               ", Teléfono = " + empleados[i].getTelefono());
        }

        System.out.println("\nNúmero total de empleados instanciados: " + Empleado.getNumeroEmpleados());
        scanner.close();
    }
}
