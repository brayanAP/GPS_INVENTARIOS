package MDINVENTARIOS.MODELOS;

import java.awt.Image;

public class Foto {
    private int id_fot;
    private Image fot_fot;
    private int id_pro;

    public Foto(int id_fot, Image fot_fot, int id_pro) {
        this.id_fot = id_fot;
        this.fot_fot = fot_fot;
        this.id_pro = id_pro;
    }

    public int getId_fot() {
        return id_fot;
    }

    public void setId_fot(int id_fot) {
        this.id_fot = id_fot;
    }

    public Image getFot_fot() {
        return fot_fot;
    }

    public void setFot_fot(Image fot_fot) {
        this.fot_fot = fot_fot;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }
   
}
