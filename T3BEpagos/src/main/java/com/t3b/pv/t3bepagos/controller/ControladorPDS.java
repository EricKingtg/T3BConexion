/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bepagos.controller;

import com.t3b.pv.t3bcore.controller.ControladorG;
import com.t3b.pv.t3bepagos.utils.Config;
import java.util.HashMap;
import javax.swing.JDesktopPane;

/**
 *
 * @author roberto
 */
public class ControladorPDS extends ControladorG {
    
    Config config = new Config();
    
    public ControladorPDS(){
        //creaSubControladores();
    }
    
    public ControladorPDS(com.t3b.pv.t3bcore.utils.Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
        creaConfig();
        //creaSubControladores();
        
    }

    private void creaConfig(){
        config = new Config();
    }
    
    public void ejecutaAccion(String controlador,String accion,HashMap<String, Object> p){
        
    }
    
    public void ejecutaAccion(String controlador,String accion,String [] p){
        switch(controlador){
            //case "Venta": Controlador.ejecutaAccion(accion,p);
            
        }
    }
    
    
    public void ejecutaAccion(String controlador,String accion){
        
        switch(controlador){
            //case "Busqueda": controladorBusqueda.ejecutaAccion(accion);
            
            
        }
        
    }
    
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
            
            //case "showPantallaPrincipal": showPantallaPrincipal();break;
            
            
        }
        
    }
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
                //case "showPantallaPrincipal": showPantallaPrincipal();break;


            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
        }
        
       
        
    }
    
    
}
