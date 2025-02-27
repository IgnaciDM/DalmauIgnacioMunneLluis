package prog2.model;
/*
Classe Client
La classe Client tindrà dos atributs de tipus String, el nom i el DNI i el seu constructor ha
de rebre els paràmetres en el mateix ordre que els rep el mètode afegirClient de la classe
Camping.(Primer client despres dni)
El mètode setter del DNI ha de comprovar que el DNI té 9 caràctersi llançar una excepció
de tipus ExcepcioReserva si no es compleix. És important que el constructor cridi a
aquest mètode setter per assignar el valor a l’atribut DNI.
A part, haurà d’implementar el mètode toString per donar el format desitjat a les
impressions per pantalla amb la informació de la classe.
 */

public class Client {//CLIENT FET
    private String nom;//HOLA
    private String dni;

    public Client(String nom, String dni) throws ExcepcioReserva {
        this.nom = nom;
        setDni(dni); // Utilitzem el setter per validar el DNI
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }//

    public void setDni(String dni) throws ExcepcioReserva {
        if (dni == null || dni.length() != 9) {
            throw new ExcepcioReserva("El DNI ha de tenir 9 caràcters.");
        }
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
