public class Node<T> {
    T data;           // Aqui se guarda el dato que queremos almacenar
    Node<T> next;     // Este es el enlace o camino hacia el siguiente nodo en la lista

    // Constructor para crear un nodo cuando recién le damos un dato
    public Node(T data) {
        this.data = data;  // Guardamos el dato que nos pasan
        this.next = null;  // Como es un nodo nuevo, todavía no apunta a nadie (por eso es null)
    }
}