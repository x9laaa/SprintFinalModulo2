package sprint;

/**
 * La clase Revision representa una revisión realizada durante una visita.
 * Contiene detalles como el identificador de la revisión, el identificador de
 * la visita,
 * el nombre del revisador, un detalle adicional y el estado de la revisión.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class Revision {

    private int identificador;
    private int identificadorVisita;
    private String nombre;
    private String detalle;
    private int estado;

    /**
     * Constructor por defecto de la clase Revision.
     */

    public Revision() {
    }

    /**
     * Constructor de la clase Revision con parámetros.
     * 
     * @param identificador       El identificador único de la revisión.
     * @param identificadorVisita El identificador de la visita asociada a la
     *                            revisión.
     * @param nombre              El nombre del revisador, debe tener entre 10 y 50
     *                            caracteres.
     * @param detalle             Detalle adicional de la revisión, no debe exceder
     *                            los 100 caracteres.
     * @param estado              El estado de la revisión, debe ser 1 (sin
     *                            problemas), 2 (con observaciones) o 3 (no
     *                            aprueba).
     */

    public Revision(int identificador, int identificadorVisita, String nombre, String detalle, int estado) {
        setIdentificador(identificador);
        setIdentificadorVisita(identificadorVisita);
        setNombre(nombre);
        setDetalle(detalle);
        setEstado(estado);
    }

    /**
     * Retorna una representación en cadena de la revisión.
     * 
     * @return Una cadena que contiene la información de la revisión.
     */

    @Override
    public String toString() {
        return "Revision [identificador=" + identificador + ", identificadorVisita=" + identificadorVisita + ", nombre="
                + nombre + ", detalle=" + detalle + ", estado=" + estado + "]";
    }

    /**
     * Obtiene el identificador de la revisión.
     * 
     * @return El identificador de la revisión.
     */

    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador de la revisión. Debe ser un número positivo.
     * 
     * @param identificador El identificador de la revisión.
     * @throws IllegalArgumentException Si el identificador no es válido.
     */

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador es obligatorio y debe ser un número positivo.");
        }
        this.identificador = identificador;
    }

    /**
     * Obtiene el identificador de la visita asociada a la revisión.
     * 
     * @return El identificador de la visita.
     */

    public int getIdentificadorVisita() {
        return identificadorVisita;
    }

    /**
     * Establece el identificador de la visita asociada a la revisión. Debe ser un
     * número positivo.
     * 
     * @param identificadorVisita El identificador de la visita.
     * @throws IllegalArgumentException Si el identificador de la visita no es
     *                                  válido.
     */

    public void setIdentificadorVisita(int identificadorVisita) {
        if (identificadorVisita <= 0) {
            throw new IllegalArgumentException(
                    "El identificador de la visita es obligatorio y debe ser un número positivo.");
        }
        this.identificadorVisita = identificadorVisita;
    }

    /**
     * Obtiene el nombre del revisador.
     * 
     * @return El nombre del revisador.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del revisador. Debe tener entre 10 y 50 caracteres.
     * 
     * @param nombre El nombre del revisador.
     * @throws IllegalArgumentException Si el nombre no cumple con el rango de
     *                                  caracteres.
     */

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el detalle adicional de la revisión.
     * 
     * @return El detalle de la revisión.
     */

    public String getDetalle() {
        return detalle;
    }

    /**
     * Establece el detalle adicional de la revisión. No debe exceder los 100
     * caracteres.
     * 
     * @param detalle El detalle de la revisión.
     * @throws IllegalArgumentException Si el detalle excede los 100 caracteres.
     */

    public void setDetalle(String detalle) {
        if (detalle.length() > 100) {
            throw new IllegalArgumentException("El detalle no debe exceder los 100 caracteres.");
        }
        this.detalle = detalle;
    }

    /**
     * Obtiene el estado de la revisión.
     * 
     * @return El estado de la revisión.
     */

    public int getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la revisión. Debe ser 1 (sin problemas), 2 (con
     * observaciones) o 3 (no aprueba).
     * 
     * @param estado El estado de la revisión.
     * @throws IllegalArgumentException Si el estado no es válido.
     */

    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException(
                    "El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
        }
        this.estado = estado;
    }
}
