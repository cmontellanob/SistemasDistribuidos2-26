/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.com350.practica2;

/**
 *
 * @author Dell
 */
import java.rmi.*;

public interface IJusticia
        extends Remote {
     RespuestaCuenta ConsultarCuentas (String ci, String nombres, String apellidos) throws RemoteException; 
     boolean Congelar(Cuenta cuenta, Double monto);

}

