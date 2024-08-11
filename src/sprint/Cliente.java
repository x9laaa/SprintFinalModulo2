package sprint;

import java.time.LocalDate;
import java.time.Period;

/**
 * La clase Cliente extiende la clase Usuario y añade atributos específicos como
 * teléfono, AFP, sistema de salud, dirección, comuna y edad.
 * @version 1.0
 * @author Alex Carreño y Max Jeldres
 */

public class Cliente extends Usuario {
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre)
    private String direccion;
    private String comuna;
    private int edad;

    /**
     * Constructor por defecto de la clase Cliente.
     */
    public Cliente() {
    }

    /**
     * Constructor de la clase Cliente con parámetros.
     * 
     * @param rut             El RUT del cliente, debe ser un número positivo menor
     *                        a 99.999.999.
     * @param nombre          El nombre del cliente, debe tener entre 5 y 50
     *                        caracteres.
     * @param apellido        El apellido del cliente, debe tener entre 5 y 50
     *                        caracteres.
     * @param fechaNacimiento La fecha de nacimiento del cliente en formato
     *                        DD/MM/YYYY.
     * @param telefono        El teléfono del cliente, debe tener entre 8 y 15
     *                        caracteres.
     * @param afp             La AFP del cliente, debe tener entre 4 y 30
     *                        caracteres.
     * @param sistemaSalud    El sistema de salud del cliente, debe ser 1 (Fonasa) o
     *                        2 (Isapre).
     * @param direccion       La dirección del cliente, debe tener entre 5 y 100
     *                        caracteres.
     * @param comuna          La comuna del cliente, debe tener entre 3 y 50
     *                        caracteres.
     */

    public Cliente(int rut, String nombre, String apellido, String fechaNacimiento, String telefono, String afp,
            int sistemaSalud, String direccion, String comuna) {
        super(rut, nombre, apellido, fechaNacimiento);
        setTelefono(telefono);
        setAfp(afp);
        setSistemaSalud(sistemaSalud);
        setDireccion(direccion);
        setComuna(comuna);
        this.edad = calcularEdad(); // Calcula la edad a partir de la fecha de nacimiento
    }

    /**
     * Calcula la edad del cliente a partir de la fecha de nacimiento.
     * 
     * @return La edad del cliente.
     */

    private int calcularEdad() {
        return Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
    }

    /**
     * Obtiene el nombre completo del cliente (nombre y apellido).
     * 
     * @return El nombre completo del cliente.
     */

    public String obtenerNombre() {
        return getNombre() + " " + getApellido();
    }

    /**
     * Obtiene el sistema de salud del cliente como una cadena.
     * 
     * @return "Fonasa" si el sistema de salud es 1, "Isapre" si es 2.
     */

    public String obtenerSistemaSalud() {
        return sistemaSalud == 1 ? "Fonasa" : "Isapre";
    }

    /**
     * Analiza el usuario cliente mostrando su información básica y específica.
     */

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Dirección: " + direccion + ", Comuna: " + comuna);
    }

    /**
     * Retorna una representación en cadena del cliente.
     * 
     * @return Una cadena que contiene la información del cliente, incluyendo el
     *         teléfono, AFP, sistema de salud, dirección, comuna y edad.
     */

    @Override
    public String toString() {
        return "Cliente [" + super.toString() + "telefono=" + telefono + ", afp=" + afp + ", sistemaSalud="
                + sistemaSalud + ", direccion="
                + direccion + ", comuna=" + comuna + ", edad=" + edad + "]";
    }

    /**
     * Obtiene el teléfono del cliente.
     * 
     * @return El teléfono del cliente.
     */

    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente. Debe tener entre 8 y 15 caracteres.
     * 
     * @param telefono El teléfono del cliente.
     * @throws IllegalArgumentException Si el teléfono no es válido.
     */

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 8 || telefono.length() > 15) {
            throw new IllegalArgumentException("El teléfono es obligatorio y debe tener entre 8 y 15 caracteres");
        }
        this.telefono = telefono;
    }

    /**
     * Obtiene la AFP del cliente.
     * 
     * @return La AFP del cliente.
     */
    public String getAfp() {
        return afp;
    }

    /**
     * Establece la AFP del cliente. Debe tener entre 4 y 30 caracteres.
     * 
     * @param afp La AFP del cliente.
     * @throws IllegalArgumentException Si la AFP no es válida.
     */

    public void setAfp(String afp) {
        if (afp == null || afp.length() < 4 || afp.length() > 30) {
            throw new IllegalArgumentException("La AFP es obligatoria y debe tener entre 4 y 30 caracteres");
        }
        this.afp = afp;
    }

    /**
     * Obtiene el sistema de salud del cliente.
     * 
     * @return El sistema de salud del cliente.
     */

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    /**
     * Establece el sistema de salud del cliente. Debe ser 1 (Fonasa) o 2 (Isapre).
     * 
     * @param sistemaSalud El sistema de salud del cliente.
     * @throws IllegalArgumentException Si el sistema de salud no es 1 o 2.
     */

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud != 1 && sistemaSalud != 2) {
            throw new IllegalArgumentException("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre)");
        }
        this.sistemaSalud = sistemaSalud;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return La dirección del cliente.
     */

    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente. Debe tener entre 5 y 100 caracteres.
     * 
     * @param direccion La dirección del cliente.
     * @throws IllegalArgumentException Si la dirección no es válida.
     */

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.length() < 5 || direccion.length() > 100) {
            throw new IllegalArgumentException("La dirección es obligatoria y debe tener entre 5 y 100 caracteres");
        }
        this.direccion = direccion;
    }

    /**
     * Obtiene la comuna del cliente.
     * 
     * @return La comuna del cliente.
     */

    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna del cliente. Debe tener entre 3 y 50 caracteres.
     * 
     * @param comuna La comuna del cliente.
     * @throws IllegalArgumentException Si la comuna no es válida.
     */

    public void setComuna(String comuna) {
        if (comuna == null || comuna.length() < 3 || comuna.length() > 50) {
            throw new IllegalArgumentException("La comuna es obligatoria y debe tener entre 3 y 50 caracteres");
        }
        this.comuna = comuna;
    }

    /**
     * Obtiene la edad del cliente.
     * 
     * @return La edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del cliente. Debe coincidir con la edad calculada a partir
     * de la fecha de nacimiento.
     * 
     * @param edad La edad del cliente.
     * @throws IllegalArgumentException Si la edad no coincide con la fecha de
     *                                  nacimiento.
     */
    public void setEdad(int edad) {
        int edadCalculada = calcularEdad();
        if (edad != edadCalculada) {
            throw new IllegalArgumentException("La edad no coincide con la fecha de nacimiento");
        }
        this.edad = edad;
    }
}