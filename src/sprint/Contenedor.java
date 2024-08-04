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
        usuarios.add(cliente);
    }

    public void almacenarProfesional(Profesional profesional) {
        usuarios.add(profesional);
    }

    public void almacenarAdministrativo(Administrativo administrativo) {
        usuarios.add(administrativo);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

    public void eliminarUsuario(int rut) {
        usuarios.removeIf(usuario -> usuario.getRut() == rut);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }

    public void listarUsuariosPorTipo(Class<?> tipo) {
        for (Usuario usuario : usuarios) {
            if (tipo.isInstance(usuario)) {
                System.out.println(usuario.toString());
            }
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion.toString());
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Cliente && ((Cliente) usuario).getRut() == capacitacion.getRutCliente()) {
                    System.out.println("Cliente asociado: " + ((Cliente) usuario).obtenerNombre());
                }
            }
        }
    }
}
