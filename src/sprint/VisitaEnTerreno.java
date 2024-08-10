package sprint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VisitaEnTerreno {

    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private LocalTime hora;
    private String lugar;
    private String comentarios;

    public VisitaEnTerreno() {
    }

    public VisitaEnTerreno(int identificador, int rutCliente, String dia, String hora, String lugar,
            String comentarios) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
    }

    @Override
    public String toString() {
        return "VisitaEnTerreno [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia
                + ", hora=" + hora + ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
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

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            throw new IllegalArgumentException("El RUT del cliente es obligatorio y debe ser un número positivo.");
        }
        this.rutCliente = rutCliente;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(String dia) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dia = LocalDate.parse(dia, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha debe ser válida y estar en formato DD/MM/YYYY.");
        }
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La hora debe ser válida y estar en formato HH:MM.");
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no deben exceder los 100 caracteres.");
        }
        this.comentarios = comentarios;
    }
}
