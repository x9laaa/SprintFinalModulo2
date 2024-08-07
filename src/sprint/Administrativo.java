package sprint;

import java.time.LocalDate;
import java.util.Optional;

public class Administrativo extends Usuario {
    private String area;
    private Optional<String> experiencia;

    public Administrativo(int rut, String nombre, String apellido, LocalDate fechaNacimiento) {
        super(rut, nombre, apellido, fechaNacimiento);
        if (validLongArea(area.length())) {
            this.area = area;
        } else {
            throw new IllegalArgumentException("Area entre 5 y 20 caract.");
        }

        if (experiencia.isPresent() && validLongExp(experiencia.get().length())) {
            this.experiencia = experiencia;
        } else {
            throw new IllegalArgumentException("max 100 caract en exp.");
        }
    }

    public Administrativo() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (validLongArea(area.length())) {
            this.area = area;
        } else {
            throw new IllegalArgumentException("Area entre 5 y 20 caract.");
        }
    }

    public Optional<String> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Optional<String> experiencia) {
        if (experiencia.isPresent() && validLongExp(experiencia.get().length())) {
            this.experiencia = experiencia;
        } else {
            throw new IllegalArgumentException("max 100 caract en exp.");
        }
    }

    private boolean validLongArea(int lng) {
        return lng >= 5 && lng <= 20;
    }

    private boolean validLongExp(int lng) {
        return lng <= 100;
    }

    @Override
    public String toString() {
        return "Administrativo:[" + super.toString() + "] - [area=" + area + ", experiencia=" + experiencia + "]";
    }

}
