package MDINVENTARIOS.MODELOS;

public class Producto {
    private int id_pro;
    private int con_pro;
    private String subcat_pro;
    private String nom_pro;
    private String des_pro;
    private String mar_pro;
    private String mod_pro;
    private String ser_pro;
    private String col_pro;
    private String pla_pro;
    private String nomot_pro;
    private String fechcompra_pro;
    private String nofact_pro;
    private double imp_pro;
    private String obs_pro;
    private int stock_pro;
    private int stockmin_pro;
    private int km_pro;
    private int km_ser_pro;
    private int id_cla;
    private int id_sta;
    
    private int cantidad;
    private int stock;
    
    public Producto(String nom_pro, String mar_pro, String mod_pro, int cantidad, int stock){
        this.nom_pro = nom_pro;
        this.mar_pro = mar_pro;
        this.mod_pro = mod_pro;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Producto(int id_pro, int con_pro, String subcat_pro, String nom_pro, String des_pro, String mar_pro, String mod_pro, String ser_pro, String col_pro, String pla_pro, String nomot_pro, String fechcompra_pro, String nofact_pro, double imp_pro, String obs_pro, int stock_pro, int stockmin_pro, int km_pro, int km_ser_pro, int id_cla, int id_sta) {
        this.id_pro = id_pro;
        this.con_pro = con_pro;
        this.subcat_pro = subcat_pro;
        this.nom_pro = nom_pro;
        this.des_pro = des_pro;
        this.mar_pro = mar_pro;
        this.mod_pro = mod_pro;
        this.ser_pro = ser_pro;
        this.col_pro = col_pro;
        this.pla_pro = pla_pro;
        this.nomot_pro = nomot_pro;
        this.fechcompra_pro = fechcompra_pro;
        this.nofact_pro = nofact_pro;
        this.imp_pro = imp_pro;
        this.obs_pro = obs_pro;
        this.stock_pro = stock_pro;
        this.stockmin_pro = stockmin_pro;
        this.km_pro = km_pro;
        this.km_ser_pro = km_ser_pro;
        this.id_cla = id_cla;
        this.id_sta = id_sta;
    }//constructor

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getCon_pro() {
        return con_pro;
    }

    public void setCon_pro(int con_pro) {
        this.con_pro = con_pro;
    }

    public String getSubcat_pro() {
        return subcat_pro;
    }

    public void setSubcat_pro(String subcat_pro) {
        this.subcat_pro = subcat_pro;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public String getDes_pro() {
        return des_pro;
    }

    public void setDes_pro(String des_pro) {
        this.des_pro = des_pro;
    }

    public String getMar_pro() {
        return mar_pro;
    }

    public void setMar_pro(String mar_pro) {
        this.mar_pro = mar_pro;
    }

    public String getMod_pro() {
        return mod_pro;
    }

    public void setMod_pro(String mod_pro) {
        this.mod_pro = mod_pro;
    }

    public String getSer_pro() {
        return ser_pro;
    }

    public void setSer_pro(String ser_pro) {
        this.ser_pro = ser_pro;
    }

    public String getCol_pro() {
        return col_pro;
    }

    public void setCol_pro(String col_pro) {
        this.col_pro = col_pro;
    }

    public String getPla_pro() {
        return pla_pro;
    }

    public void setPla_pro(String pla_pro) {
        this.pla_pro = pla_pro;
    }

    public String getNomot_pro() {
        return nomot_pro;
    }

    public void setNomot_pro(String nomot_pro) {
        this.nomot_pro = nomot_pro;
    }

    public String getFechcompra_pro() {
        return fechcompra_pro;
    }

    public void setFechcompra_pro(String fechcompra_pro) {
        this.fechcompra_pro = fechcompra_pro;
    }

    public String getNofact_pro() {
        return nofact_pro;
    }

    public void setNofact_pro(String nofact_pro) {
        this.nofact_pro = nofact_pro;
    }

    public double getImp_pro() {
        return imp_pro;
    }

    public void setImp_pro(double imp_pro) {
        this.imp_pro = imp_pro;
    }

    public String getObs_pro() {
        return obs_pro;
    }

    public void setObs_pro(String obs_pro) {
        this.obs_pro = obs_pro;
    }

    public int getStock_pro() {
        return stock_pro;
    }

    public void setStock_pro(int stock_pro) {
        this.stock_pro = stock_pro;
    }

    public int getStockmin_pro() {
        return stockmin_pro;
    }

    public void setStockmin_pro(int stockmin_pro) {
        this.stockmin_pro = stockmin_pro;
    }

    public int getKm_pro() {
        return km_pro;
    }

    public void setKm_pro(int km_pro) {
        this.km_pro = km_pro;
    }

    public int getKm_ser_pro() {
        return km_ser_pro;
    }

    public void setKm_ser_pro(int km_ser_pro) {
        this.km_ser_pro = km_ser_pro;
    }

    public int getId_cla() {
        return id_cla;
    }

    public void setId_cla(int id_cla) {
        this.id_cla = id_cla;
    }

    public int getId_sta() {
        return id_sta;
    }

    public void setId_sta(int id_sta) {
        this.id_sta = id_sta;
    }
    
}//class
