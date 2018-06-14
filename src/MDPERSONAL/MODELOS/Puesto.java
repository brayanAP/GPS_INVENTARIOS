package MDPERSONAL.MODELOS;

public class Puesto {
    private int id_pue;
    private String fol_pue;
    private String nom_pue;
    private double sal_pue;

    public Puesto(String fol_pue, String nom_pue, double sal_pue) {
        this.fol_pue = fol_pue;
        this.nom_pue = nom_pue;
        this.sal_pue = sal_pue;
    }//construtor

    public int getId_pue() {
        return id_pue;
    }

    public void setId_pue(int id_pue) {
        this.id_pue = id_pue;
    }

    public String getFol_pue() {
        return fol_pue;
    }

    public void setFol_pue(String fol_pue) {
        this.fol_pue = fol_pue;
    }

    public String getNom_pue() {
        return nom_pue;
    }

    public void setNom_pue(String nom_pue) {
        this.nom_pue = nom_pue;
    }

    public double getSal_pue() {
        return sal_pue;
    }

    public void setSal_pue(double sal_pue) {
        this.sal_pue = sal_pue;
    }
    
}//class
