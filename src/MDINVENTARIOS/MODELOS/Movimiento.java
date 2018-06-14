package MDINVENTARIOS.MODELOS;

public class Movimiento {
    private int id_mov;
    private String fec_mov;
    private boolean sta_mov;
    private String obs_mov;
    private int id_per;

    public Movimiento(int id_mov, String fec_mov, boolean sta_mov, String obs_mov, int id_per) {
        this.id_mov = id_mov;
        this.fec_mov = fec_mov;
        this.sta_mov = sta_mov;
        this.obs_mov = obs_mov;
        this.id_per = id_per;
    }//constructor

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public String getFec_mov() {
        return fec_mov;
    }

    public void setFec_mov(String fec_mov) {
        this.fec_mov = fec_mov;
    }

    public boolean getSta_mov() {
        return sta_mov;
    }

    public void setSta_mov(boolean sta_mov) {
        this.sta_mov = sta_mov;
    }

    public String getObs_mov() {
        return obs_mov;
    }

    public void setObs_mov(String obs_mov) {
        this.obs_mov = obs_mov;
    }

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }
    
}//class
