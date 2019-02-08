/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author wolfteinter
 */
public class Servidor {
    private int puerto = 5000;
    private ServerSocket servidor;
    private Socket cliente; 
    private DataInputStream entrada;
    private DataOutputStream salida;
    public Servidor(){
        try {
            servidor = new ServerSocket(puerto);
            while(true){
                cliente = servidor.accept();
            
                entrada = new DataInputStream(cliente.getInputStream());
                salida = new DataOutputStream(cliente.getOutputStream());
                
                //Mostrar lo que manda el cliente
                String clienteIP = cliente.getInetAddress().getHostAddress();
                int clientePort = cliente.getPort();
                System.out.println(clienteIP+":"+clientePort+" dice>> "+entrada.readUTF());
                //Enviar mensaje al cliente
                salida.writeUTF("Mensaje resivido......Que onda");

                //Cierro la conexion del cliente
                cliente.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    public static void main(String args[]){
        Servidor s = new Servidor();
    }
}

