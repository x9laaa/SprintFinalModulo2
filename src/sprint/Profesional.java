package sprint;

import java.time.LocalDate;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    public Profesional() {
    }

    public Profesional(int rut, String nombre, String apellido, LocalDate fechaNacimiento, String titulo,
            LocalDate fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo + ", Fecha de Ingreso: " + fechaIngreso);
    }

    @Override
    public String toString() {
        return "Profesional [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", toString()=" + super.toString()
                + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}