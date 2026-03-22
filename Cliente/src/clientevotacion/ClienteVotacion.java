/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientevotacion;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/**
 * Punto de entrada del cliente de votación.
 * 
 * Esta clase inicializa el entorno visual de la aplicación,
 * configura el tema FlatLaf y lanza la ventana principal
 * usada por los votantes.
 */
/**
 *
 * @author Dylan
 */

public class ClienteVotacion {

    /**
     * Método principal del cliente.
     * 
     * Configura el estilo visual de la interfaz utilizando FlatLaf
     * y luego inicia la ventana del cliente dentro del hilo
     * de eventos de Swing, garantizando que la UI se cargue
     * correctamente y de manera segura.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Cargar el tema visual FlatLaf.
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error cargando FlatLaf: " + ex.getMessage());
        }

        // Iniciar ventana del cliente dentro del hilo de Swing.
        java.awt.EventQueue.invokeLater(() -> {
            VentanaCliente v = new VentanaCliente();
            v.setLocationRelativeTo(null); // Centrar ventana
            v.setVisible(true);
        });
    }
}
