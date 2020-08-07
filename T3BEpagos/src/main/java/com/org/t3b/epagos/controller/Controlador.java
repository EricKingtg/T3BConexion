/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.epagos.controller;

import com.org.t3b.core.controller.ControladorG;
import com.org.t3b.epagos.utils.Config;

import java.util.HashMap;
import javax.swing.JDesktopPane;

/**
 *
 * @author roberto
 */
public class Controlador extends ControladorG {
    
    
    ControladorTA controladorTA=new ControladorTA();
    ControladorPDS controladorPDS=new ControladorPDS();
    Config config = new Config();
    
    
    public Controlador(){
        creaSubControladores();
    }
    
    public Controlador(com.org.t3b.core.utils.Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
        creaConfig();
        creaSubControladores();
        
    }
    
    
    private void creaConfig(){
        config = new Config();
    }
    
    private void creaSubControladores(){
        
        controladorTA =  new ControladorTA(this.getContGeneral().getConfig(),this.getContGeneral().getEscritorio(),this.getContGeneral());
        controladorPDS =  new ControladorPDS(this.getContGeneral().getConfig(),this.getContGeneral().getEscritorio(),this.getContGeneral());
        
        
    }
    
    
    
    public void ejecutaAccion(String controlador,String accion,HashMap<String, Object> p){
        
        System.out.println("Entro en 1");
        
    }
    
    
    public void ejecutaAccion(String controlador,String accion,String [] p){
        System.out.println("Entro en 2");
        switch(controlador){
            case "showTA": controladorTA.ejecutaAccion(accion,p);
            case "showPDS": controladorPDS.ejecutaAccion(accion,p);
            
        }
    }
    
    
    public void ejecutaAccion(String controlador,String accion){
        System.out.println("Entro en 3");
        switch(controlador){
            case "showTA": controladorTA.ejecutaAccion(accion);
            case "showPDS": controladorPDS.ejecutaAccion(accion);    
            
            
        }
        
    }
    
    
    public void ejecutaAccion(String accion){
        System.out.println("Entro en 4");
        switch(accion){
            //case "showPantallaPrincipal": showPantallaPrincipal();break;
            
            
        }
        
    }
    
    public void ejecutaAccion(String accion,String [] p){
            System.out.println("Entro en 5");
            switch(accion){
                case "showTA": controladorTA.ejecutaAccion(accion);
                //case "showPantallaPrincipal": showPantallaPrincipal();break;


            }
           
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        System.out.println("Entro en 6");
        switch(accion){
            
        }
        
       
        
    }
    
    
}
