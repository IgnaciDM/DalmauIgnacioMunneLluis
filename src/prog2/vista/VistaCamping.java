package prog2.vista;

import prog2.model.*;

import java.io.IOException;
import java.util.Scanner;

public class VistaCamping {
    private final String nomCamping;
    private Camping camping;

    private enum OpcionsMenu {
        Llistes,
        AfegirIncidencia,
        EliminarIncidencia,
        AccessibilitatCotxe,
        AccessosAsfaltats,
        GuardarCamping,
        RecuperarCamping,
        Sortir};

    private enum OpcionsSubmenu1 {
        Allotjaments,
        AllotjamentsOperatius,
        AllotjamentsNoOperatius,
        AccessosOberts,
        AccessosTancats,
        IncidenciesActuals,
        SortirLlistat};

    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={"Llistar la informacio",
            "Afegir una incidencia",
            "Eliminar una incidencia",
            "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe",
            "Calcular i mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats",
            "Guarda les dades del càmping en un fitxer.",
            "Carrega d’un fitxer les dades del càmping prèviament guardades.",
            "Sortir de l’aplicació"
    };

    // Declarem descripcions personalitzades per a les opcions del menú secundari
    static private String[] descMenu2={". Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les incidències actuals",

    };


    public VistaCamping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.camping = new Camping(nomCamping);

    }

    public void gestioCamping() throws ExcepcioCamping {
        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenu> menu = new Menu(nomCamping + "-MENU", OpcionsMenu.values());//L'enum <OpcionsMenu>

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenu op = null;


        do {
            menu.mostrarMenu();//Mostrem el menu
            op = menu.getOpcio(sc);
            switch (op) {
                case Llistes:
                    gestioMenuSecundari(sc);
                    break;
                case AfegirIncidencia:

                    //afegirIncidencia(int num, String tipus, String idAllotjament, String data)
                    try {
                        System.out.println("Introdueix la idIncidencia, el tipus, idAllotjament,la data");
                        camping.afegirIncidencia(sc.nextInt(), sc.next(), sc.next(), sc.next());
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: No s'ha trobat l'allotjament");
                    }
                    break;
                case EliminarIncidencia:
                    break;
                case AccessibilitatCotxe:
                    break;
                case AccessosAsfaltats:
                    break;
                case GuardarCamping:
                    System.out.println("Introdueix el nom del fitxer:");
                    String nomFitxer = sc.nextLine();
                    camping.guardar(nomFitxer);
                    break;
                case RecuperarCamping:
                    System.out.println("Introdueix el nom del fitxer:");
                    nomFitxer = sc.nextLine();
                    Camping campingCarregat = Camping.carregar(nomFitxer);
                    if (campingCarregat != null) {
                        camping = campingCarregat; // Reemplaza la instancia actual
                        System.out.println("Dades carregades correctament: " + camping);
                    } else{
                        System.out.println("No s'ha carregat correctament el fitxer");
                    }
                    break;
                case Sortir:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + op);
            }
        } while (op != OpcionsMenu.Sortir);
    }
    private void gestioMenuSecundari(Scanner sc) throws ExcepcioCamping {

        // Creem l'objecte per al menú. Li passem com a primer parÃ metre el nom del menú
        Menu<OpcionsSubmenu1> menu=new Menu<OpcionsSubmenu1>("Menu Secundari", OpcionsSubmenu1.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu2);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsSubmenu1 opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);


            // Fem les accions necessàries
            switch(opcio) {
                case Allotjaments:
                    LlistaAllotjaments.llistarAllotjaments(true && false);//MODIFICABLE
                    break;
                case AllotjamentsOperatius:
                    LlistaAllotjaments.llistarAllotjaments(true);
                    break;
                case AllotjamentsNoOperatius:
                    LlistaAllotjaments.llistarAllotjaments(false);
                    break;
                case AccessosOberts:
                    //LlistaAccessos.llistarAccessos(true);
                    break;
                case AccessosTancats:
                    //LlistaAccessos.llistarAccessos(false);
                    break;
                case IncidenciesActuals:
                    try {
                        camping.llistarIncidencies();
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: No s'ha trobat l'allotjament amb ID " + "allotjament");
                    }
                    break;
                case SortirLlistat:
                    break;
            }

        } while(opcio!= OpcionsSubmenu1.SortirLlistat);
    }
}