public class Tarea {
    private String nombre;  // Aquí vamos a guardar el nombre de la tarea
    private int prioridad;  // Aquí vamos a guardar su prioridad

    // Este es el constructor ->  para crear nuevas tareas
    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;        // Guardamos el nombre que nos pasen
        this.prioridad = prioridad;  // Y también la prioridad que nos digan
    }

    // Estos metodos se llaman getters -> nos permiten leer los datos guardados
    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }



    // Este metodo es TOSTRING -> para imprimir una tarea por consola d forma estilada
    
    public String toString() {
        return "Tarea: " + nombre + " (Prioridad: " + prioridad + ")";
    }
        // Este metodo se usa para comparar si dos tareas son iguales
        // Lo usamos en métodos como eliminarTarea o contieneTarea
        
        public boolean equals(Object obj) {
            // Si ambas referencias son la misma tarea exacta, retornamos true al instante
            if (this == obj) return true;

            // Si el objeto que nos pasan es null o no es una instancia de Tarea, no son iguales
            if (obj == null || getClass() != obj.getClass()) return false;

            // Convertimos el objeto a tipo Tarea para poder comparar sus atributos
            Tarea tarea = (Tarea) obj;

            // Comparamos nombre y prioridad -> si ambos coinciden, las tareas se consideran iguales
            return prioridad == tarea.prioridad && nombre.equals(tarea.nombre);
        }

}
