package sprint;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * La clase Capacitacion representa una capacitación organizada para un cliente.
 * Contiene información relevante como el identificador, RUT del cliente, día,
 * hora,
 * lugar, duración y cantidad de asistentes.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class Capacitacion {
    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    /**
     * Constructor por defecto de la clase Capacitacion.
     */

    public Capacitacion() {
    }

    /**
     * Constructor de la clase Capacitacion con parámetros.
     * 
     * @param identificador      El identificador único de la capacitación.
     * @param rutCliente         El RUT del cliente asociado a la capacitación.
     * @param dia                El día de la capacitación, debe ser un día válido
     *                           (lunes, martes, etc.).
     * @param hora               La hora de la capacitación en formato HH:MM.
     * @param lugar              El lugar donde se realizará la capacitación, debe
     *                           tener entre 10 y 50 caracteres.
     * @param duracion           La duración de la capacitación, no debe exceder los
     *                           70 caracteres.
     * @param cantidadAsistentes La cantidad de asistentes a la capacitación, debe
     *                           ser un número entero positivo menor que 1000.
     */

    public Capacitacion(int identificador, int rutCliente, String dia, String hora, String lugar, String duracion,
            int cantidadAsistentes) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantidadAsistentes(cantidadAsistentes);
    }

    /**
     * Muestra un detalle de la capacitación incluyendo el lugar, hora, día y
     * duración.
     * 
     * @return Una cadena que describe el detalle de la capacitación.
     */
    public String mostrarDetalle() {
        return "La capacitación será en " + lugar + " a las " + hora + " del día " + dia + ", y durará " + duracion
                + " minutos";
    }

    /**
     * Retorna una representación en cadena de la capacitación.
     * 
     * @return Una cadena que contiene la información de la capacitación.
     */

    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia
                + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes="
                + cantidadAsistentes + "]";
    }

    /**
     * Obtiene el identificador de la capacitación.
     * 
     * @return El identificador de la capacitación.
     */

    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador de la capacitación. Debe ser un número positivo.
     * 
     * @param identificador El identificador de la capacitación.
     * @throws IllegalArgumentException Si el identificador no es válido.
     */
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador es obligatorio y debe ser un número positivo.");
        }
        this.identificador = identificador;
    }

    /**
     * Obtiene el RUT del cliente asociado a la capacitación.
     * 
     * @return El RUT del cliente.
     */

    public int getRutCliente() {
        return rutCliente;
    }

    /**
     * Establece el RUT del cliente asociado a la capacitación. Debe ser un número
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
     * Obtiene el día de la capacitación.
     * 
     * @return El día de la capacitación.
     */

    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la capacitación. Debe ser un día válido (lunes, martes,
     * miércoles, etc.).
     * 
     * @param dia El día de la capacitación.
     * @throws IllegalArgumentException Si el día no es válido.
     */

    public void setDia(String dia) {
        List<String> diasValidos = Arrays.asList("lunes", "martes", "miércoles", "jueves", "viernes", "sábado",
                "domingo");
        if (!diasValidos.contains(dia.toLowerCase())) {
            throw new IllegalArgumentException(
                    "El día debe ser uno de los siguientes: lunes, martes, miércoles, jueves, viernes, sábado, domingo.");
        }
        this.dia = dia;
    }

    /**
     * Obtiene la hora de la capacitación.
     * 
     * @return La hora de la capacitación.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora de la capacitación. Debe estar en formato HH:MM.
     * 
     * @param hora La hora de la capacitación.
     * @throws IllegalArgumentException Si la hora no es válida.
     */
    public void setHora(String hora) {
        try {
            LocalTime.parse(hora);
            this.hora = hora;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La hora debe ser válida y estar en formato HH:MM.");
        }
    }

    /**
     * Obtiene el lugar donde se realizará la capacitación.
     * 
     * @return El lugar de la capacitación.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar donde se realizará la capacitación. Debe tener entre 10 y
     * 50 caracteres.
     * 
     * @param lugar El lugar de la capacitación.
     * @throws IllegalArgumentException Si el lugar no es válido.
     */

    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    /**
     * Obtiene la duración de la capacitación.
     * 
     * @return La duración de la capacitación.
     */

    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la capacitación. No debe exceder los 70 caracteres.
     * 
     * @param duracion La duración de la capacitación.
     * @throws IllegalArgumentException Si la duración excede los 70 caracteres.
     */

    public void setDuracion(String duracion) {
        if (duracion.length() > 70) {
            throw new IllegalArgumentException("La duración no debe exceder los 70 caracteres.");
        }
        this.duracion = duracion;
    }

    /**
     * Obtiene la cantidad de asistentes a la capacitación.
     * 
     * @return La cantidad de asistentes.
     */

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    /**
     * Establece la cantidad de asistentes a la capacitación. Debe ser un número
     * positivo menor que 1000.
     * 
     * @param cantidadAsistentes La cantidad de asistentes.
     * @throws IllegalArgumentException Si la cantidad de asistentes no es válida.
     */

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes <= 0 || cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException(
                    "La cantidad de asistentes es obligatoria y debe ser un número entero menor que 1000.");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }
}