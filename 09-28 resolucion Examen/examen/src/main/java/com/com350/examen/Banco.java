/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.examen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Banco extends UnicastRemoteObject
        implements IBanco {

    public Banco() throws RemoteException {
        super();
    }

    @Override
    public Pago Debitar(String pasaporte, double montoUSD) throws RemoteException {

        // Llamar al servidor antifraue (UDP)
        String respuesta = ConsultarAntifraude(pasaporte);
      if (respuesta.equals("bajo"))
      {
          return new Pago(true,"AA3","no tieneriesto");
      }
          return new Pago(false,"","tiene riesgo");
        
    }

    public String ConsultarAntifraude(String pasaporte) {
        int puerto = 6789;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduzca Su nombre");
            String dato = sc.next();
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            String cadena=new String(respuesta.getData());
            // Enviamos la respuesta del servidor a la salida estandar
           

            // Cerramos el socket
            socketUDP.close();
            return cadena;
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return "bajo";
    }

}
