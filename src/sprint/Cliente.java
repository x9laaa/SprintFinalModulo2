package sprint;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre)
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {
    }

    public Cliente(int rut, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(rut, nombre, apellido, fechaNacimiento);
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
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
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}