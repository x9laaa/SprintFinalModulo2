package sprint;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    public Profesional(int rut, String nombre, String apellido, LocalDate fechaNacimiento, String titulo,
            LocalDate fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento);
        if (validLongTitulo(titulo)) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
        }
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (validLongTitulo(titulo)) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
        }
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    private boolean validLongTitulo(String dato) {
        int dat = dato.length();
        return dat < 50 && dat >= 10;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = fechaIngreso.format(formatter);
        return "Profesional:[" + super.toString() + "] - [titulo=" + titulo + ", fechaIngreso=" + formattedDate + "]";
    }

}
