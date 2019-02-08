/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author wolfteinter
 */

//127.0.0.1 "ya te uniste al puerto 6789"
public class Cliente {
    private static boolean validarIP(String IP){
        boolean resultado=true;
        
        for(int i = 0;i<IP.length();i++){
            if(!esNumero(""+IP.charAt(i))){
                if(IP.charAt(i)!=46){
                    return false;
                }
            }
        }
        
        String octetos[]=IP.split("\\.");
        if(octetos.length==4){
            for(String x:octetos)
                if(!esNumero(x) || !(Integer.parseInt(x)>=0) || !(Integer.parseInt(x)<=255))
                    resultado=false;
        }else{
            resultado=false;
        }
        if(resultado==false)
            System.out.println("IP no valida");
        return resultado;
    }
    private static boolean validarPuerto(String puerto){
        int puertoInt = Integer.parseInt(puerto);
        if(puertoInt>1024 && puertoInt<65635)
            return true;
        System.out.println("Puerto no valido");
        return false;                
    }
    private static boolean esNumero(String cadena){
        boolean resultado;
        try{
            Integer.parseInt(cadena);
            resultado=true;
        }catch(NumberFormatException ex){
            resultado=false;
        }
        return resultado;
    }
    private static ArrayList<String> compararEjecicion(String[] args) {
       ArrayList<String> ejecucion = new ArrayList<String>();
       //Creamos una super cadena
      
       if(args.length==2){
           if(validarIP(args[0])){
               ejecucion.add(args[0]);
               ejecucion.add(args[1]);
               ejecucion.add("5500");
           }else{
               ejecucion.add("False");
           }
       }
       else if(args.length==3){
           if(validarIP(args[0]) && validarPuerto(args[2])){
               ejecucion.add(args[0]);
               ejecucion.add(args[1]);
               ejecucion.add(args[2]);
           }else{
               ejecucion.add("False");
           }
           
       }
       else{
          ejecucion.add("False");
       }
       return ejecucion;
    }
  
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket cliente;
    public Cliente(String ip, String mensaje,String puerto){
        try {
            cliente = new Socket(ip,Integer.parseInt(puerto));
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(mensaje);
            
            //Resivir mesaje del servidor
            entrada = new DataInputStream(cliente.getInputStream());
            System.out.println(entrada.readUTF());
            
            cliente.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        } 
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void main(String args[]){
        ArrayList<String> ejecucion=compararEjecicion(args);
        //System.out.println(ejecucion);
       if(!(ejecucion.get(0).equals("False"))){
          Cliente s = new Cliente(ejecucion.get(0),ejecucion.get(1),ejecucion.get(2)); 
       }else{
           System.out.println("La expresion es incorrecta");
       }
       // 
    }
}
