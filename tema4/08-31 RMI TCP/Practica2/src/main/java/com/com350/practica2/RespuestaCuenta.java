/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.practica2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
class RespuestaCuenta implements Serializable {
    boolean error;
    String mensaje;
    ArrayList<Cuenta> cuentas;

    public RespuestaCuenta() {
        this.error = false;
        this.mensaje = "";
        this.cuentas=new ArrayList<Cuenta>();
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void addCuenta(Cuenta cuenta){
        this.cuentas.add(cuenta);
    }
    

}
