package org.example;

public class Empleado {

    // 1. Atributos Privados
    // Requisito: clave de empleado, salario mensual y porcentaje de retención de impuestos.
    private String claveEmpleado;
    private double salarioMensual;
    private double porcentajeRetencionImpuestos; // Representado como decimal (ej: 0.15 para 15%)

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public Empleado(String claveEmpleado, double salarioMensual, double porcentajeRetencionImpuestos) {
        this.claveEmpleado = claveEmpleado;
        this.salarioMensual = Math.max(0, salarioMensual);
        // El porcentaje de retención se valida para estar entre 0.0 y 1.0 (0% a 100%)
        this.porcentajeRetencionImpuestos = Math.min(1.0, Math.max(0.0, porcentajeRetencionImpuestos));
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para claveEmpleado
    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    // Setter para claveEmpleado
    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    // Getter para salarioMensual
    public double getSalarioMensual() {
        return salarioMensual;
    }

    // Setter para salarioMensual
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = Math.max(0, salarioMensual);
    }

    // Getter para porcentajeRetencionImpuestos
    public double getPorcentajeRetencionImpuestos() {
        return porcentajeRetencionImpuestos;
    }

    // Setter para porcentajeRetencionImpuestos
    public void setPorcentajeRetencionImpuestos(double porcentajeRetencionImpuestos) {
        this.porcentajeRetencionImpuestos = Math.min(1.0, Math.max(0.0, porcentajeRetencionImpuestos));
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Calcular Salario Neto
    // Requisito: Un método que calcule el Salario Neto del empleado (Salario Mensual - Impuestos).
    public double calcularSalarioNeto() {
        // Cálculo de Impuestos: Salario Mensual * Porcentaje de Retención
        double montoImpuestos = this.salarioMensual * this.porcentajeRetencionImpuestos;

        // Cálculo de Salario Neto: Salario Mensual - Monto Impuestos
        double salarioNeto = this.salarioMensual - montoImpuestos;

        System.out.printf("💵 Salario Neto para %s (Clave: %s): %.2f%n",
                this.claveEmpleado, this.getClaveEmpleado(), salarioNeto);
        System.out.printf("  (Salario Bruto: %.2f - Impuestos (%.0f%%): %.2f)%n",
                this.salarioMensual, this.porcentajeRetencionImpuestos * 100, montoImpuestos);
        return salarioNeto;
    }

    // Comportamiento 2: Aplicar Aumento de Salario
    // Requisito: Un método que aplique un Aumento de Salario basado en un porcentaje que se recibe como argumento.
    public void aplicarAumentoSalario(double porcentajeAumento) {
        // Validación básica: El aumento debe ser positivo
        if (porcentajeAumento <= 0) {
            System.out.println("⚠️ El porcentaje de aumento debe ser positivo. No se realizó ningún cambio.");
            return;
        }

        // El factor de aumento es 1 + porcentaje (ej: 1 + 0.10 = 1.10)
        double factorAumento = 1 + (porcentajeAumento / 100.0);
        double nuevoSalario = this.salarioMensual * factorAumento;

        System.out.printf("📈 Aumento del %.2f%% aplicado a %s.%n", porcentajeAumento, this.getClaveEmpleado());
        System.out.printf("  Salario anterior: %.2f | Nuevo Salario: %.2f%n", this.salarioMensual, nuevoSalario);

        this.salarioMensual = nuevoSalario;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("Empleado [Clave: %s, Salario Bruto: %.2f, Retención: %.0f%%]",
                claveEmpleado, salarioMensual, porcentajeRetencionImpuestos * 100);
    }
}