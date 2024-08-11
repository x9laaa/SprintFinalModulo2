package sprint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * La clase Accidente representa un accidente registrado en el sistema.
 * Incluye detalles como identificador, RUT del cliente, día, hora, lugar,
 * origen y consecuencias del accidente.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class Accidente {

    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private LocalTime hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    /**
     * Constructor por defecto de la clase Accidente.
     */

    public Accidente() {
    }

    /**
     * Constructor de la clase Accidente con parámetros.
     * 
     * @param identificador El identificador único del accidente.
     * @param rutCliente    El RUT del cliente asociado al accidente.
     * @param dia           El día del accidente en formato DD/MM/YYYY.
     * @param hora          La hora del accidente en formato HH:MM.
     * @param lugar         El lugar donde ocurrió el accidente, debe tener entre 10
     *                      y 50 caracteres.
     * @param origen        El origen del accidente, opcional y con un máximo de 100
     *                      caracteres.
     * @param consecuencias Las consecuencias del accidente, opcional y con un
     *                      máximo de 100 caracteres.
     */

    public Accidente(int identificador, int rutCliente, String dia, String hora, String lugar, String origen,
            String consecuencias) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }

    /**
     * Retorna una representación en cadena del accidente.
     * 
     * @return Una cadena que contiene la información del accidente.
     */

    @Override
    public String toString() {
        return "Accidente [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora="
                + hora + ", lugar=" + lugar + ", origen=" + origen + ", consecuencias=" + consecuencias + "]";
    }

    /**
     * Obtiene el identificador del accidente.
     * 
     * @return El identificador del accidente.
     */

    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador del accidente. Debe ser un número positivo.
     * 
     * @param identificador El identificador del accidente.
     * @throws IllegalArgumentException Si el identificador no es válido.
     */
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador es obligatorio y debe ser un número positivo.");
        }
        this.identificador = identificador;
    }

    /**
     * Obtiene el RUT del cliente asociado al accidente.
     * 
     * @return El RUT del cliente.
     */
    public int getRutCliente() {
        return rutCliente;
    }

    /**
     * Establece el RUT del cliente asociado al accidente. Debe ser un número
     * positivo.
     * 
     * @param rutCliente El RUT del cliente.
     * @throws IllegalArgumentException Si el RUT no es válido.
     */
    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            throw new IllegalArgumentException("El RUT del cliente es obligatorio y debe ser un número positivo.");
        }
        this.rutCliente = rutCliente;
    }

    /**
     * Obtiene el día en que ocurrió el accidente.
     * 
     * @return El día del accidente.
     */

    public LocalDate getDia() {
        return dia;
    }

    /**
     * Establece el día en que ocurrió el accidente. Debe estar en formato
     * DD/MM/YYYY.
     * 
     * @param dia El día del accidente en formato cadena.
     * @throws IllegalArgumentException Si la fecha no es válida.
     */
    public void setDia(String dia) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dia = LocalDate.parse(dia, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha debe ser válida y estar en formato DD/MM/YYYY.");
        }
    }

    /**
     * Obtiene la hora en que ocurrió el accidente.
     * 
     * @return La hora del accidente.
     */

    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora en que ocurrió el accidente. Debe estar en formato HH:MM.
     * 
     * @param hora La hora del accidente en formato cadena.
     * @throws IllegalArgumentException Si la hora no es válida.
     */

    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La hora debe ser válida y estar en formato HH:MM.");
        }
    }

    /**
     * Obtiene el lugar donde ocurrió el accidente.
     * 
     * @return El lugar del accidente.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar donde ocurrió el accidente. Debe tener entre 10 y 50
     * caracteres.
     * 
     * @param lugar El lugar del accidente.
     * @throws IllegalArgumentException Si el lugar no es válido.
     */
    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    /**
     * Obtiene el origen del accidente.
     * 
     * @return El origen del accidente.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece el origen del accidente. Puede ser opcional, pero no debe exceder
     * los 100 caracteres.
     * 
     * @param origen El origen del accidente.
     * @throws IllegalArgumentException Si el origen excede los 100 caracteres.
     */
    public void setOrigen(String origen) {
        if (origen.length() > 100) {
            throw new IllegalArgumentException("El origen no debe exceder los 100 caracteres.");
        }
        this.origen = origen;
    }

    /**
     * Obtiene las consecuencias del accidente.
     * 
     * @return Las consecuencias del accidente.
     */
    public String getConsecuencias() {
        return consecuencias;
    }

    /**
     * Establece las consecuencias del accidente. Puede ser opcional, pero no debe
     * exceder los 100 caracteres.
     * 
     * @param consecuencias Las consecuencias del accidente.
     * @throws IllegalArgumentException Si las consecuencias exceden los 100
     *                                  caracteres.
     */

    public void setConsecuencias(String consecuencias) {
        if (consecuencias.length() > 100) {
            throw new IllegalArgumentException("Las consecuencias no deben exceder los 100 caracteres.");
        }
        this.consecuencias = consecuencias;
    }
}
