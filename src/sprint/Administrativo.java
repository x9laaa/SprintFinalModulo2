package sprint;

import java.time.LocalDate;

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
    }

    public Administrativo(int rut, String nombre, String apellido, LocalDate fechaNacimiento, String area, String experienciaPrevia) {
        super(rut, nombre, apellido, fechaNacimiento);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Área: " + area + ", Experiencia previa: " + experienciaPrevia);
    }
   

    @Override
    public String toString() {
        return "Administrativo ["+ super.toString()+ ", area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }
    
}
