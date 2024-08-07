package sprint;

import java.time.LocalDate;

public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;

    public Profesional(int rut, String nombre, String apellido, LocalDate fechaNacimiento, String titulo,
            String fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        validLongTitulo(titulo);
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    private boolean validLongTitulo(String dato) {
        int dat = dato.length();
        return (50 > dat && dat >= 10);
    }

    @Override
    public String toString() {
        return "Profesional:[" + super.toString() + "] - [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
    }

}
