import java.util.Scanner;
import sprint.Administrativo;
import sprint.Capacitacion;
import sprint.Cliente;
import sprint.Contenedor;
import sprint.Profesional;

/**
 * La clase App es la clase principal que maneja el menú de opciones para
 * interactuar con las clases Cliente, Profesional, Administrativo y
 * Capacitacion.
 * Contiene un menú interactivo para gestionar usuarios y capacitaciones.
 * 
 * @author Alex Carreño y Max Jeldres
 */

public class App {

    /**
     * Método principal que ejecuta el menú interactivo para gestionar los usuarios
     * y capacitaciones.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Almacenar Cliente");
            System.out.println("2. Almacenar Profesional");
            System.out.println("3. Almacenar Administrativo");
            System.out.println("4. Almacenar Capacitación");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Listar Usuarios");
            System.out.println("7. Listar Usuarios por Tipo");
            System.out.println("8. Listar Capacitaciones");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerInt(scanner, "Por favor ingrese una opción válida: ");

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del Cliente:");
                    int rutCliente = leerInt(scanner, "RUT (solo números): ");
                    System.out.print("Nombre: ");
                    String nombreCliente = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellidoCliente = scanner.nextLine().trim();
                    System.out.print("Fecha de Nacimiento (DD/MM/YYYY): ");
                    String fechaNacimientoCliente = scanner.nextLine().trim();
                    System.out.print("Teléfono: ");
                    String telefonoCliente = scanner.nextLine().trim();
                    System.out.print("AFP: ");
                    String afpCliente = scanner.nextLine().trim();
                    int sistemaSaludCliente = leerInt(scanner, "Sistema de Salud: ");
                    System.out.print("Dirección: ");
                    String direccionCliente = scanner.nextLine().trim();
                    System.out.print("Comuna: ");
                    String comunaCliente = scanner.nextLine().trim();

                    try {
                        Cliente cliente = new Cliente(rutCliente, nombreCliente, apellidoCliente,
                                fechaNacimientoCliente,
                                telefonoCliente, afpCliente, sistemaSaludCliente, direccionCliente, comunaCliente);
                        contenedor.almacenarCliente(cliente);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Ingrese los datos del Profesional:");
                    int rutProfesional = leerInt(scanner, "RUT (solo números): ");
                    System.out.print("Nombre: ");
                    String nombreProfesional = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellidoProfesional = scanner.nextLine().trim();
                    System.out.print("Fecha de Nacimiento (DD/MM/YYYY): ");
                    String fechaNacimientoProfesional = scanner.nextLine().trim();
                    System.out.print("Título: ");
                    String tituloProfesional = scanner.nextLine().trim();
                    System.out.print("Fecha de Ingreso (DD/MM/YYYY): ");
                    String fechaIngresoProfesional = scanner.nextLine().trim();

                    try {
                        Profesional profesional = new Profesional(rutProfesional, nombreProfesional,
                                apellidoProfesional,
                                fechaNacimientoProfesional, tituloProfesional, fechaIngresoProfesional);
                        contenedor.almacenarProfesional(profesional);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Ingrese los datos del Administrativo:");
                    int rutAdministrativo = leerInt(scanner, "RUT (solo números): ");
                    System.out.print("Nombre: ");
                    String nombreAdministrativo = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellidoAdministrativo = scanner.nextLine().trim();
                    System.out.print("Fecha de Nacimiento (DD/MM/YYYY): ");
                    String fechaNacimientoAdministrativo = scanner.nextLine().trim();
                    System.out.print("Área: ");
                    String areaAdministrativo = scanner.nextLine().trim();
                    System.out.print("Experiencia Previa: ");
                    String experienciaPreviaAdministrativo = scanner.nextLine().trim();

                    try {
                        Administrativo administrativo = new Administrativo(rutAdministrativo, nombreAdministrativo,
                                apellidoAdministrativo, fechaNacimientoAdministrativo, areaAdministrativo,
                                experienciaPreviaAdministrativo);
                        contenedor.almacenarAdministrativo(administrativo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Ingrese los datos de la Capacitación:");
                    int idCapacitacion = leerInt(scanner, "Identificador: ");
                    int rutClienteCapacitacion = leerInt(scanner, "RUT Cliente: ");
                    System.out.print("Día (lunes a domingo): ");
                    String diaCapacitacion = scanner.nextLine().trim();
                    System.out.print("Hora (HH:MM): ");
                    String horaCapacitacion = scanner.nextLine().trim();
                    System.out.print("Lugar: ");
                    String lugarCapacitacion = scanner.nextLine().trim();
                    System.out.print("Duración (en minutos): ");
                    String duracionCapacitacion = scanner.nextLine().trim();
                    int cantidadAsistentes = leerInt(scanner, "Cantidad de Asistentes: ");

                    Capacitacion capacitacion = new Capacitacion(idCapacitacion, rutClienteCapacitacion,
                            diaCapacitacion,
                            horaCapacitacion, lugarCapacitacion, duracionCapacitacion, cantidadAsistentes);
                    try {
                        contenedor.almacenarCapacitacion(capacitacion);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    int rutEliminar = leerInt(scanner, "Ingrese el RUT del usuario a eliminar: ");
                    try {
                        contenedor.eliminarUsuario(rutEliminar);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Listado de Usuarios:");
                    contenedor.listarUsuarios();
                    break;

                case 7:
                    System.out.print("Ingrese el tipo de usuario a listar (Cliente, Profesional, Administrativo): ");
                    String tipoUsuario = scanner.nextLine().trim();
                    switch (tipoUsuario.toLowerCase()) {
                        case "cliente":
                            contenedor.listarUsuariosPorTipo(Cliente.class);
                            break;
                        case "profesional":
                            contenedor.listarUsuariosPorTipo(Profesional.class);
                            break;
                        case "administrativo":
                            contenedor.listarUsuariosPorTipo(Administrativo.class);
                            break;
                        default:
                            System.out.println("Tipo de usuario no válido.");
                            break;
                    }
                    break;

                case 8:
                    System.out.println("Listado de Capacitaciones:");
                    contenedor.listarCapacitaciones();
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    /**
     * Lee y valida una entrada de número entero desde el usuario.
     * 
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @param mensaje El mensaje que se muestra al usuario para pedir la entrada.
     * @return Un número entero válido ingresado por el usuario.
     */

    private static int leerInt(Scanner scanner, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número entero.");
            }
        }
    }
}