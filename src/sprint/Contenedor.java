package sprint;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {

    private List<Usuario> usuarios;
    private List<Capacitacion> capacitaciones;

    public Contenedor() {
        usuarios = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void almacenarCliente(Cliente cliente) {
        if (cliente != null) {
            usuarios.add(cliente);
            System.out.println("Cliente almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Cliente no puede ser nulo.");
        }
    }

    public void almacenarProfesional(Profesional profesional) {
        if (profesional != null) {
            usuarios.add(profesional);
            System.out.println("Profesional almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Profesional no puede ser nulo.");
        }
    }

    public void almacenarAdministrativo(Administrativo administrativo) {
        if (administrativo != null) {
            usuarios.add(administrativo);
            System.out.println("Administrativo almacenado exitosamente.");
        } else {
            throw new IllegalArgumentException("Administrativo no puede ser nulo.");
        }
    }

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

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

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
