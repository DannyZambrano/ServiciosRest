package com.app.persona.bci.exeption;

import java.util.Calendar;
import java.util.Map;

public class ExceptionResponse {

    private Calendar fecha;
    private String mensaje;
    private String detalles;
    private Map<String, String> erroresValidacion;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Calendar fecha, String mensaje, String detalles) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }


    public ExceptionResponse(Calendar fecha, String mensaje, String detalles, Map<String, String> erroresValidacion) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.erroresValidacion = erroresValidacion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Map<String, String> getErroresValidacion() {
        return erroresValidacion;
    }

    public void setErroresValidacion(Map<String, String> erroresValidacion) {
        this.erroresValidacion = erroresValidacion;
    }
}
