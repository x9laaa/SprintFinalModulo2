
import sprint.Profesional;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Crear un objeto Profesional con datos válidos
            Profesional profesional1 = new Profesional(12345678, "Juanadsa", "Pérez", "15/08/1985", "Ingeniero Civil", "12/13/1212");
            System.out.println(profesional1);
            profesional1.analizarUsuario();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}