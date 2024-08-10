package sprint;

import java.time.LocalDate;
import java.time.Period;

public class Cliente extends Usuario {
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre)
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {
    }

    public Cliente(int rut, String nombre, String apellido, String fechaNacimiento, String telefono, String afp, int sistemaSalud, String direccion, String comuna) {
        super(rut, nombre, apellido, fechaNacimiento);
        setTelefono(telefono);
        setAfp(afp);
        setSistemaSalud(sistemaSalud);
        setDireccion(direccion);
        setComuna(comuna);
        this.edad = calcularEdad(); // Calcula la edad a partir de la fecha de nacimiento
    }

      private int calcularEdad() {
        return Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
    }


    public String obtenerNombre() {
        return getNombre() + " " + getApellido();
    }

    public String obtenerSistemaSalud() {
        return sistemaSalud == 1 ? "Fonasa" : "Isapre";
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Dirección: " + direccion + ", Comuna: " + comuna);
    }

    @Override
    public String toString() {
        return "Cliente ["+super.toString()+"telefono=" + telefono + ", afp=" + afp + ", sistemaSalud=" + sistemaSalud + ", direccion="
                + direccion + ", comuna=" + comuna + ", edad=" + edad + "]";
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 8 || telefono.length() > 15) {
            throw new IllegalArgumentException("El teléfono es obligatorio y debe tener entre 8 y 15 caracteres");
        }
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp == null || afp.length() < 4 || afp.length() > 30) {
            throw new IllegalArgumentException("La AFP es obligatoria y debe tener entre 4 y 30 caracteres");
        }
        this.afp = afp;
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud != 1 && sistemaSalud != 2) {
            throw new IllegalArgumentException("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre)");
        }
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.length() < 5 || direccion.length() > 100) {
            throw new IllegalArgumentException("La dirección es obligatoria y debe tener entre 5 y 100 caracteres");
        }
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna == null || comuna.length() < 3 || comuna.length() > 50) {
            throw new IllegalArgumentException("La comuna es obligatoria y debe tener entre 3 y 50 caracteres");
        }
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        int edadCalculada = calcularEdad();
        if (edad != edadCalculada) {
            throw new IllegalArgumentException("La edad no coincide con la fecha de nacimiento");
        }
        this.edad = edad;
    }
}