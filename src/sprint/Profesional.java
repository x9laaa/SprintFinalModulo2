package sprint;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * La clase Profesional extiende la clase Usuario y añade atributos específicos
 * como título y fecha de ingreso.
 * @version 1.0
 * @author Alex Carreño y Max Jeldres
 */

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    /**
     * Constructor por defecto de la clase Profesional.
     */

    public Profesional() {
    }

    /**
     * Constructor de la clase Profesional con parámetros.
     * 
     * @param rut             El RUT del profesional, debe ser un número positivo
     *                        menor a 99.999.999.
     * @param nombre          El nombre del profesional, debe tener entre 5 y 50
     *                        caracteres.
     * @param apellido        El apellido del profesional, debe tener entre 5 y 50
     *                        caracteres.
     * @param fechaNacimiento La fecha de nacimiento del profesional en formato
     *                        DD/MM/YYYY.
     * @param titulo          El título del profesional, debe tener entre 10 y 50
     *                        caracteres.
     * @param fechaIngreso    La fecha de ingreso del profesional en formato
     *                        DD/MM/YYYY.
     */
    public Profesional(int rut, String nombre, String apellido, String fechaNacimiento, String titulo,
            String fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento);
        setTitulo(titulo);
        setFechaIngreso(fechaIngreso);
    }

    /**
     * Analiza el usuario profesional mostrando su información básica y específica.
     */

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo + ", Fecha de Ingreso: "
                + fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    /**
     * Retorna una representación en cadena del profesional.
     * 
     * @return Una cadena que contiene la información del profesional, incluyendo el
     *         título y la fecha de ingreso.
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = fechaIngreso.format(formatter);
        return "Profesional:[" + super.toString() + "] - [Título: " + titulo + ", Fecha de Ingreso: " + formattedDate
                + "]";
    }

    /**
     * Obtiene el título del profesional.
     * 
     * @return El título del profesional.
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del profesional. Debe tener entre 10 y 50 caracteres.
     * 
     * @param titulo El título del profesional.
     * @throws IllegalArgumentException Si el título no es válido.
     */

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.length() < 10 || titulo.length() > 50) {
            throw new IllegalArgumentException("El título es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.titulo = titulo;
    }

    /**
     * Obtiene la fecha de ingreso del profesional.
     * 
     * @return La fecha de ingreso del profesional.
     */

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del profesional. Debe estar en formato
     * DD/MM/YYYY.
     * 
     * @param fechaIngreso La fecha de ingreso del profesional en formato
     *                     DD/MM/YYYY.
     * @throws IllegalArgumentException Si la fecha de ingreso no es válida.
     */

    public void setFechaIngreso(String fechaIngreso) {
        if (fechaIngreso == null || fechaIngreso.isEmpty()) {
            throw new IllegalArgumentException("La fecha de ingreso es obligatoria.");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaIngreso = LocalDate.parse(fechaIngreso, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha de ingreso debe ser válida y en el formato DD/MM/YYYY.");
        }
    }

}