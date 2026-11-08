package modelo;

public class EditorTexto {

    private PilaAcciones realizadas;
    private PilaAcciones porRehacer;

    public EditorTexto() {
        realizadas = new PilaAcciones();
        porRehacer = new PilaAcciones();
    }


    public void registrarAccion(String accion) {
        realizadas.push(accion);
        if (!porRehacer.isEmpty()) {
            porRehacer.clear();
        }
    }

    public String deshacer() {
        if (realizadas.isEmpty()) return null;
        String accion = realizadas.pop();
        porRehacer.push(accion);
        return accion;
    }


    public String rehacer() {
        if (porRehacer.isEmpty()) return null;
        String accion = porRehacer.pop();
        realizadas.push(accion);
        return accion;
    }

    public String cimaRealizadas()  { return realizadas.peek(); }
    public String cimaPorRehacer()  { return porRehacer.peek(); }
    public int tamañoRealizadas()   { return realizadas.size(); }
    public int tamañoPorRehacer()   { return porRehacer.size(); }
    public String[] historialRealizadas() { return realizadas.toArray(); }
    public String[] historialPorRehacer() { return porRehacer.toArray(); }
}