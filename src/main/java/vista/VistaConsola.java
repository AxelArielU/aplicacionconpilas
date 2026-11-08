package vista;
import java.util.Scanner;

public class VistaConsola {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== EDITOR DE TEXTO - DESHACER/REHACER =====");
        System.out.println("1. Registrar nueva acción");
        System.out.println("2. Deshacer última acción");
        System.out.println("3. Rehacer acción");
        System.out.println("4. Ver cima de cada pila");
        System.out.println("5. Mostrar historial de ambas pilas");
        System.out.println("6. Mostrar tamaño de cada pila");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;   // opción inválida
        }
    }

    public String leerAccion() {
        System.out.print("Escribe la acción a registrar: ");
        return sc.nextLine();
    }

    public void mostrar(String msg)  { System.out.println(msg); }
    public void mostrarError(String msg) { System.out.println("⚠ " + msg); }
    public void mostrarOk(String msg)    { System.out.println("✔ " + msg); }
}