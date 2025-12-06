package org.example;

public class Producto {

    // 1. Atributos Privados
    // Requisito: referencia de almacén, cantidad actual en stock, precio unitario de venta.
    private String referenciaAlmacen;
    private int cantidadStock;
    private double precioUnitarioVenta;

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public Producto(String referenciaAlmacen, int cantidadStockInicial, double precioUnitarioVenta) {
        this.referenciaAlmacen = referenciaAlmacen;
        // Aseguramos que la cantidad inicial no sea negativa
        this.cantidadStock = Math.max(0, cantidadStockInicial);
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para referenciaAlmacen
    public String getReferenciaAlmacen() {
        return referenciaAlmacen;
    }

    // Setter para referenciaAlmacen
    public void setReferenciaAlmacen(String referenciaAlmacen) {
        this.referenciaAlmacen = referenciaAlmacen;
    }

    // Getter para cantidadStock
    public int getCantidadStock() {
        return cantidadStock;
    }

    // Setter para cantidadStock (usado para ajustes directos, aunque se prefiere el método de comportamiento)
    public void setCantidadStock(int cantidadStock) {
        // Validación básica
        this.cantidadStock = Math.max(0, cantidadStock);
    }

    // Getter para precioUnitarioVenta
    public double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    // Setter para precioUnitarioVenta
    public void setPrecioUnitarioVenta(double precioUnitarioVenta) {
        // Validación básica
        this.precioUnitarioVenta = Math.max(0, precioUnitarioVenta);
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Incrementar stock
    // Requisito: Un método para incrementar la cantidad en stock después de una entrada de mercancía,
    // recibiendo la cantidad de la entrada como argumento.
    public void incrementarStock(int cantidadEntrada) {
        if (cantidadEntrada > 0) {
            this.cantidadStock += cantidadEntrada;
            System.out.println("📦 Entrada registrada. Stock actual de " + referenciaAlmacen + ": " + this.cantidadStock);
        } else {
            System.out.println("⚠️ La cantidad de entrada debe ser positiva. No se realizó ningún cambio.");
        }
    }

    // Comportamiento 2: Calcular el Valor Total
    // Requisito: Un método que calcule el Valor Total del stock de ese producto (cantidad * precio unitario).
    public double calcularValorTotalStock() {
        // Cálculo: cantidadStock * precioUnitarioVenta
        double valorTotal = this.cantidadStock * this.precioUnitarioVenta;
        System.out.printf("💰 Valor total del stock para %s: %.2f (Cantidad: %d * Precio: %.2f)%n",
                this.referenciaAlmacen, valorTotal, this.cantidadStock, this.precioUnitarioVenta);
        return valorTotal;
    }

    // Método adicional para mostrar información (opcional, pero útil para la depuración)
    @Override
    public String toString() {
        return "Producto [Referencia=" + referenciaAlmacen + ", Stock=" + cantidadStock + ", Precio=" + precioUnitarioVenta + "]";
    }
}