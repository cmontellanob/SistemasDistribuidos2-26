/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.com350.examen;

/**
 *
 * @author Dell
 */
import java.rmi.*;
public interface IOperadora extends Remote {
  public  Voucher ComprarTour(String pasaporte, String codigoTour, int personas) throws RemoteException;
}
