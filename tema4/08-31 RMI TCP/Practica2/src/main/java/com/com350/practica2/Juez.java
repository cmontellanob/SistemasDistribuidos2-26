/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.practica2;

/**
 *
 * @author Dell
 */
import java.rmi.registry.*;

public class Juez {
  public static void main(String[] a) throws Exception {
    Registry reg = LocateRegistry.getRegistry(1099);
    IJusticia j = (IJusticia) reg.lookup("Justicia");
    
    
  }
}
