package sprint;

import java.util.ArrayList;
import java.util.Iterator;

public class Contenedor {
    public ArrayList<Asesoria> ass;
    public ArrayList<Capacitacion> caps;

    public Contenedor() {
        this.ass = new ArrayList<>();
        this.caps = new ArrayList<>();
    }

    public void almacenarCliente(Asesoria cliente) {
        this.ass.add(cliente);
    }

    public void almacenarProfesiona(Asesoria prof) {
        this.ass.add(prof);
    }

    public void almacenarAdm(Asesoria adm) {
        this.ass.add(adm);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        this.caps.add(capacitacion);
    }

    /* Eliminar Usuarios */
    public void eliminarUs(String rut) {
        Iterator<Asesoria> it = ass.iterator();
        while (it.hasNext()) {
            Asesoria asesoria = it.next();
            if (asesoria.equals(rut)) {
                it.remove();
            }
        }
    }

    public ArrayList<Asesoria> listarUser() {
        return this.ass;
    }

    public ArrayList<Capacitacion> listarCaps() {
        return this.caps;
    }

    /**
     * falta el Lista User por tipo
     */
}
