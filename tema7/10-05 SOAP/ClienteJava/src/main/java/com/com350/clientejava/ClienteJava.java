/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.com350.clientejava;


 
/**
 *
 * @author Dell
 */
public class ClienteJava {

    public static void main(String[] args) {
        
     WsOperaciones service = new WsOperaciones();

WsOperacionesSoap port =
        service.getWsOperacionesSoap12();

int result = port.sumar(10, 20);

System.out.println("Result = " + result);
 
    }
    
    
    
}
