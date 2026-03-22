/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientevotacion;

import Votacion.Voto;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Gestiona una conexión persistente entre el cliente y el servidor
 * dentro del sistema de votación. 
 * 
 * Esta clase se encarga de abrir el socket, enviar objetos {@code Voto},
 * recibir respuestas del servidor y cerrar la conexión cuando ya no se necesite.
 * Proporciona además un método para verificar si la conexión sigue activa.
 */
/**
 *
 * @author Dylan
 */

public class ClienteConexion {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    /**
     * Establece la conexión con el servidor utilizando la dirección y puerto
     * especificados. 
     * 
     * Inicializa los flujos de salida y entrada necesarios para enviar
     * y recibir objetos serializados.
     *
     * @param host   dirección del servidor al que se desea conectar
     * @param puerto puerto donde el servidor está escuchando
     * @throws Exception si ocurre algún error al intentar conectarse
     */
    public ClienteConexion(String host, int puerto) throws Exception {
        socket = new Socket(host, puerto);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Envía un objeto {@code Voto} al servidor y espera una respuesta.
     *
     * El servidor debe responder con un mensaje en forma de {@code String}.
     * Si ocurre un error en el proceso, se devuelve un mensaje indicando
     * el problema.
     *
     * @param voto el objeto de tipo {@code Voto} que será enviado al servidor
     * @return texto devuelto por el servidor tras procesar el voto
     */
    public String enviarVoto(Voto voto) {
        try {
            out.writeObject(voto);
            out.flush();
            Object r = in.readObject();
            return r == null ? "Respuesta nula del servidor" : r.toString();
        } catch (Exception e) {
            return "Error al enviar el voto: " + e.getMessage();
        }
    }

    /**
     * Cierra el socket y sus flujos asociados.
     * 
     * Cada cierre se intenta de manera independiente para evitar que un error
     * impida cerrar los demás recursos.
     */
    public void cerrar() {
        try { if (out != null) out.close(); } catch (Exception ignored) {}
        try { if (in != null) in.close(); } catch (Exception ignored) {}
        try { if (socket != null) socket.close(); } catch (Exception ignored) {}
    }

    /**
     * Indica si la conexión con el servidor sigue activa.
     *
     * @return {@code true} si el socket está conectado y no ha sido cerrado,
     *         {@code false} en caso contrario
     */
    public boolean isAlive() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }
}
