package edu.eci.pdsw.services;

public class ExcepcionServiciosSuscripciones extends Exception {

    public ExcepcionServiciosSuscripciones() {
    }

    public ExcepcionServiciosSuscripciones(String message) {
        super(message);
    }

    public ExcepcionServiciosSuscripciones(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionServiciosSuscripciones(Throwable cause) {
        super(cause);
    }
    
}
