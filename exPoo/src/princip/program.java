package princip;

import Controller.AutomovelController;
import Model.AutoMovel;
import View.MenuAutomovel;

import java.util.ArrayList;
import java.util.List;

public class program {
    public static void main(String[] args) {
        List<AutoMovel> listaAutoMovel = new ArrayList<>();
        MenuAutomovel menu = new MenuAutomovel(listaAutoMovel, new AutomovelController(listaAutoMovel, null));
        AutomovelController controller = new AutomovelController(listaAutoMovel, menu);

        controller.iniciar();
    }
}
