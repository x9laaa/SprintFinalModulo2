package sprint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Representa una visita en terreno realizada a un cliente.
 * Contiene la información sobre el día, hora, lugar y comentarios de la visita.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class VisitaEnTerreno {

    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private LocalTime hora;
    private String lugar;
    private String comentarios;

    /**
     * Constructor por defecto.
     */
    public VisitaEnTerreno() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param identificador Identificador único de la visita.
     * @param rutCliente    RUT del cliente asociado a la visita.
     * @param dia           Fecha de la visita en formato DD/MM/YYYY.
     * @param hora          Hora de la visita en formato HH:MM.
     * @param lugar         Lugar de la visita.
     * @param comentarios   Comentarios adicionales sobre la visita.
     */

    public VisitaEnTerreno(int identificador, int rutCliente, String dia, String hora, String lugar,
            String comentarios) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
    }


    /**
     * Retorna una representación en cadena de la VisitaEnTerreno.
     * 
     * @return Una cadena que contiene la información de la VisitaEnTerreno.
     */

    @Override
    public String toString() {
        return "VisitaEnTerreno [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia
                + ", hora=" + hora + ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
    }

    /**
     * Obtiene el identificador de la visita.
     * 
     * @return Identificador de la visita.
     */

    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador de la visita.
     * 
     * @param identificador Identificador de la visita.
     * @throws IllegalArgumentException Si el identificador es menor o igual a 0.
     */
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador es obligatorio y debe ser un número positivo.");
        }
        this.identificador = identificador;
    }

    /**
     * Obtiene el RUT del cliente asociado a la visita.
     * 
     * @return RUT del cliente.
     */
    public int getRutCliente() {
        return rutCliente;
    }

    /**
     * Establece el RUT del cliente asociado a la visita.
     * 
     * @param rutCliente RUT del cliente.
     * @throws IllegalArgumentException Si el RUT es menor o igual a 0.
     */

    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            throw new IllegalArgumentException("El RUT del cliente es obligatorio y debe ser un número positivo.");
        }
        this.rutCliente = rutCliente;
    }

    /**
     * Obtiene la fecha de la visita.
     * 
     * @return Fecha de la visita.
     */

    public LocalDate getDia() {
        return dia;
    }

    /**
     * Establece la fecha de la visita.
     * 
     * @param dia Fecha de la visita en formato DD/MM/YYYY.
     * @throws IllegalArgumentException Si la fecha no es válida o no está en el
     *                                  formato DD/MM/YYYY.
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
     * Obtiene la hora de la visita.
     * 
     * @return Hora de la visita.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la visita.
     * 
     * @param hora Hora de la visita en formato HH:MM.
     * @throws IllegalArgumentException Si la hora no es válida o no está en el
     *                                  formato HH:MM.
     */
    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La hora debe ser válida y estar en formato HH:MM.");
        }
    }

    /**
     * Obtiene el lugar de la visita.
     * 
     * @return Lugar de la visita.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar de la visita.
     * 
     * @param lugar Lugar de la visita.
     * @throws IllegalArgumentException Si el lugar es nulo o tiene una longitud
     *                                  menor a 10 caracteres o mayor a 50.
     */
    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    /**
     * Obtiene los comentarios adicionales sobre la visita.
     * 
     * @return Comentarios de la visita.
     */

    public String getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios adicionales sobre la visita.
     * 
     * @param comentarios Comentarios de la visita.
     * @throws IllegalArgumentException Si los comentarios exceden los 100
     *                                  caracteres.
     */
    public void setComentarios(String comentarios) {
        if (comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no deben exceder los 100 caracteres.");
        }
        this.comentarios = comentarios;
    }
}
