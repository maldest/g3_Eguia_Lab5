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



}