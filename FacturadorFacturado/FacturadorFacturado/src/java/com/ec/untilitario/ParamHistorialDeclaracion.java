/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.untilitario;

import com.ec.entidad.HistorialDeclaraciones;
import com.ec.entidad.Tipoambiente;

/**
 *
 * @author Darwin
 */
public class ParamHistorialDeclaracion {

    private HistorialDeclaraciones declaraciones;
    private String accion;
    private Tipoambiente tipoambiente;

    public ParamHistorialDeclaracion(HistorialDeclaraciones declaraciones, String accion) {
        this.declaraciones = declaraciones;
        this.accion = accion;
    }

    public ParamHistorialDeclaracion(String accion) {
        this.accion = accion;
    }

    public HistorialDeclaraciones getDeclaraciones() {
        return declaraciones;
    }

    public void setDeclaraciones(HistorialDeclaraciones declaraciones) {
        this.declaraciones = declaraciones;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Tipoambiente getTipoambiente() {
        return tipoambiente;
    }

    public void setTipoambiente(Tipoambiente tipoambiente) {
        this.tipoambiente = tipoambiente;
    }

}
