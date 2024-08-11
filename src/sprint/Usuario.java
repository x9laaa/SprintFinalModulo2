package sprint;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * La clase Usuario representa un usuario con RUT, nombre, apellido y fecha de
 * nacimiento.
 * Implementa la interfaz Asesoria para proveer análisis básico del usuario.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class Usuario implements Asesoria {

    private int rut;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    /**
     * Constructor por defecto de la clase Usuario.
     */

    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con parámetros.
     * 
     * @param rut             El RUT del usuario, debe ser un número positivo menor
     *                        a 99.999.999.
     * @param nombre          El nombre del usuario, debe tener entre 5 y 50
     *                        caracteres.
     * @param apellido        El apellido del usuario, debe tener entre 5 y 50
     *                        caracteres.
     * @param fechaNacimiento La fecha de nacimiento del usuario en formato
     *                        DD/MM/YYYY.
     */

    public Usuario(int rut, String nombre, String apellido, String fechaNacimiento) {
        setRut(rut);
        setNombre(nombre);
        setApellido(apellido);
        setFechaNacimiento(fechaNacimiento);
    }

    /**
     * Muestra la edad del usuario calculada a partir de la fecha de nacimiento.
     * 
     * @return Un mensaje indicando la edad del usuario en años.
     */

    public String mostrarEdad() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return "El usuario tiene " + edad + " años";
    }

    /**
     * Retorna una representación en cadena del usuario.
     * 
     * @return Una cadena que contiene el RUT, nombre, apellido y fecha de
     *         nacimiento del usuario.
     */

    @Override
    public String toString() {
        return "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento;
    }

    /**
     * Analiza el usuario mostrando su nombre completo y RUT.
     */

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre + " " + apellido + ", RUT: " + rut);
    }

    /**
     * Obtiene el RUT del usuario.
     * 
     * @return El RUT del usuario.
     */

    public int getRut() {
        return rut;
    }

    /**
     * Establece el RUT del usuario. Debe ser un número positivo menor a 99.999.999.
     * 
     * @param rut El RUT del usuario.
     * @throws IllegalArgumentException Si el RUT no es válido.
     */

    public void setRut(int rut) {
        if (rut <= 0 || rut > 99999999) {
            throw new IllegalArgumentException("El RUT debe ser un número positivo menor a 99.999.999");
        }
        this.rut = rut;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario. Debe tener entre 5 y 50 caracteres.
     * 
     * @param nombre El nombre del usuario.
     * @throws IllegalArgumentException Si el nombre no es válido.
     */

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 5 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 5 y 50 caracteres");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return El apellido del usuario.
     */

    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario. Debe tener entre 5 y 50 caracteres.
     * 
     * @param apellido El apellido del usuario.
     * @throws IllegalArgumentException Si el apellido no es válido.
     */

    public void setApellido(String apellido) {
        if (apellido == null || apellido.length() < 5 || apellido.length() > 50) {
            throw new IllegalArgumentException("El apellido es obligatorio y debe tener entre 5 y 50 caracteres");
        }
        this.apellido = apellido;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * 
     * @return La fecha de nacimiento del usuario.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario. Debe estar en formato
     * DD/MM/YYYY.
     * 
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @throws IllegalArgumentException Si la fecha no es válida o no está en el
     *                                  formato correcto.
     */

    public void setFechaNacimiento(String fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser válida y en el formato DD/MM/YYYY");
        }
    }

}
