package prog2.vista;

import java.util.Scanner;

public class VistaCamping {
    private final String nomCamping;
    private enum OpcionsMenu {
        Llistes,
        AfegirIncidencia,
        EliminarIncidencia,
        AccessibilitatCotxe,
        AccessosAsfaltats,
        GuardarCamping,
        RecuperarCamping,
        Sortir};

    private enum OpcionsSubmenu1 {Allotjaments, AllotjamentsOperatius, AllotjamentsNoOperatius, AccessosOberts, AccessosTancats, IncidenciesActuals, SortirLlistat};

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
                case Llistes:
                    gestioMenuSecundari(sc);
                    break;
                case AfegirIncidencia:
                    break;
                case EliminarIncidencia:
                    break;
                case AccessibilitatCotxe:
                    break;
                case AccessosAsfaltats:
                    break;
                case GuardarCamping:
                    break;
                case RecuperarCamping:
                    break;
                case Sortir:
                    break;
            }
        } while (op != OpcionsMenu.Sortir);
    }
    private void gestioMenuSecundari(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer parÃ metre el nom del menú
        Menu<ExempleMenu.OpcionsSubmenu1> menu=new Menu<ExempleMenu.OpcionsSubmenu1>("Menu Secundari", ExempleMenu.OpcionsSubmenu1.values());

        // Assignem la descripció de les opcions
        //menu.setDescripcions(descMenu2);

        // Obtenim una opció des del menú i fem les accions pertinents
        ExempleMenu.OpcionsSubmenu1 opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case Allotjaments:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opciÃ³ 1");
                    break;
                case AllotjamentsOperatius:
                    // Mostrem un missatge indicant que s'ha triat aquesta opció
                    System.out.println("Has triat la opciÃ³ 2");
                    break;
                case AllotjamentsNoOperatius:
                    System.out.println("Fins aviat!");
                    break;
                case AccessosOberts:
                    break;
                case AccessosTancats:
                    break;
                case IncidenciesActuals:
                    break;
                case SortirLlistat:
                    break;
            }

        } while(opcio!= ExempleMenu.OpcionsSubmenu1.SortirLlistat);
    }
}