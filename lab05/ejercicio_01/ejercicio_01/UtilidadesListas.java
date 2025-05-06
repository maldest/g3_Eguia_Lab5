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
    





     // 6. Metodo generico para concatenar dos listas enlazadas
    public static <T> Node<T> concatenarListas(Node<T> head1, Node<T> head2) {
        // Si la primera lista está vacía, devolvemos la segunda
        if (head1 == null) return head2;

        // Recorremos hasta el final de la primera lista
        Node<T> actual = head1;
        while (actual.next != null) {
            actual = actual.next;
        }

        // Conectamos el último nodo de la primera lista con la segunda
        actual.next = head2;

        // Devolvemos la lista combinada
        return head1;
    
    }


// Metodo main para probar todas las funciones con ejemplos
    public static void main(String[] args) {
        // Creamos una lista normal con nombres de juegos
        List<String> juegos = new ArrayList<>();
        juegos.add("Zelda");
        juegos.add("Halo");
        juegos.add("God of War");

        // Probamos buscarElemento
        System.out.println("¿Está 'Halo'?: " + buscarElemento(juegos, "Halo"));

        // Probamos invertirLista
        System.out.println("Lista invertida: " + invertirLista(juegos));

        // Creamos una lista enlazada manualmente con armas
        Node<String> lista1 = new Node<>("Espada"); // Creamos el primer nodo
        lista1 = insertarAlFinal(lista1, "Lanza");   // Insertamos al final
        lista1 = insertarAlFinal(lista1, "Arco");    // Insertamos al final

        // Contamos los nodos de la lista enlazada
        System.out.println("Nodos en lista1: " + contarNodos(lista1));

        // Creamos una segunda lista enlazada para comparar
        Node<String> lista2 = new Node<>("Espada");
        lista2 = insertarAlFinal(lista2, "Lanza");
        lista2 = insertarAlFinal(lista2, "Arco");

        // Comparamos si ambas listas enlazadas son iguales
        System.out.println("¿Listas iguales?: " + sonIguales(lista1, lista2));

        // Creamos una tercera lista para concatenar
        Node<String> lista3 = new Node<>("Hacha");

        // Concatenamos lista1 con lista3
        lista1 = concatenarListas(lista1, lista3);

        // Contamos de nuevo los nodos de la lista concatenada
        System.out.println("Nodos después de concatenar: " + contarNodos(lista1));
    }
}