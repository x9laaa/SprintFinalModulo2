package sprint;

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
    }

    public Administrativo(int rut, String nombre, String apellido, String fechaNacimiento, String area,
            String experienciaPrevia) {
        super(rut, nombre, apellido, fechaNacimiento);
        setArea(area);
        setExperienciaPrevia(experienciaPrevia);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Área: " + area + ", Experiencia previa: " + experienciaPrevia);
    }

    @Override
    public String toString() {
        return "Administrativo [" + super.toString() + ", área=" + area + ", experienciaPrevia=" + experienciaPrevia
                + "]";
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (area == null || area.length() < 5 || area.length() > 20) {
            throw new IllegalArgumentException("El área es obligatoria y debe tener entre 5 y 20 caracteres.");
        }
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia == null || experienciaPrevia.length() < 10 || experienciaPrevia.length() > 100) {
            throw new IllegalArgumentException(
                    "La experiencia previa es obligatoria y debe tener entre 10 y 100 caracteres.");
        }
        this.experienciaPrevia = experienciaPrevia;
    }
}