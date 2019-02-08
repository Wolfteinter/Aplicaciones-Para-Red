/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3_Archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wolfteinter
 */
public class Servidor {
    public static void main(String args[]){
        try {
            ServerSocket servidor =  new ServerSocket(5500);
            Socket cliente = servidor.accept();
            InputStream llegada = cliente.getInputStream();
            FileOutputStream destino = new FileOutputStream("copia_video.jpg");
            byte[] buffer = new byte[1024];
            int len=0;
            while((len = llegada.read(buffer)) > 0)
                destino.write(buffer,0,len);
            destino.close();
            llegada.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
