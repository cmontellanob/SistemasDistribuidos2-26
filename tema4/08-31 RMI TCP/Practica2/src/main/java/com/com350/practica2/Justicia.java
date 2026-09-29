/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.practica2;

/**
 *
 * @author Dell
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.*;

public class Justicia extends UnicastRemoteObject
        implements IJusticia {

    public Justicia() throws RemoteException {
        super();
    }

    @Override
    public RespuestaCuenta ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        RespuestaCuenta aux = new RespuestaCuenta();
        String cuentasBCP = CosultarBCP(ci);
        // convertirla respuesta en un arreglo de cuentas si es que tiene
        String cuentasMercantil = ConsultarMercantil(ci);
        // converit la respuesta en un aregla de cuentas si es que tiene
        //construir la respuesta
        return aux;
    }

    @Override
    public boolean Congelar(Cuenta cuenta, Double monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String CosultarBCP(String ci) {
        int puerto = 6789;

        try {
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = ci.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, ci.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println("Respuesta: " + new String(respuesta.getData()));

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return "";
    }

    String ConsultarMercantil(String ci) {

        return "";
    }
}
