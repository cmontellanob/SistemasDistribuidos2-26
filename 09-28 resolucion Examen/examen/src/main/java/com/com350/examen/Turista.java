/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.examen;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dell
 */
public class Turista {

    public static void main(String[] a) throws Exception {

        Registry reg = LocateRegistry.getRegistry(1099);
        IOperadora operadora = (IOperadora) reg.lookup("operadora");

        System.out.println(operadora.ComprarTour("123", "T1", 3));  // 12

    }
}
