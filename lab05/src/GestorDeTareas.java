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


public void agregarTarea(T tarea) {
    Node<T> nuevoNodo = new Node<>(tarea); // Primero creamos un nuevo nodo que guarde la tarea

 if (head == null) {
    // Si la lista estaba vacía , este nodo será el primero
    head = nuevoNodo;
    } else {
        // Si ya hay tareas -> recorremos hasta encontrar el ultimo nodo
        Node<T> actual = head;
        while (actual.next != null) {
        actual = actual.next; // Seguimos avanzando hasta el ultimo nodo
        }
        // Cuando encontramos el último, conectamos su "next" al nuevo nodo
        actual.next = nuevoNodo;
    }

}
