/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.GENERALES.VISTAS;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author juanramon
 */
public class Reloj extends javax.swing.JFrame implements Runnable{
String hora,minutos,segundos,ampm;
Calendar calendario;
Thread h1; 
    
    
    
    
    
public void run(JLabel lblHora) {
Thread ct = Thread.currentThread();
h1=new Thread();
h1.start();
while(ct == h1) {
calcula();
lblHora.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
try {
Thread.sleep(1000);
}catch(InterruptedException e) {}
}
    }
    
 public void calcula () {
Calendar calendario = new GregorianCalendar();
Date fechaHoraActual = new Date();

calendario.setTime(fechaHoraActual);
ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
if(ampm.equals("PM")){
int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
hora = h>9?""+h:"0"+h;
}else{
hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); }
minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
}

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
