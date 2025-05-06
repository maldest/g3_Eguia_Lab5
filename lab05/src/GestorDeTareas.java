import java.util.ArrayList;
import java.util.List;


// Esta clase será nuestro clase generico
// Va a trabajar tanto con nodos (Node<T>) como con listas normales (List<T>)
public class GestorDeTareas<T> {
    private Node<T> head;             // Este es el primer nodo de nuestra lista enlazada de tareas
    private List<T> tareasCompletadas = new ArrayList<>();

 // Esta lista normal de Java va a guardar las tareas que ya se terminaron

    // Este es el constructor ->  cuando creamos el gestor, no hay tareas aún
    public GestorDeTareas() {
        head = null; // La lista enlazada empieza vacía
        tareasCompletadas = new ArrayList<>(); // Creamos una lista vacía para las tareas completadas
    
}

    // Este metodo  agrega una nueva tarea al final de nuestra lista enlazada
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

    // Este metodo elimina una tarea específica de nuestra lista enlazada
    // Si logra eliminar la tarea, devuelve true
    // Si no la encuentra  devuelve false
    public boolean eliminarTarea(T tarea) {
        if (head == null) {
            // Si la lista está vacía -> no hay nada que eliminar
            return false;
        }

        // Si la tarea a eliminar es la primera de la lista
        if (head.data.equals(tarea)) {
            head = head.next; // Movemos la cabeza al siguiente nodo
            return true;
        }

        // Si la tarea no está en la primera posición buscamos mas adelante
        Node<T> actual = head;
        while (actual.next != null) {
            if (actual.next.data.equals(tarea)) {
                // Cuando encontramos la tarea saltamos el nodo que queremos eliminar
                actual.next = actual.next.next;
                return true;
            }
            actual = actual.next; // Seguimos buscando en la lista
         }

        // Si llegamos hasta aquí  es porque no encontramos la tarea
        return false;
    }
    // Este metodo revisa si una tarea específica existe en la lista
    // Si la encuentra -> devuelve true
    //Si no esta -> devuelve false.
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head; // Empezamos desde el primer nodo (head)

        while (actual != null) {
            if (actual.data.equals(tarea)) {
                // Si encontramos el dato  decimos que sí existe
             return true;
            }
            actual = actual.next; // Si no seguimos avanzando al siguiente nodo
        }

        // Si terminamos de recorrer y no encontramos la tarea
        return false;
    }
    // Este metodo imprime todas las tareas que tenemos en la lista enlazada
    public void imprimirTareas() {
        if (head == null) {
            // Si la lista esta vacia, mostramos un mensajito 
            System.out.println("No hay tareas pendientes ¡Todo está hecho siu !");
            return;
        }

        // Si si hay tareas-> las recorremos una por una
        Node<T> actual = head;
        System.out.println("Lista de tareas pendientes:");
        while (actual != null) {
            System.out.println("- " + actual.data); // Mostramos el dato de cada nodo
            actual = actual.next; // Seguimos al siguiente nodo
        }
    }

    // Este metodo cuenta cuantas tareas tenemos en la lista enlazada
    public int contarTareas() {
        int contador = 0; // Empezamos en 0 ya que todavia no hemos contado nada
        Node<T> actual = head; // Empezamos desde el primer nodo (head) cabeaza

        while (actual != null) {
            contador++;         // Cada vez que encontramos un nodo, sumamos 1
            actual = actual.next; // Seguimos avanzando al siguiente nodo
        }  
        return contador; // Al final-> devolvemos el número total de tareas encontradas  
    }

    // Este metodo encuentra la tarea con la mayor prioridad 
    // Solo funciona si las tareas son objetos que tienen un método getPrioridad()
    public T obtenerTareaMasPrioritaria() {
        if (head == null) {
            // Si no hay tareas ->  no podemos devolver nada
            return null;
        }
        Node<T> actual = head;
        T tareaMasPrioritaria = head.data; // Suponemos que la primera tarea es la más prioritaria (por ahora)

        while (actual != null) {
            // Aquí comparamos prioridades  pero primero nos aseguramos de que sean tareas válidas
            if (actual.data instanceof Tarea) {
                Tarea tareaActual = (Tarea) actual.data;
                Tarea tareaComparar = (Tarea) tareaMasPrioritaria;
                // Si la prioridad de esta tarea es mayor (o menor numero si consideramos urgencia), la cambiamos
                if (tareaActual.getPrioridad() < tareaComparar.getPrioridad()) {
                    tareaMasPrioritaria = actual.data;
                }
            }
            actual = actual.next; // Seguimos al siguiente nodo
        }
        return tareaMasPrioritaria; // Al final devolvemos la tarea mas prioritaria encontrada
    }

    // Este metodo invierte el orden de las tareas en la lista enlazada
    public void invertirTareas() {
     Node<T> anterior = null;    // Este va a ser el nodo que va detras (al principio no hay nadie detras)
     Node<T> actual = head;      // Empezamos desde el primer nodo
     Node<T> siguiente = null;   // Este va a ser el que está adelante

        while (actual != null) {
            siguiente = actual.next;  // Guardamos-> cual es el siguiente nodo
            actual.next = anterior;   // Ahora le decimos al nodo actual que mire hacia atrás
            anterior = actual;        // Movemos el "anterior" a donde estamos ahora
            actual = siguiente;       // Y avanzamos el "actual" al siguiente nodo que habiamos guardado
        }

        // Al final de todo, el anterior sera la nueva cabeza de la lista
        head = anterior;
    }
    // Este metodo mueve una tarea de la lista pendiente a la lista de tareas completadas
    public boolean completarTarea(T tarea) {
        if (eliminarTarea(tarea)) { // Si logramos eliminar la tarea de las pendientes
            tareasCompletadas.add(tarea); // La agregamos a la lista de completadas
            return true;
        }
        return false; // Si no la encontramos, no hacemos nada
    }
        // Este metodo devuelve la lista de tareas que ya hemos completado
    public List<T> getTareasCompletadas() {
        return tareasCompletadas;
    }
}