package org.example;

public class MainInventario {
    public static void main(String[] args) {
        // Crear un nuevo producto en el almacén
        Producto monitorGamer = new Producto("MG-4K-27", 50, 450.99);

        System.out.println("--- 🖥️ Producto Inicial: Monitor Gamer ---");
        System.out.println(monitorGamer); // Stock: 50, Precio: 450.99

        // 1. Prueba de Comportamiento 2: Cálculo de Valor Total Inicial
        System.out.println("\n--- Cálculo Inicial ---");
        monitorGamer.calcularValorTotalStock();
        // Esperado: 50 * 450.99 = 22549.50


        // 2. Prueba de Comportamiento 1: Incrementar el Stock
        System.out.println("\n--- Entrada de Mercancía ---");
        int entradaNueva = 15;
        monitorGamer.incrementarStock(entradaNueva); // Stock aumenta a 65

        // 3. Uso de Setters para cambiar el precio
        System.out.println("\n--- Actualización de Precio ---");
        monitorGamer.setPrecioUnitarioVenta(480.00);
        System.out.println("Nuevo precio unitario: " + monitorGamer.getPrecioUnitarioVenta());


        // 4. Prueba de Comportamiento 2: Recalcular el Valor Total
        System.out.println("\n--- Recálculo Final ---");
        monitorGamer.calcularValorTotalStock();
        // Esperado: 65 * 480.00 = 31200.00

        // 5. Prueba de Getters
        System.out.println("\nReferencia del producto: " + monitorGamer.getReferenciaAlmacen());
    }
}