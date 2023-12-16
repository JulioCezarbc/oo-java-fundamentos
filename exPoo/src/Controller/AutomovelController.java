package Controller;

import Model.AutoMovel;
import View.MenuAutomovel;

import java.util.ArrayList;
import java.util.List;

public class AutomovelController {
    private final List<AutoMovel> modelo;
    private final MenuAutomovel view;

    public AutomovelController(List<AutoMovel> modelo, MenuAutomovel view) {
        this.modelo = modelo;
        this.view = view;
    }
    public void iniciar() {
        view.mostrarMenu();
    }

}