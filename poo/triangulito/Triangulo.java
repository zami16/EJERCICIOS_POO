package poo.triangulito;

public class Triangulo {
    private int base;
    private int altura;

    // Constructor
    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    // Métodos para dar valor (setters)
    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Métodos para consultar (getters)
    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    // Método para calcular el área
    public double calcularArea() {
        return (base * altura) / 2.0;
    }

    // Método toString para representación del objeto
    @Override
    public String toString() {
        return "Triángulo [base=" + base + ", altura=" + altura + "]";
    }
}