/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3_Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wolfteinter
 */
public class Cliente {
    public static void main(String args[]){
        try {
            Socket s = new Socket("127.0.0.1",5500);
            OutputStream os = s.getOutputStream();
            PrintStream envio = new PrintStream(os);
            FileInputStream origen = new FileInputStream("monte.jpg");
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = origen.read(buffer)) > 0)
                envio.write(buffer,0,len);
            origen.close();
            envio.close();
                
            /*
            File f = new File("archivo.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String aux;
            String linea="";
            while((aux=bf.readLine()) != null)linea+=aux+"\n";

            System.out.println(linea);
            bf.close();*/
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
}
