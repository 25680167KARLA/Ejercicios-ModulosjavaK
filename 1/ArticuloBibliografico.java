package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ArticuloBibliografico {

    // 1. Atributos Privados
    // Requisito: Al menos tres atributos.
    private String identificadorUnico;
    private String nombreAutor;
    private boolean estadoPrestamo; // true: prestado, false: disponible
    private LocalDate fechaPublicacion; // Atributo adicional para el cálculo de antigüedad

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public ArticuloBibliografico(String identificadorUnico, String nombreAutor, LocalDate fechaPublicacion) {
        this.identificadorUnico = identificadorUnico;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPrestamo = false; // Por defecto, un artículo nuevo está disponible
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para identificadorUnico
    public String getIdentificadorUnico() {
        return identificadorUnico;
    }

    // Setter para identificadorUnico
    public void setIdentificadorUnico(String identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }

    // Getter para nombreAutor
    public String getNombreAutor() {
        return nombreAutor;
    }

    // Setter para nombreAutor
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    // Getter para estadoPrestamo
    public boolean isEstadoPrestamo() {
        return estadoPrestamo;
    }

    // Setter para estadoPrestamo (usado internamente o para correcciones)
    public void setEstadoPrestamo(boolean estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    // Getter para fechaPublicacion
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    // Setter para fechaPublicacion
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Simula la reserva/préstamo
    // Requisito: Un método que simule la reserva del libro. Debe cambiar el estado de préstamo.
    public boolean simularReserva() {
        if (!this.estadoPrestamo) { // Si el estado es "disponible" (false)
            this.estadoPrestamo = true; // Cambia a "prestado" (true)
            System.out.println("✅ Artículo con ID " + identificadorUnico + " reservado con éxito. Estado: Prestado.");
            return true;
        } else {
            System.out.println("❌ Artículo con ID " + identificadorUnico + " ya está prestado.");
            return false;
        }
    }

    // Comportamiento 2: Determina la aptitud para préstamo
    // Requisito: Un método que determine si el artículo es apto para préstamo basándose en una variable de antigüedad
    // (si se publicó hace más de 5 años).
    public boolean esAptoParaPrestamo() {
        // Obtenemos la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calculamos la diferencia en años entre la fecha actual y la fecha de publicación
        long anosDesdePublicacion = ChronoUnit.YEARS.between(this.fechaPublicacion, fechaActual);

        // El artículo es apto para préstamo si *NO* se publicó hace más de 5 años.
        // Ojo: Interpretaremos "más de 5 años" como estricto (> 5 años).
        boolean esApto = anosDesdePublicacion <= 5;

        if (esApto) {
            System.out.println("✨ Artículo apto para préstamo. Antigüedad: " + anosDesdePublicacion + " años.");
        } else {
            System.out.println("⛔ Artículo NO apto para préstamo. Publicado hace " + anosDesdePublicacion + " años (más de 5).");
        }
        return esApto;
    }
}