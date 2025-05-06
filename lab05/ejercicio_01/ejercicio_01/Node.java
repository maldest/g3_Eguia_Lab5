// Clase Nodo generica
class Node<T> {
    T data;             // Dato que guarda el nodo (puede ser un juego, arma, etc.)
    Node<T> next;       // Apunta al siguiente nodo en la lista

    Node(T data) {
        this.data = data;   // Asignamos el dato
        this.next = null;   // Inicialmente no apunta a ningún otro nodo
    }
}