/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sis258.holatcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Dell
 */
public class Holatcp {

    public static void main(String[] args) {
        try {
            int port = 5002;
            ServerSocket server;
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String recibido = fromClient.readLine();
            System.out.println("El cliente envio el mensaje:" + recibido);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("Hola Mundo desde el Servidor");
        } catch (IOException ex) {
            System.getLogger(Holatcp.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
