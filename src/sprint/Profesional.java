package sprint;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    public Profesional() {
    }

    public Profesional(int rut, String nombre, String apellido, String fechaNacimiento, String titulo,
            String fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento);
        setTitulo(titulo);
        setFechaIngreso(fechaIngreso);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo + ", Fecha de Ingreso: "
                + fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = fechaIngreso.format(formatter);
        return "Profesional:[" + super.toString() + "] - [Título: " + titulo + ", Fecha de Ingreso: " + formattedDate
                + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.length() < 10 || titulo.length() > 50) {
            throw new IllegalArgumentException("El título es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.titulo = titulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

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