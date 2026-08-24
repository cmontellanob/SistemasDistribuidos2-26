/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.suma;

/**
 *
 * @author Dell
 */
import java.rmi.RemoteException;
import java.rmi.server.*;

public class ClaseSuma extends UnicastRemoteObject
        implements InterfazSuma {

    public ClaseSuma() throws RemoteException {
        super();
    }

    public int sumar(int a, int b) {
        return a + b;
    }
}
