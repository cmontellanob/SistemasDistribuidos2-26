/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.com350.examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class Operadora extends UnicastRemoteObject
        implements IOperadora {

    public Operadora() throws RemoteException {
        super();
    }

    @Override
    public Voucher ComprarTour(String pasaporte, String codigoTour, int personas) {

        // llamar a migracion
        String migracion = consultarMgiracion("passapote:" + pasaporte);
        double precio = 0f;
        String[] respuesta = migracion.split(":");
        if (respuesta[1].equals("Valido")) {
            if (respuesta[1].equals("BOLIVIA")) {
                precio = personas * 180 * .5f;
            } else {
                precio = personas * 180;
            }
            /// Llamar a Banco
        ///
        ///
        try {
                Registry reg = LocateRegistry.getRegistry(1099);

                IBanco banco = (IBanco) reg.lookup("Banco");
                if (banco.Debitar(pasaporte, precio).isAprobado()) {
                    return new Voucher(true, "C-001", "");
                } else {
                    return new Voucher(false, "", "No aprobad el credito");
                }
            } catch (RemoteException ex) {
                System.getLogger(Operadora.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (NotBoundException ex) {
                System.getLogger(Operadora.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return new Voucher(false, "", "Passapote invalido");
    }

    public String consultarMgiracion(String pasaporte) {
        try {
            int port = 5002;
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            toServer.println("pasaporte:" + pasaporte);
            String result = fromServer.readLine();
            return result;

        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        return "";
    }

}
