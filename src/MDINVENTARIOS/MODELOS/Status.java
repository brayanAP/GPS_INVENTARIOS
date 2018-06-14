package MDINVENTARIOS.MODELOS;

public class Status {
    private int id_sta;
    private String nom_sta;

    public Status(int id_sta, String nom_sta) {
        this.id_sta = id_sta;
        this.nom_sta = nom_sta;
    }//constructor

    public int getId_sta() {
        return id_sta;
    }

    public void setId_sta(int id_sta) {
        this.id_sta = id_sta;
    }

    public String getNom_sta() {
        return nom_sta;
    }

    public void setNom_sta(String nom_sta) {
        this.nom_sta = nom_sta;
    }
    
}//class
