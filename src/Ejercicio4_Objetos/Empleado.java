/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4_Objetos;

import java.io.Serializable;

/**
 *
 * @author wolfteinter
 */
public class Empleado implements Serializable{
    private String nombre;
    private String direccion;
    private long telefono;
    private String mail;
    private long ss;
    private String curp;

    public Empleado(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = 49267642;
        this.mail = "default@def.utt";
        this.ss =  423432887;
        this.curp = "HHY7HJ9JY7JY7";
        
    }
    public Empleado(String nombre, String direccion, long telefono, String mail, long ss, String curp) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.ss = ss;
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getSs() {
        return ss;
    }

    public void setSs(long ss) {
        this.ss = ss;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "[" + "nombre= " + nombre + "\n direccion= " + direccion + "\n telefono= " + telefono + "\n mail= " + mail + 
                "\n ss= " + ss + "\n curp= " + curp + "]\n";
    }

    
    
    
}
