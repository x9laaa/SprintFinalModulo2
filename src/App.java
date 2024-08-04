import java.time.LocalDate;

import sprint.Administrativo;
import sprint.Capacitacion;
import sprint.Cliente;
import sprint.Contenedor;
import sprint.Profesional;

public class App {
    public static void main(String[] args) throws Exception {
        Contenedor contenedor = new Contenedor();

        Cliente cliente = new Cliente(12345678, "Juan", "Pérez", LocalDate.of(1985, 5, 20), "12345678", "Fonasa", 1, "123 Street", "Comuna", 35);
        Profesional profesional = new Profesional(87654321, "María", "Gómez", LocalDate.of(1990, 8, 15), "Ingeniera en Prevención de Riesgos", LocalDate.of(2020, 1, 10));
        Administrativo administrativo = new Administrativo(56789012, "Carlos", "Sánchez", LocalDate.of(1980, 12, 30), "Recursos Humanos", "5 años de experiencia");

        contenedor.almacenarCliente(cliente);
        contenedor.almacenarProfesional(profesional);
        contenedor.almacenarAdministrativo(administrativo);

        Capacitacion capacitacion = new Capacitacion(1, 12345678, "Lunes", "10:00", "Sala de reuniones", "60 minutos", 20);
        contenedor.almacenarCapacitacion(capacitacion);

        contenedor.listarUsuarios();

        System.out.println("\nListar Clientes:");
        contenedor.listarUsuariosPorTipo(Cliente.class);

        System.out.println("\nListar Profesionales:");
        contenedor.listarUsuariosPorTipo(Profesional.class);

        System.out.println("\nListar Administrativos:");
        contenedor.listarUsuariosPorTipo(Administrativo.class);

        System.out.println("\nListar Capacitaciones:");
        contenedor.listarCapacitaciones();
    }
}