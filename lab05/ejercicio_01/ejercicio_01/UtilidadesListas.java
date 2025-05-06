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
    }

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

    // Metodo auxiliar para imprimir todos los nodos de una lista enlazada
    public static <T> void imprimirLista(Node<T> head) {
        System.out.println("Contenido de la lista:"); // Mensaje inicial
        Node<T> actual = head; // Empezamos desde la cabeza

        // Recorremos todos los nodos
        while (actual != null) {
            System.out.println("- " + actual.data); // Mostramos el contenido del nodo
            actual = actual.next; // Avanzamos al siguiente nodo
        }
    }

    // Metodo main para probar todas las funciones con ejemplos sencillos (juegos o armas)
    public static void main(String[] args) {
        // Creamos una lista normal con nombres de juegos
        List<String> juegos = new ArrayList<>();
        juegos.add("Zelda");
        juegos.add("Halo");
        juegos.add("God of War");

        // 1. Buscar un elemento en una lista
        System.out.println("1. ¿Está 'Halo'?: " + buscarElemento(juegos, "Halo"));

        // 2. Invertir una lista
        System.out.println("2. Lista invertida: " + invertirLista(juegos));

        // 3. Insertar nodos al final de una lista enlazada
        Node<String> lista1 = new Node<>("Espada");
        lista1 = insertarAlFinal(lista1, "Lanza");
        lista1 = insertarAlFinal(lista1, "Arco");
        System.out.println("3. Lista 1 creada (armas cuerpo a cuerpo):");
        imprimirLista(lista1);

        // 4. Contar nodos de una lista enlazada
        System.out.println("4. Nodos en lista1: " + contarNodos(lista1));

        // 5. Comparar dos listas enlazadas
        Node<String> lista2 = new Node<>("Espada");
        lista2 = insertarAlFinal(lista2, "Lanza");
        lista2 = insertarAlFinal(lista2, "Arco");
        System.out.println("5. ¿Lista1 es igual a Lista2?: " + sonIguales(lista1, lista2));

        // 6. Concatenar dos listas enlazadas y mostrar el resultado
        Node<String> lista3 = new Node<>("Ballesta");
        lista3 = insertarAlFinal(lista3, "Catapulta");

        System.out.println("6. Lista 1 original:");
        imprimirLista(lista1);

        System.out.println("6. Lista 3 a concatenar:");
        imprimirLista(lista3);

        Node<String> listaCombinada = concatenarListas(lista1, lista3);

        System.out.println("6. Lista combinada (Lista1 + Lista3):");
        imprimirLista(listaCombinada);
    }
}