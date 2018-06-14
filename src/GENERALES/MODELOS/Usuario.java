/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GENERALES.MODELOS;

/**
 *
 * @author juanramon
 */
public class Usuario {
    String nombre;
    String pass;
    int id_tip;

    public Usuario(String nombre,String pass,int id_tip) {
        this.nombre = nombre;
        this.pass = pass;
        this.id_tip = id_tip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }
    
}
