/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.examen;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
class Voucher implements Serializable {
    boolean confirmado;
    String codigoCompra;
    String motivo;
    double montoUSD;

    public Voucher(boolean confirmado, String codigoCompra, String motivo) {
        this.confirmado = confirmado;
        this.codigoCompra = codigoCompra;
        this.motivo = motivo;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getMontoUSD() {
        return montoUSD;
    }

    public void setMontoUSD(double montoUSD) {
        this.montoUSD = montoUSD;
    }

    @Override
    public String toString() {
        return "Voucher{" + "confirmado=" + confirmado + ", codigoCompra=" + codigoCompra + ", motivo=" + motivo + ", montoUSD=" + montoUSD + '}';
    }
    
}
