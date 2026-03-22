/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientevotacion;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa un voto emitido desde el cliente.
 *
 * Esta clase almacena la información básica del voto: el nombre del votante,
 * la opción seleccionada y la fecha-hora exacta en la que se generó el voto.
 * 
 * Se utiliza para enviar votos de forma serializada hacia el servidor.
 */
/**
 *
 * @author Dylan
 */
public class VotoCliente implements Serializable {

    private String nombre;
    private String opcion;
    private LocalDateTime fechaHora;

    /**
     * Crea un nuevo voto del cliente.
     *
     * @param nombre nombre del votante
     * @param opcion opción seleccionada por el votante
     */
    public VotoCliente(String nombre, String opcion) {
        this.nombre = nombre;
        this.opcion = opcion;
        this.fechaHora = LocalDateTime.now();
    }

    /**
     * Obtiene el nombre del votante.
     *
     * @return nombre del votante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la opción elegida por el usuario.
     *
     * @return opción seleccionada
     */
    public String getOpcion() {
        return opcion;
    }

    /**
     * Devuelve la fecha y hora exacta en que se creó el voto.
     *
     * @return fecha y hora del voto
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Representación legible del voto, útil para mostrar en consola o logs.
     */
    @Override
    public String toString() {
        return "Voto de " + nombre + " - Opción: " + opcion + " - " + fechaHora;
    }
}
