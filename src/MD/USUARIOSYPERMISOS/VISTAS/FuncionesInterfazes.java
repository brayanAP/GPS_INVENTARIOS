/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.USUARIOSYPERMISOS.VISTAS;

import java.util.ArrayList;


public class FuncionesInterfazes {
    

char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

char[] conjunto = new char[8];
String pass;

public String creaPass(){
for(int i=0;i<8;i++){
int el = (int)(Math.random()*37);
conjunto[i]= (char)elementos[el];
}
return pass = new String(conjunto);
}
    public static void main(String ar[]){
        
    }
}
