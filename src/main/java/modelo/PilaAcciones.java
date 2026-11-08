package modelo;

public class PilaAcciones {

    private String[] datos;      // arreglo interno
    private int cima;            // índice del último elemento (-1 si vacía)
    private static final int CAPACIDAD_INICIAL = 10;

    public PilaAcciones() {
        datos = new String[CAPACIDAD_INICIAL];
        cima = -1;
    }

    /** Apila una acción en la cima. */
    public void push(String accion) {
        if (accion == null) return;
        if (cima == datos.length - 1) {
            redimensionar();     // crece al doble si se llena
        }
        datos[++cima] = accion;
    }

    /** Saca y devuelve la acción de la cima. Devuelve null si está vacía. */
    public String pop() {
        if (isEmpty()) return null;
        String accion = datos[cima];
        datos[cima] = null;      // ayuda al recolector de basura
        cima--;
        return accion;
    }

    /** Devuelve la cima sin eliminarla. Null si está vacía. */
    public String peek() {
        return isEmpty() ? null : datos[cima];
    }

    public boolean isEmpty() {
        return cima == -1;
    }

    public int size() {
        return cima + 1;
    }


    public String[] toArray() {
        String[] copia = new String[size()];
        for (int i = 0; i <= cima; i++) copia[i] = datos[i];
        return copia;
    }


    public void clear() {
        for (int i = 0; i <= cima; i++) datos[i] = null;
        cima = -1;
    }

    private void redimensionar() {
        String[] nuevo = new String[datos.length * 2];
        System.arraycopy(datos, 0, nuevo, 0, datos.length);
        datos = nuevo;
    }
}