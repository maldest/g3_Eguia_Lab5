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

}