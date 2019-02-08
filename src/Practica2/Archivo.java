/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author wolfteinter
 */
public class Archivo implements Serializable{
    String nombre;
    InputStream llegada;

    public Archivo(String nombre, InputStream llegada) {
        this.nombre = nombre;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getLlegada() {
        return llegada;
    }

    public void setLlegada(InputStream llegada) {
        this.llegada = llegada;
    }
    
    
    
    
    
}
