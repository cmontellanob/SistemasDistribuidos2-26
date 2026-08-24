/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.com350.suma;

/**
 *
 * @author Dell
 */
import java.rmi.*;

public interface InterfazSuma
        extends Remote {
    int sumar(int a, int b)  throws RemoteException;
}

