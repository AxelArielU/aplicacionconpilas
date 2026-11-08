package controlador;

import modelo.EditorTexto;
import vista.VistaConsola;

/**
 * Controlador: recibe la opción del usuario desde la Vista
 * y decide qué operación del Modelo ejecutar.
 */
public class ControladorEditor {

    private EditorTexto modelo;
    private VistaConsola vista;

    public ControladorEditor(EditorTexto modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            procesar(opcion);
        } while (opcion != 0);
        vista.mostrar("Saliendo del editor...");
    }

    private void procesar(int opcion) {
        switch (opcion) {
            case 1 -> registrar();
            case 2 -> deshacer();
            case 3 -> rehacer();
            case 4 -> verCimas();
            case 5 -> verHistoriales();
            case 6 -> verTamaños();
            case 0 -> { /* salir */ }
            default -> vista.mostrarError("Opción inválida. Intenta de nuevo.");
        }
    }

    private void registrar() {
        String accion = vista.leerAccion();
        if (accion == null || accion.isBlank()) {
            vista.mostrarError("La acción no puede estar vacía.");
            return;
        }
        modelo.registrarAccion(accion);
        vista.mostrarOk("Acción registrada: \"" + accion + "\"");
    }

    private void deshacer() {
        String accion = modelo.deshacer();
        if (accion == null) {
            vista.mostrarError("No hay acciones para deshacer.");
        } else {
            vista.mostrarOk("Se deshizo: \"" + accion + "\"");
        }
    }

    private void rehacer() {
        String accion = modelo.rehacer();
        if (accion == null) {
            vista.mostrarError("No hay acciones para rehacer.");
        } else {
            vista.mostrarOk("Se rehizo: \"" + accion + "\"");
        }
    }

    private void verCimas() {
        String r = modelo.cimaRealizadas();
        String p = modelo.cimaPorRehacer();
        vista.mostrar("Cima [realizadas]: " + (r == null ? "(vacía)" : r));
        vista.mostrar("Cima [por rehacer]: " + (p == null ? "(vacía)" : p));
    }

    private void verHistoriales() {
        vista.mostrar("\n--- Historial REALIZADAS (abajo → arriba) ---");
        imprimirPila(modelo.historialRealizadas());
        vista.mostrar("\n--- Historial POR REHACER (abajo → arriba) ---");
        imprimirPila(modelo.historialPorRehacer());
    }

    private void imprimirPila(String[] arr) {
        if (arr.length == 0) {
            vista.mostrar("  (vacía)");
            return;
        }
        for (String s : arr) vista.mostrar("  • " + s);
    }

    private void verTamaños() {
        vista.mostrar("Acciones en [realizadas] : " + modelo.tamañoRealizadas());
        vista.mostrar("Acciones en [por rehacer]: " + modelo.tamañoPorRehacer());
    }
}
