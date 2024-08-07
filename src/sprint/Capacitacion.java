package sprint;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Capacitacion {
    private int identificador;
    private String dia;
    private SimpleDateFormat hora;
    private String lugar;
    private String duracion;
    private int cantidad;
    private String rutCliente;

    public Capacitacion(int identificador, Cliente client, String dia, SimpleDateFormat hora, String lugar,
            String duracion, int cantidad, String rutCliente) {
        setRutCliente(String.valueOf(client.getRut()));
        this.identificador = identificador;
        setDia(dia);
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidad = cantidad;
        this.rutCliente = rutCliente;
    }

    public Capacitacion() {
    }

    private static final List<String> validDays = Arrays.asList(
            "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo");

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (!validDays.contains(dia.toLowerCase())) {
            throw new IllegalArgumentException("Día permitido entre “lunes” y “domingo”.");
        }
        this.dia = dia;
    }

    public SimpleDateFormat getHora() {
        return hora;
    }

    public void setHora(SimpleDateFormat hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        if (rutCliente == null || rutCliente.isEmpty()) {
            throw new IllegalArgumentException("RUT cliente es obligatorio.");
        }
        this.rutCliente = rutCliente;
    }

}
