package sprint;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Usuario implements Asesoria {

    private int rut;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Usuario() {
    }

    public Usuario(int rut, String nombre, String apellido, String fechaNacimiento) {
        setRut(rut);
        setNombre(nombre);
        setApellido(apellido);
        setFechaNacimiento(fechaNacimiento);
    }

    public String mostrarEdad() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return "El usuario tiene " + edad + " años";
    }

    @Override
    public String toString() {
        return "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento;
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre + " " + apellido + ", RUT: " + rut);
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        if (rut <= 0 || rut > 99999999) {
            throw new IllegalArgumentException("El RUT debe ser un número positivo menor a 99.999.999");
        }
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 5 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 5 y 50 caracteres");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.length() < 5 || apellido.length() > 50) {
            throw new IllegalArgumentException("El apellido es obligatorio y debe tener entre 5 y 50 caracteres");
        }
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

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
