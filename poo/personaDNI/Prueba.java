package poo.personaDNI;

public class Prueba {
    public static void main(String[] args) {
        // Crear personas
        Persona persona1 = new Persona("Juan", 25, "12345678A");
        Persona persona2 = new Persona("María", 17, "87654321B");
        Persona persona3 = new Persona("Pedro", 70, null);

        // Mostrar información inicial
        System.out.println("=== Personas creadas ===");
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);

        // Probar métodos con edad de mayoría = 18 y jubilación = 65
        final int EDAD_MAYORIA = 18;
        final int EDAD_JUBILACION = 65;

        System.out.println("\n=== Comprobando mayorías de edad ===");
        persona1.esMayorDeEdad(EDAD_MAYORIA);
        persona2.esMayorDeEdad(EDAD_MAYORIA);
        persona3.esMayorDeEdad(EDAD_MAYORIA);

        System.out.println("\n=== Años desde mayoría de edad ===");
        System.out.println(persona1.getNombre() + ": " + persona1.cuantoHaceMayorEdad(EDAD_MAYORIA) + " años");
        System.out.println(persona2.getNombre() + ": " + persona2.cuantoHaceMayorEdad(EDAD_MAYORIA) + " años");
        System.out.println(persona3.getNombre() + ": " + persona3.cuantoHaceMayorEdad(EDAD_MAYORIA) + " años");

        System.out.println("\n=== Comprobando jubilación ===");
        System.out.println(persona1.getNombre() + " jubilado: " + persona1.estaJubilado(EDAD_JUBILACION));
        System.out.println(persona2.getNombre() + " jubilado: " + persona2.estaJubilado(EDAD_JUBILACION));
        System.out.println(persona3.getNombre() + " jubilado: " + persona3.estaJubilado(EDAD_JUBILACION));

        // Probar asignación de DNI
        System.out.println("\n=== Asignando DNI ===");
        System.out.println("Asignar DNI corto a " + persona1.getNombre() + ": " + persona1.asignarDNI("1234"));
        System.out.println("Asignar DNI válido a " + persona3.getNombre() + ": " + persona3.asignarDNI("98765432C"));

        // Modificar atributos
        System.out.println("\n=== Modificando atributos ===");
        persona1.setEdad(30);
        persona2.setNombre("María José");
        System.out.println("Persona1 modificada: " + persona1);
        System.out.println("Persona2 modificada: " + persona2);

        // Probar con diferentes edades de jubilación
        System.out.println("\n=== Probando diferentes edades de jubilación ===");
        System.out.println(persona1.getNombre() + " jubilado a 60: " + persona1.estaJubilado(60));
        System.out.println(persona1.getNombre() + " jubilado a 65: " + persona1.estaJubilado(65));
        System.out.println(persona1.getNombre() + " jubilado a 70: " + persona1.estaJubilado(70));

        // Probar con diferentes edades de mayoría
        System.out.println("\n=== Probando diferentes edades de mayoría ===");
        System.out.println(persona2.getNombre() + " años desde mayoría (21): " + persona2.cuantoHaceMayorEdad(21));
        System.out.println(persona2.getNombre() + " años desde mayoría (16): " + persona2.cuantoHaceMayorEdad(16));
    }
}