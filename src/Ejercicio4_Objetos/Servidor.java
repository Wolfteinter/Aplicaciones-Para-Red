/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4_Objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author wolfteinter
 */
public class Servidor {
    
    public static void main(String args[]){
        try {
            ServerSocket servidor = new ServerSocket(5500);
            Socket cliente = servidor.accept();
            ObjectOutputStream envio = new ObjectOutputStream(cliente.getOutputStream());
            Empleado e = new Empleado("Onder","Colinas del padre");
            envio.writeObject(e);
            System.out.println("Se envio el empleado");
            envio.close();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
}
