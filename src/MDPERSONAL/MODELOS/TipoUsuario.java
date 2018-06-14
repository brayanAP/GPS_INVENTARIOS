/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDPERSONAL.MODELOS;

/**
 *
 * @author juanramon
 */
public class TipoUsuario {
    int id_tip=0;
    String nom_tip="";

    public TipoUsuario(String nom_tip) {
        this.nom_tip=nom_tip;
    }

    public String getNom_tip() {
        return nom_tip;
    }

    public void setNom_tip(String nom_tip) {
        this.nom_tip = nom_tip;
    }
  
}
