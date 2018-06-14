package MDINVENTARIOS.MODELOS;

public class Asignacion {
    private int id_asi;
    private int id_mov;
    private int id_pro;
    private int can_asi;

    public Asignacion(int id_asi, int id_mov, int id_pro, int can_asi) {
        this.id_asi = id_asi;
        this.id_mov = id_mov;
        this.id_pro = id_pro;
        this.can_asi = can_asi;
    }//constructor

    public int getId_asi() {
        return id_asi;
    }

    public void setId_asi(int id_asi) {
        this.id_asi = id_asi;
    }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getCan_asi() {
        return can_asi;
    }

    public void setCan_asi(int can_asi) {
        this.can_asi = can_asi;
    }
    
}//class
