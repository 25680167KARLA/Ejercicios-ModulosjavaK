package org.example;

public class MainGeometria {
    public static void main(String[] args) {
        // 1. Crear un rectángulo mediano
        Rectangulo rectanguloMediano = new Rectangulo(10.5, 5.0, "R-MED-01");

        System.out.println("--- 🟦 Rectángulo Mediano (R-MED-01) ---");
        System.out.println(rectanguloMediano);

        // Prueba de Comportamiento 1: Calcular Área
        rectanguloMediano.calcularArea();
        // Esperado: 10.5 * 5.0 = 52.5

        // Prueba de Comportamiento 2: Calcular Perímetro
        rectanguloMediano.calcularPerimetro();
        // Esperado: 2 * (10.5 + 5.0) = 31.0

        // 2. Crear un rectángulo grande
        Rectangulo rectanguloGrande = new Rectangulo(25.0, 15.0, "R-GRN-02");

        System.out.println("\n--- 🟥 Rectángulo Grande (R-GRN-02) ---");
        System.out.println(rectanguloGrande);

        // Prueba de Comportamiento 1 y 2
        rectanguloGrande.calcularArea();
        rectanguloGrande.calcularPerimetro();

        // Demostración de Setters
        System.out.println("\n--- Ajuste de Dimensiones (R-GRN-02) ---");
        rectanguloGrande.setBase(30.0);
        System.out.println("Nueva Base: " + rectanguloGrande.getBase());
        rectanguloGrande.calcularArea(); // El área se recalcula con la nueva base
        // Esperado: 30.0 * 15.0 = 450.0
    }
}