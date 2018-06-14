package MDINVENTARIOS.CONTROLADORES;
import MDINVENTARIOS.MODELOS.*;
import VALIDACIONES.VALMODINVENTARIOS;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MDINVENTARIOS extends BDDInventarios {
    
    public String nuevoProducto(Producto producto){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionProducto(producto);
        
        if (validacion.equals("OK")){
            String insert =this.insertProducto(producto);
            if(insert.equals("OK"))respuesta+="Producto guardado con éxito.";
            else respuesta = insert;
        }else{
            respuesta = validacion;
        }    
        return respuesta;
    }//nuevoProducto()
    
    public String modificarProducto(Producto producto){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionProducto(producto);
        
        if (validacion.equals("OK")){
            String update =this.updateProducto(producto);
            if(update.equals("OK"))respuesta+="Producto modificado con éxito.";
            else respuesta = update;
        }else{
            respuesta = validacion;
        }    
        return respuesta;
    }//modificarProducto()
   
    public String nuevoMovimiento(Movimiento movimiento){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionMovimiento(movimiento);
        
        if (validacion.equals("OK")){
            String insert =this.insertMovimiento(movimiento);
            if(insert.equals("OK"))respuesta+="Movimiento guardado con éxito.";
            else respuesta = insert;
        }else{
            respuesta = validacion;
        }   
        
        return respuesta;
    }//nuevoMovimiento()
    
    public String nuevaAsignacion(Asignacion asignacion){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionAsignacion(asignacion);
        
        if (validacion.equals("OK")){
            String insert =this.insertAsignacion(asignacion);
            if(insert.equals("OK"))respuesta+="Asignación guardada con éxito.";
            else respuesta = insert;
        }else{
            respuesta = validacion;
        }   
        
        return respuesta;
    }//nuevoAsignacion()

    public String nuevaClasificacion(Clasificacion clasificacion){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionClasificacion(clasificacion);
        
        if (validacion.equals("OK")){
            String insert =this.insertClasificacion(clasificacion);
            if(insert.equals("OK"))respuesta+="Clasificación guardada con éxito.";
            else respuesta = insert;
        }else{
            respuesta = validacion;
        }  
        
        return respuesta;
    }//nuevaClasificacion()
    
    public String modificarClasificacion(Clasificacion clasificacion){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionClasificacion(clasificacion);
        
        if (validacion.equals("OK")){
            String update = this.updateClasificacion(clasificacion);
            if(update.equals("OK"))respuesta+="Clasificación modificada con éxito.";
            else respuesta = update;
        }else{
            respuesta = validacion;
        }  
        
        return respuesta;
    }//modificarClasificacion()
    
    public String nuevaFoto(Foto foto, String ruta){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        String validacion = val.validacionFoto(foto);
        
        if (validacion.equals("OK")){
            String insert =this.insertFoto(foto, ruta);
            if(insert.equals("OK"))respuesta+="Imagen guardada con éxito.";
            else respuesta = insert;
        }else{
            respuesta = validacion;
        }  
        
        return respuesta;
    }//nuevaFoto()
    
    
    public String modificarFoto(String ruta, int id_pro){
        VALMODINVENTARIOS val = new VALMODINVENTARIOS();
        String respuesta = "";
        
        String insert =this.updateFoto(ruta, id_pro);
        if(insert.equals("OK"))respuesta+="Imagen modificada con éxito.";
        else respuesta = insert; 
        
        return respuesta;
    }//nuevaFoto()
    
    public static boolean validarFechaFormato(String fecha) {

        try {

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");

            formatoFecha.setLenient(false);

            formatoFecha.parse(fecha);

        } catch (ParseException e) {

            return false;

        }

        return true;

    }//validarFecha(String fecha) 

}//class
