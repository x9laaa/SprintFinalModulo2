package sprint;

import java.time.LocalDate;
import java.time.Period;

public class Usuario implements Asesoria {

    private int rut;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Usuario() {
    }

    public Usuario(int rut, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String mostrarEdad() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return "El usuario tiene " + edad + " años";
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre + " " + apellido + ", RUT: " + rut);
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario [rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + "]";
    }

}
