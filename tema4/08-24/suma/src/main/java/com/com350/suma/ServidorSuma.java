/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.suma;

/**
 *
 * @author Dell
 */
import java.rmi.registry.*;

public class ServidorSuma {
  public static void main(String[] a) throws Exception {
    Registry reg = LocateRegistry.createRegistry(1099);
    reg.rebind("Suma", new ClaseSuma());
  }   // el servidor queda a la escucha
}

