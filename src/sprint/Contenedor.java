package sprint;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un contenedor para gestionar usuarios y capacitaciones.
 * Permite almacenar, eliminar y listar usuarios, así como almacenar y listar
 * capacitaciones.
 * @version 1.0
 * @author Alex Carreño y Max Jeldres
 */

public class Contenedor {

    private List<Usuario> usuarios;
    private List<Capacitacion> capacitaciones;

    /**
     * Constructor por defecto.
     * Inicializa las listas de usuarios y capacitaciones.
     */

    public Contenedor() {
        usuarios = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    /**
     * Almacena un cliente en el contenedor.
     * 
     * @param cliente Cliente a almacenar.
     * @throws IllegalArgumentException Si el cliente es nulo.
     */

    public void almacenarCliente(Cliente cliente) {
        if (cliente != null) {
            usuarios.add(cliente);
            System.out.println("Cliente almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Cliente no puede ser nulo.");
        }
    }

    /**
     * Almacena un profesional en el contenedor.
     * 
     * @param profesional Profesional a almacenar.
     * @throws IllegalArgumentException Si el profesional es nulo.
     */

    public void almacenarProfesional(Profesional profesional) {
        if (profesional != null) {
            usuarios.add(profesional);
            System.out.println("Profesional almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Profesional no puede ser nulo.");
        }
    }

    /**
     * Almacena un administrativo en el contenedor.
     * 
     * @param administrativo Administrativo a almacenar.
     * @throws IllegalArgumentException Si el administrativo es nulo.
     */

    public void almacenarAdministrativo(Administrativo administrativo) {
        if (administrativo != null) {
            usuarios.add(administrativo);
            System.out.println("Administrativo almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Administrativo no puede ser nulo.");
        }
    }

    /**
     * Almacena una capacitación en el contenedor.
     * Verifica que exista un cliente con el RUT proporcionado antes de almacenar la
     * capacitación.
     * 
     * @param capacitacion Capacitación a almacenar.
     * @throws IllegalArgumentException Si la capacitación es nula o si no se
     *                                  encuentra un cliente con el RUT
     *                                  proporcionado.
     */

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        if (capacitacion == null) {
            throw new IllegalArgumentException("La capacitación no puede ser nula.");
        }

        boolean clienteExiste = false;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente && usuario.getRut() == capacitacion.getRutCliente()) {
                clienteExiste = true;
                break;
            }
        }

        if (clienteExiste) {
            capacitaciones.add(capacitacion);
            System.out.println("Capacitación almacenada exitosamente.");
        } else {
            throw new IllegalArgumentException("No se encontró un cliente con el RUT proporcionado.");
        }
    }

    /**
     * Elimina un usuario del contenedor por su RUT.
     * 
     * @param rut RUT del usuario a eliminar.
     * @throws IllegalArgumentException Si el usuario no se encuentra en el
     *                                  contenedor.
     */

    public void eliminarUsuario(int rut) {

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            if (usuarios.removeIf(usuario -> usuario.getRut() == rut)) {
                System.out.println("Usuario con RUT " + rut + " eliminado exitosamente.");
            } else {
                throw new IllegalArgumentException("Usuario con RUT " + rut + " no encontrado.");
            }
        }

    }

    /**
     * Lista todos los usuarios registrados en el contenedor.
     */

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    /**
     * Lista todos los usuarios de un tipo específico.
     * 
     * @param tipo Clase del tipo de usuario a listar.
     */

    public void listarUsuariosPorTipo(Class<?> tipo) {
        boolean encontrado = false;
        for (Usuario usuario : usuarios) {
            if (tipo.isInstance(usuario)) {
                System.out.println(usuario);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron usuarios del tipo: " + tipo.getSimpleName());
        }
    }

    /**
     * Lista todas las capacitaciones registradas en el contenedor.
     * Muestra los clientes asociados a cada capacitación, si existen.
     */

    public void listarCapacitaciones() {
        if (capacitaciones.isEmpty()) {
            System.out.println("No hay capacitaciones registradas.");
        } else {
            for (Capacitacion capacitacion : capacitaciones) {
                System.out.println(capacitacion);
                for (Usuario usuario : usuarios) {
                    if (usuario instanceof Cliente && ((Cliente) usuario).getRut() == capacitacion.getRutCliente()) {
                        System.out.println("Cliente asociado: " + ((Cliente) usuario).obtenerNombre());
                    }
                }
            }
        }
    }
}
