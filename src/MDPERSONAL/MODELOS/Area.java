package MDPERSONAL.MODELOS;

public class Area {
    private int id_are;
    private String nom_are;
    private String des_are;

    public Area(String nom_are, String des_are) {
    
        this.nom_are = nom_are;
        this.des_are = des_are;
    }//constructor

    public int getId_are() {
        return id_are;
    }

    public void setId_are(int id_are) {
        this.id_are = id_are;
    }

    public String getNom_are() {
        return nom_are;
    }

    public void setNom_are(String nom_are) {
        this.nom_are = nom_are;
    }

    public String getDes_are() {
        return des_are;
    }

    public void setDes_are(String des_are) {
        this.des_are = des_are;
    }
    
}//class
