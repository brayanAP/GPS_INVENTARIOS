package MDINVENTARIOS.MODELOS;

public class Clasificacion {
    private int id_clas;
    private String fol_clas;
    private String nom_clas;
    private boolean stock_clas;

    public Clasificacion(int id_clas, String fol_clas, String nom_clas, boolean stock_clas) {
        this.id_clas = id_clas;
        this.fol_clas = fol_clas;
        this.nom_clas = nom_clas;
        this.stock_clas = stock_clas;
    }//constructor

    public int getId_clas() {
        return id_clas;
    }

    public void setId_clas(int id_clas) {
        this.id_clas = id_clas;
    }

    public String getFol_clas() {
        return fol_clas;
    }

    public void setFol_clas(String fol_clas) {
        this.fol_clas = fol_clas;
    }

    public String getNom_clas() {
        return nom_clas;
    }

    public void setNom_clas(String nom_clas) {
        this.nom_clas = nom_clas;
    }

    public boolean getStock_clas() {
        return stock_clas;
    }

    public void setStock_clas(boolean stock_clas) {
        this.stock_clas = stock_clas;
    }
    
}//class
