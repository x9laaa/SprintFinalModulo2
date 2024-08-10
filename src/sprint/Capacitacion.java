package sprint;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class Capacitacion {
    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion() {
    }

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

    public String mostrarDetalle() {
        return "La capacitación será en " + lugar + " a las " + hora + " del día " + dia + ", y durará " + duracion
                + " minutos";
    }

    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia
                + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes="
                + cantidadAsistentes + "]";
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        List<String> diasValidos = Arrays.asList("lunes", "martes", "miércoles", "jueves", "viernes", "sábado",
                "domingo");
        if (!diasValidos.contains(dia.toLowerCase())) {
            throw new IllegalArgumentException(
                    "El día debe ser uno de los siguientes: lunes, martes, miércoles, jueves, viernes, sábado, domingo.");
        }
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        try {
            LocalTime.parse(hora);
            this.hora = hora;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion.length() > 70) {
            throw new IllegalArgumentException("La duración no debe exceder los 70 caracteres.");
        }
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes <= 0 || cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException(
                    "La cantidad de asistentes es obligatoria y debe ser un número entero menor que 1000.");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }
}