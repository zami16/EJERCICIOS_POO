package poo.triangulito;

public class Prueba {
    public static void main(String[] args) {
        // Creación de varios objetos Triangulo
        Triangulo triangulo1 = new Triangulo(10, 8);
        Triangulo triangulo2 = new Triangulo(5, 4);
        Triangulo triangulo3 = new Triangulo(7, 6);

        // Consulta de atributos
        System.out.println("=== Valores iniciales ===");
        System.out.println("Triángulo 1: " + triangulo1);
        System.out.println("Triángulo 2 - Base: " + triangulo2.getBase() + ", Altura: " + triangulo2.getAltura());
        System.out.println("Triángulo 3 - Área: " + triangulo3.calcularArea());

        // Cambio de valores
        triangulo1.setBase(12);
        triangulo1.setAltura(9);

        triangulo2.setBase(6);
        triangulo2.setAltura(5);

        // Prueba de métodos con nuevos valores
        System.out.println("\n=== Después de modificar valores ===");
        System.out.println("Triángulo 1: " + triangulo1);
        System.out.println("Triángulo 1 - Área: " + triangulo1.calcularArea());
        System.out.println("Triángulo 2: " + triangulo2);
        System.out.println("Triángulo 2 - Área: " + triangulo2.calcularArea());
        System.out.println("Triángulo 3: " + triangulo3);
        System.out.println("Triángulo 3 - Área: " + triangulo3.calcularArea());

        // Creación de un triángulo más grande
        Triangulo trianguloGrande = new Triangulo(20, 15);
        System.out.println("\nTriángulo Grande:");
        System.out.println("Base: " + trianguloGrande.getBase());
        System.out.println("Altura: " + trianguloGrande.getAltura());
        System.out.println("Área: " + trianguloGrande.calcularArea());
    }
}