/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

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
public class ServidorTelnet {
    private ServerSocket servidor;
    private Socket cliente;
    private int puerto;
    private BufferedReader entrada;
   // private DataInputStream entrada;
    private DataOutputStream salida;
    
    public ServidorTelnet(int puerto){
        this.puerto=puerto;
        try {
            servidor = new ServerSocket(puerto);
            cliente = servidor.accept();
            //entrada = new DataInputStream(cliente.getInputStream());
                String respuesta;
            while(true){
                entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                respuesta = entrada.readLine();
                //salida = new DataOutputStream(cliente.getOutputStream());
                //salida.writeUTF("Que hay");
                if(respuesta .equals("SALIR()")){
                    salida = new DataOutputStream(cliente.getOutputStream());
                    salida.writeUTF("Hasta Pronto...");

                    cliente.close();
                    break;
                }
                System.out.println(respuesta );
            }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]){
        ServidorTelnet st = new ServidorTelnet(5500);
    }
}
