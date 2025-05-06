public class Main {
    // 1. Crear una instancia del gestor de tareas
    GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

    // 2. Agregar tareas
    gestor.agregarTarea(new Tarea("Entregar proyecto", 2));
    gestor.agregarTarea(new Tarea("Estudiar para el examen", 1));
    gestor.agregarTarea(new Tarea("Ir al gimnasio", 5));
    gestor.agregarTarea(new Tarea("Preparar almuerzo", 3));

    // 3. Eliminar alguna tarea
    gestor.eliminarTarea(new Tarea("Ir al gimnasio", 5)); // (Necesitariamos definir equals en Tarea para que funcione perfecto, te explico luego si quieres)

    // 4. Imprimir todas las tareas actuales
    gestor.imprimirTareas();

    // 5. Verificar si cierta tarea existe
    boolean existe = gestor.contieneTarea(new Tarea("Entregar proyecto", 2));
    System.out.println("¿Existe la tarea 'Entregar proyecto'? " + existe);

    // 6. Invertir la lista
    gestor.invertirTareas();
    gestor.imprimirTareas(); // Mostrar como quedó invertida

    // 7. Transferir una tarea a la lista de tareas completadas
    gestor.completarTarea(new Tarea("Estudiar para el examen", 1));

    // 8. Mostrar ambas listas
    System.out.println("\nTareas Pendientes:");
    gestor.imprimirTareas();

    System.out.println("\nTareas Completadas:");
    for (Tarea tarea : gestor.getTareasCompletadas()) {
        System.out.println("- " + tarea);
    }
}
}
