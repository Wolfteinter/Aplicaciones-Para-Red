/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4_Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;



/**
 *
 * @author wolfteinter
 */
public class Cliente {
    public static void main(String args[]){
        try {
            Socket cliente = new Socket("127.0.0.1",5500);
            ObjectInputStream llegada = new ObjectInputStream(cliente.getInputStream());
    
            Empleado e = (Empleado) llegada.readObject();
            System.out.println("El empleado es : "+e.toString());
            llegada.close();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
}
