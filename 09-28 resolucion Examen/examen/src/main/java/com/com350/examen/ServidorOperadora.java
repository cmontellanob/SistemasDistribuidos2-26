/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.examen;

/**
 *
 * @author Dell
 */
import java.rmi.registry.*;

public class ServidorOperadora {
  public static void main(String[] a) throws Exception {
    Registry reg = LocateRegistry.createRegistry(1098);
    reg.rebind("Operadora", new Operadora());
  }   // el servidor queda a la escucha
}

