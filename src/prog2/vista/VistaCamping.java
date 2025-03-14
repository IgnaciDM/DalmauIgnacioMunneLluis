package prog2.vista;

import java.util.Scanner;

public class VistaCamping {
    private final String nomCamping;
    private enum OpcionsMenu {OPCIO1, OPCIO2, OPCIO3, SORTIR};


    public VistaCamping(String nomCamping) {
        this.nomCamping = nomCamping;
    }

    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenu> menu = new Menu(nomCamping + "-MENU", OpcionsMenu.values());//L'enum <OpcionsMenu>

        OpcionsMenu op = null;
        do {
            menu.mostrarMenu();//MOstrem el menu
            op = menu.getOpcio(sc);
            switch (op) {
                case OPCIO1:
                    break;
                case OPCIO2:
                    break;
                case OPCIO3:
                    break;
                case SORTIR:
                    break;
            }
        } while (op != OpcionsMenu.SORTIR);

    }
}
