package org.example;

public class MainRRHH {
    public static void main(String[] args) {
        // Crear un nuevo empleado (15% de retención)
        Empleado supervisor = new Empleado("E-1001", 3000.00, 0.15);

        System.out.println("--- 👨‍💼 Empleado Inicial ---");
        System.out.println(supervisor);

        // 1. Prueba de Comportamiento 1: Cálculo de Salario Neto
        System.out.println("\n--- Cálculo de Pago ---");
        // Esperado: 3000.00 - (3000.00 * 0.15) = 2550.00
        supervisor.calcularSalarioNeto();

        // 2. Prueba de Comportamiento 2: Aplicar Aumento
        System.out.println("\n--- Aplicación de Aumento ---");
        supervisor.aplicarAumentoSalario(10.0); // Aumento del 10%
        // Salario nuevo esperado: 3000.00 * 1.10 = 3300.00

        // 3. Recálculo después del Aumento
        System.out.println("\n--- Recálculo de Pago con Nuevo Salario ---");
        supervisor.calcularSalarioNeto();
        // Esperado: 3300.00 - (3300.00 * 0.15) = 2805.00

        // 4. Uso de Setters para cambiar el porcentaje de retención
        System.out.println("\n--- Ajuste de Retención ---");
        supervisor.setPorcentajeRetencionImpuestos(0.20); // 20%
        System.out.println("Nuevo porcentaje de retención: " + supervisor.getPorcentajeRetencionImpuestos() * 100 + "%");

        // 5. Cálculo Final
        supervisor.calcularSalarioNeto();
        // Esperado: 3300.00 - (3300.00 * 0.20) = 2640.00
    }
}