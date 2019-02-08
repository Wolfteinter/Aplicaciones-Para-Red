/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wolfteinter
 */
public class Servidor {
    private ServerSocket servidor;
    private Socket cliente;
    private int puerto;
    private DataInputStream entrada;
    private DataOutputStream salida;
    public Servidor(int puerto){
        String respuesta="";
        try {
            //Se instancia el servidor
            servidor = new ServerSocket(puerto);
            cliente = servidor.accept();
            entrada = new DataInputStream(cliente.getInputStream());
            //Se lee la respuesta del cliente
            respuesta = entrada.readUTF();
            salida = new DataOutputStream(cliente.getOutputStream());
            //Se retorna el mensaje
            salida.writeUTF("Servidor responde : "+respuesta);
            servidor.close();
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    public static void main(String args[]){
        Servidor st = new Servidor(5500);
    }
}
