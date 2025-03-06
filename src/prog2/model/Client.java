package prog2.model;

import prog2.vista.ExcepcioReserva;

/**
 * Classe Client
 * Representa un client amb nom i DNI.
 * Comprova que el DNI tingui exactament 9 caràcters.
 */
public class Client {
    private String nom; // Nom del client
    private String dni; // DNI del client

    /**
     * Constructor de la classe Client.
     * @param nom Nom del client
     * @param dni DNI del client (ha de tenir 9 caràcters)
     * @throws ExcepcioReserva Si el DNI no té 9 caràcters
     */
    public Client(String nom, String dni) throws ExcepcioReserva {
        this.nom = nom;
        setDni(dni); // Validar i assignar el DNI
    }

    /**
     * Retorna el nom del client.
     * @return Nom del client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifica el nom del client.
     * @param nom Nou nom del client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retorna el DNI del client.
     * @return DNI del client
     */
    public String getDni() {
        return dni;
    }

    /**
     * Modifica el DNI del client, verificant que tingui 9 caràcters.
     * @param dni Nou DNI del client
     * @throws ExcepcioReserva Si el DNI no té exactament 9 caràcters
     */
    public void setDni(String dni) throws ExcepcioReserva {
        if (dni == null || dni.length() != 9) {
            throw new ExcepcioReserva("El DNI ha de tenir 9 caràcters.");
        }
        this.dni = dni;
    }

    /**
     * Retorna una representació en format String de l'objecte Client.
     * @return Cadena de text amb la informació del client
     */
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
