package sprint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Accidente {

    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private LocalTime hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente() {
    }

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

    @Override
    public String toString() {
        return "Accidente [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora="
                + hora + ", lugar=" + lugar + ", origen=" + origen + ", consecuencias=" + consecuencias + "]";
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen.length() > 100) {
            throw new IllegalArgumentException("El origen no debe exceder los 100 caracteres.");
        }
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias.length() > 100) {
            throw new IllegalArgumentException("Las consecuencias no deben exceder los 100 caracteres.");
        }
        this.consecuencias = consecuencias;
    }
}
