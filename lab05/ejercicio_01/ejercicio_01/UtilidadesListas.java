import java.util.ArrayList;
import java.util.List;

public class UtilidadesListas {

    // 1. Metodo generico para buscar un elemento en una lista (ArrayList u otra lista de Java)
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        // Recorremos cada elemento de la lista
        for (T elemento : lista) {
            // Si el elemento actual es igual al valor que buscamos, retornamos true
            if (elemento.equals(valor)) {
                return true; // Lo encontramos
            }
        }
        // Si terminamos de recorrer y no lo encontramos, retornamos false
        return false;
    }


      // 2. Metodo generico para invertir una lista (ArrayList)
      public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>(); // Nueva lista para almacenar los elementos en orden inverso

        // Recorremos la lista desde el último elemento hasta el primero
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i)); // Agregamos cada elemento al nuevo arreglo
        }

        // Devolvemos la lista invertida
        return invertida;
    }

    // 3. Metodo generico para insertar un nuevo nodo al final de una lista enlazada
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor); // Creamos un nuevo nodo con el valor

        // Si la lista está vacía, el nuevo nodo será la cabeza
        if (head == null) return nuevo;

        // Si no, recorremos hasta el último nodo
        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next; // Avanzamos al siguiente nodo
        }

        // Conectamos el último nodo con el nuevo
        actual.next = nuevo;

        // Retornamos la cabeza de la lista
        return head;
    }

     // 4. Metodo generico para contar el numero total de nodos en una lista enlazada
     public static <T> int contarNodos(Node<T> head) {
        int contador = 0; // Inicializamos el contador en 0
        Node<T> actual = head; // Empezamos desde la cabeza

        // Mientras no lleguemos al final
        while (actual != null) {
            contador++; // Contamos el nodo actual
            actual = actual.next; // Avanzamos al siguiente
        }

        // Devolvemos la cantidad total de nodos
        return contador;


        // 5. Metodo generico para comparar si dos listas enlazadas son iguales en contenido y orden
    public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
        // Mientras haya nodos en ambas listas
        while (head1 != null && head2 != null) {
            // Si los datos no son iguales, retornamos false
            if (!head1.data.equals(head2.data)) {
                return false;
            }
            // Avanzamos en ambas listas
            head1 = head1.next;
            head2 = head2.next;
        }

        // Si ambas llegaron al final al mismo tiempo, son iguales
        return head1 == null && head2 == null;
    

}
}