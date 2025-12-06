package org.example;

public class MainTareas {
    public static void main(String[] args) {
        // 1. Tarea Urgente (Prioridad ALTA y Pendiente)
        TareaPendiente tareaUrgente = new TareaPendiente("Preparar informe financiero", TareaPendiente.Prioridad.ALTA);

        // 2. Tarea No Urgente (Prioridad BAJA y Pendiente)
        TareaPendiente tareaNormal = new TareaPendiente("Revisar correos antiguos", TareaPendiente.Prioridad.BAJA);

        System.out.println("--- 🔴 Tarea Urgente ---");
        System.out.println(tareaUrgente);

        // Prueba de Comportamiento 2: Urgencia (Debe ser TRUE)
        tareaUrgente.esUrgente();

        // Prueba de Comportamiento 1: Marcar como Completada
        System.out.println("\n--- Completando Tarea Urgente ---");
        tareaUrgente.marcarComoCompletada();

        // Prueba de Comportamiento 2: Urgencia después de completar (Debe ser FALSE)
        System.out.println("\n--- Re-verificación de Urgencia ---");
        tareaUrgente.esUrgente();


        System.out.println("\n--- 🟢 Tarea Normal ---");
        System.out.println(tareaNormal);

        // Prueba de Comportamiento 2: Urgencia (Debe ser FALSE porque la prioridad es BAJA)
        tareaNormal.esUrgente();

        // Uso de Setter para cambiar la prioridad
        System.out.println("\n--- Cambiando Prioridad a ALTA ---");
        tareaNormal.setPrioridad(TareaPendiente.Prioridad.ALTA);
        System.out.println("Nueva Prioridad: " + tareaNormal.getPrioridad());

        // Re-verificación de Urgencia (Debe ser TRUE ahora)
        tareaNormal.esUrgente();
    }
}