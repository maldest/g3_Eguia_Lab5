import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T> {
    private Node<T> head;             // Este es el primer nodo de nuestra lista enlazada de tareas
    private List<T> tareasCompletadas = new ArrayList<>();
    
 // Esta lista normal de Java va a guardar las tareas que ya se terminaron

    // Este es el constructor ->  cuando creamos el gestor, no hay tareas aún
    public GestorDeTareas() {
        head = null; // La lista enlazada empieza vacía
        tareasCompletadas = new ArrayList<>(); // Creamos una lista vacía para las tareas completadas
    
}

}
