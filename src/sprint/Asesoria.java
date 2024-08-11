package sprint;

/**
 * Interfaz que define el contrato para el análisis de usuarios.
 * Implementada por clases que necesitan proporcionar una forma de analizar a
 * los usuarios.
 * @version 1.0
 * @author Alex Carreño y Max Jeldres
 */

public interface Asesoria {

    /**
     * Método para analizar al usuario.
     * Las implementaciones deben proporcionar la lógica específica para analizar al
     * usuario.
     */
    void analizarUsuario();
}
