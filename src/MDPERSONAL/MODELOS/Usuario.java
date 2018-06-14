package MDPERSONAL.MODELOS;

public class Usuario {
    private int id_usu;
    private String nom_usu;
    private String con_usu;
    private int id_per;
    private int id_tip;

    public Usuario(String nom_usu, String con_usu, int id_per, int id_tip) {
       
        this.nom_usu = nom_usu;
        this.con_usu = con_usu;
        this.id_per = id_per;
        this.id_tip = id_tip;
    }//construtor

    public Usuario(String usuario, String contraseña, int permiso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getCon_usu() {
        return con_usu;
    }

    public void setCon_usu(String con_usu) {
        this.con_usu = con_usu;
    }

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }
    
}//class
