package sprint;

/**
 * La clase Administrativo extiende la clase Usuario y añade atributos
 * específicos
 * como área de trabajo y experiencia previa.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    /**
     * Constructor por defecto de la clase Administrativo.
     */

    public Administrativo() {
    }

    /**
     * Constructor de la clase Administrativo con parámetros.
     * 
     * @param rut               El RUT del administrativo, debe ser un número
     *                          positivo menor a 99.999.999.
     * @param nombre            El nombre del administrativo, debe tener entre 5 y
     *                          50 caracteres.
     * @param apellido          El apellido del administrativo, debe tener entre 5 y
     *                          50 caracteres.
     * @param fechaNacimiento   La fecha de nacimiento del administrativo en formato
     *                          DD/MM/YYYY.
     * @param area              El área de trabajo del administrativo, debe tener
     *                          entre 5 y 20 caracteres.
     * @param experienciaPrevia La experiencia previa del administrativo, debe tener
     *                          entre 10 y 100 caracteres.
     */

    public Administrativo(int rut, String nombre, String apellido, String fechaNacimiento, String area,
            String experienciaPrevia) {
        super(rut, nombre, apellido, fechaNacimiento);
        setArea(area);
        setExperienciaPrevia(experienciaPrevia);
    }

    /**
     * Analiza el usuario administrativo mostrando su información básica y
     * específica.
     */

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Área: " + area + ", Experiencia previa: " + experienciaPrevia);
    }

    /**
     * Retorna una representación en cadena del administrativo.
     * 
     * @return Una cadena que contiene la información del administrativo, incluyendo
     *         área y experiencia previa.
     */

    @Override
    public String toString() {
        return "Administrativo [" + super.toString() + ", área=" + area + ", experienciaPrevia=" + experienciaPrevia
                + "]";
    }

    /**
     * Obtiene el área de trabajo del administrativo.
     * 
     * @return El área de trabajo del administrativo.
     */

    public String getArea() {
        return area;
    }

    /**
     * Establece el área de trabajo del administrativo. Debe tener entre 5 y 20
     * caracteres.
     * 
     * @param area El área de trabajo del administrativo.
     * @throws IllegalArgumentException Si el área no es válida.
     */
    public void setArea(String area) {
        if (area == null || area.length() < 5 || area.length() > 20) {
            throw new IllegalArgumentException("El área es obligatoria y debe tener entre 5 y 20 caracteres.");
        }
        this.area = area;
    }

    /**
     * Obtiene la experiencia previa del administrativo.
     * 
     * @return La experiencia previa del administrativo.
     */

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    /**
     * Establece la experiencia previa del administrativo. Debe tener entre 10 y 100
     * caracteres.
     * 
     * @param experienciaPrevia La experiencia previa del administrativo.
     * @throws IllegalArgumentException Si la experiencia previa no es válida.
     */

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia == null || experienciaPrevia.length() < 10 || experienciaPrevia.length() > 100) {
            throw new IllegalArgumentException(
                    "La experiencia previa es obligatoria y debe tener entre 10 y 100 caracteres.");
        }
        this.experienciaPrevia = experienciaPrevia;
    }
}