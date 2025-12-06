package org.example;

public class TareaPendiente {

    // Enumeración para la prioridad de la tarea
    public enum Prioridad {
        BAJA, MEDIA, ALTA
    }

    // 1. Atributos Privados
    // Requisito: descripción, prioridad asignada, y un indicador si la tarea ha sido completada.
    private String descripcion;
    private Prioridad prioridad;
    private boolean completada; // true: completada, false: pendiente

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public TareaPendiente(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; // Por defecto, una tarea nueva está pendiente
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter para descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter para prioridad
    public Prioridad getPrioridad() {
        return prioridad;
    }

    // Setter para prioridad
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    // Getter para completada (usamos 'is' para booleanos)
    public boolean isCompletada() {
        return completada;
    }

    // Setter para completada (aunque se prefiere usar el método de comportamiento 1)
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Cambiar el estado a Completada
    // Requisito: Un método que cambie el estado de la tarea a Completada.
    public void marcarComoCompletada() {
        if (!this.completada) {
            this.completada = true;
            System.out.println("🎉 Tarea marcada como Completada: " + this.descripcion);
        } else {
            System.out.println("La tarea ya estaba completada: " + this.descripcion);
        }
    }

    // Comportamiento 2: Determinar si la tarea es Urgente
    // Requisito: Un método que determine si la tarea es Urgente (combinando la prioridad 'Alta' y si aún no está completada).
    public boolean esUrgente() {
        // Lógica de Urgencia:
        // 1. La prioridad debe ser ALTA
        // 2. La tarea NO debe estar completada
        boolean esUrgente = (this.prioridad == Prioridad.ALTA) && !this.completada;

        if (esUrgente) {
            System.out.println("🚨 ¡ATENCIÓN! La tarea es URGENTE.");
        } else {
            System.out.println("Relativo: La tarea NO es urgente o ya fue completada.");
        }
        return esUrgente;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        String estado = this.completada ? "COMPLETADA" : "PENDIENTE";
        return String.format("Tarea [Descripción: %s, Prioridad: %s, Estado: %s]",
                descripcion, prioridad.toString(), estado);
    }
}