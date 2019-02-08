/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wolfteinter
 */
public class Cliente {
    private String ip = "127.0.0.1";
    private int puerto = 5000;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket cliente;
    public Cliente(){
        try {
            cliente = new Socket(ip,puerto);
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF("Conexion exitosa soy el cliente num : " + (int)(Math.random()*100));
            
            //Resivir mesaje del servidor
            entrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Servidor dice"+ entrada.readUTF());
            
            cliente.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        } 
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void main(String args[]){
        Cliente s = new Cliente();
    }
            
}
