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

public class ClienteSuma {
  public static void main(String[] a) throws Exception {
    Registry reg = LocateRegistry.getRegistry(1099);
    InterfazSuma s = (InterfazSuma) reg.lookup("Suma");
    
    System.out.println(s.sumar(7, 5));  // 12
  }
}
