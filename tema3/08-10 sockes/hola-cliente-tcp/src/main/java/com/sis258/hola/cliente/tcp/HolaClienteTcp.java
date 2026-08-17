/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sis258.hola.cliente.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Dell
 */
public class HolaClienteTcp {

    public static void main(String[] args) {
        try {
            int port = 5002;
            Socket client = new Socket("localhost", port);
             PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            toServer.println("Hola Mundo desde el Cliente");
            String result = fromServer.readLine();
            System.out.println("cadena devuelta por el servidor es: " + result);
            
            
        } catch (IOException ex) {
            System.getLogger(HolaClienteTcp.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
          
    }
}
