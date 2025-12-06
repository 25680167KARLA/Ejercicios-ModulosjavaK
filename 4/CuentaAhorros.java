package org.example;

public class CuentaAhorros {

    // 1. Atributos Privados
    // Requisito: número de cuenta, nombre del titular y saldo actual.
    private String numeroCuenta;
    private String nombreTitular;
    private double saldo;

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public CuentaAhorros(String numeroCuenta, String nombreTitular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        // El saldo inicial no debe ser negativo
        this.saldo = Math.max(0, saldoInicial);
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para numeroCuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // Setter para numeroCuenta
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // Getter para nombreTitular
    public String getNombreTitular() {
        return nombreTitular;
    }

    // Setter para nombreTitular
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    // Getter para saldo
    public double getSaldo() {
        return saldo;
    }

    // Nota: Generalmente no se incluye un Setter para el saldo en sistemas reales.
    // El saldo se actualiza solo a través de los métodos de Depósito y Retiro (Comportamiento).

    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Realizar un Depósito
    // Requisito: Un método para realizar un Depósito, recibiendo la cantidad y actualizando el saldo.
    public boolean realizarDeposito(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.printf("✅ Depósito exitoso de %.2f en cuenta %s. Nuevo saldo: %.2f%n",
                    cantidad, this.numeroCuenta, this.saldo);
            return true;
        } else {
            System.out.println("❌ Error: La cantidad a depositar debe ser positiva.");
            return false;
        }
    }

    // Comportamiento 2: Simular un Retiro
    // Requisito: Un método para simular un Retiro. Debe recibir la cantidad y actualizar el saldo,
    // pero solo si la cantidad a retirar no excede el saldo actual.
    public boolean simularRetiro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌ Error: La cantidad a retirar debe ser positiva.");
            return false;
        }

        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
            System.out.printf("✅ Retiro exitoso de %.2f en cuenta %s. Saldo restante: %.2f%n",
                    cantidad, this.numeroCuenta, this.saldo);
            return true;
        } else {
            System.out.printf("⛔ Transacción fallida. Saldo insuficiente (%.2f). Intento de retiro: %.2f%n",
                    this.saldo, cantidad);
            return false;
        }
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("CuentaAhorros [Número: %s, Titular: %s, Saldo: %.2f]",
                numeroCuenta, nombreTitular, saldo);
    }
}