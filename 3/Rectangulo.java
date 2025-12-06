package org.example;

public class Rectangulo {

    // 1. Atributos Privados
    // Requisito: longitudes de su base y altura, y una etiqueta de identificación.
    private double base;
    private double altura;
    private String etiquetaID; // Etiqueta para identificar la figura (e.g., "R-001")

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public Rectangulo(double base, double altura, String etiquetaID) {
        // Aseguramos que las dimensiones sean positivas
        this.base = Math.max(0, base);
        this.altura = Math.max(0, altura);
        this.etiquetaID = etiquetaID;
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para base
    public double getBase() {
        return base;
    }

    // Setter para base
    public void setBase(double base) {
        this.base = Math.max(0, base);
    }

    // Getter para altura
    public double getAltura() {
        return altura;
    }

    // Setter para altura
    public void setAltura(double altura) {
        this.altura = Math.max(0, altura);
    }

    // Getter para etiquetaID
    public String getEtiquetaID() {
        return etiquetaID;
    }

    // Setter para etiquetaID
    public void setEtiquetaID(String etiquetaID) {
        this.etiquetaID = etiquetaID;
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Calcular el Área
    // Requisito: Un método que calcule el Área total de la figura.
    public double calcularArea() {
        // Fórmula del Área: Area = base * altura
        double area = this.base * this.altura;
        System.out.printf("📏 El Área del rectángulo %s (Base: %.2f, Altura: %.2f) es: %.2f%n",
                this.etiquetaID, this.base, this.altura, area);
        return area;
    }

    // Comportamiento 2: Calcular el Perímetro
    // Requisito: Un método que determine y retorne el Perímetro de la figura.
    public double calcularPerimetro() {
        // Fórmula del Perímetro: Perimetro = 2 * (base + altura)
        double perimetro = 2 * (this.base + this.altura);
        System.out.printf("➰ El Perímetro del rectángulo %s es: %.2f%n",
                this.etiquetaID, perimetro);
        return perimetro;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return "Rectángulo [ID=" + etiquetaID + ", Base=" + base + ", Altura=" + altura + "]";
    }
}