package org.example;

import controlador.ControladorEditor;
import modelo.EditorTexto;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        EditorTexto modelo = new EditorTexto();
        VistaConsola vista = new VistaConsola();
        ControladorEditor controlador = new ControladorEditor(modelo, vista);
        controlador.iniciar();
    }
}
