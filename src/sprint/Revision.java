package sprint;

public class Revision {

    private int identificador;
    private int identificadorVisita;
    private String nombre;
    private String detalle;
    private int estado;

    public Revision() {
    }

    public Revision(int identificador, int identificadorVisita, String nombre, String detalle, int estado) {
        setIdentificador(identificador);
        setIdentificadorVisita(identificadorVisita);
        setNombre(nombre);
        setDetalle(detalle);
        setEstado(estado);
    }

    @Override
    public String toString() {
        return "Revision [identificador=" + identificador + ", identificadorVisita=" + identificadorVisita + ", nombre="
                + nombre + ", detalle=" + detalle + ", estado=" + estado + "]";
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador es obligatorio y debe ser un número positivo.");
        }
        this.identificador = identificador;
    }

    public int getIdentificadorVisita() {
        return identificadorVisita;
    }

    public void setIdentificadorVisita(int identificadorVisita) {
        if (identificadorVisita <= 0) {
            throw new IllegalArgumentException("El identificador de la visita es obligatorio y debe ser un número positivo.");
        }
        this.identificadorVisita = identificadorVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        if (detalle.length() > 100) {
            throw new IllegalArgumentException("El detalle no debe exceder los 100 caracteres.");
        }
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException("El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
        }
        this.estado = estado;
    }
}
