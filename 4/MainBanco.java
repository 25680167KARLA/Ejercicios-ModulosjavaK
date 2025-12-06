package org.example;

public class MainBanco {
    public static void main(String[] args) {
        // Crear una nueva cuenta con saldo inicial
        CuentaAhorros cuenta1 = new CuentaAhorros("C-12345", "Ana Torres", 500.75);

        System.out.println("--- 👤 Cuenta Inicial ---");
        System.out.println(cuenta1);
        System.out.println("Saldo actual: " + cuenta1.getSaldo());

        // 1. Prueba de Comportamiento 1: Depósito
        System.out.println("\n--- Operación de Depósito ---");
        cuenta1.realizarDeposito(250.00); // Depósito exitoso
        cuenta1.realizarDeposito(-10.00); // Depósito fallido por cantidad negativa

        // 2. Prueba de Comportamiento 2: Retiro
        System.out.println("\n--- Operación de Retiro ---");
        cuenta1.simularRetiro(100.00); // Retiro exitoso

        // 3. Intento de Retiro Excediendo el Saldo
        System.out.println("\n--- Intento de Sobregiro ---");
        // El saldo actual debe ser: 500.75 + 250.00 - 100.00 = 650.75
        cuenta1.simularRetiro(700.00); // Retiro fallido por saldo insuficiente

        // 4. Saldo Final
        System.out.println("\n--- Estado Final de la Cuenta ---");
        System.out.println(cuenta1);
    }
}