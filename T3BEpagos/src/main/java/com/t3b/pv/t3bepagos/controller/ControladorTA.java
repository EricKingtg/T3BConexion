/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bepagos.controller;

import com.t3b.pv.t3bcore.controller.ControladorG;
import com.t3b.pv.t3bepagos.controller.model.Modelo;
import com.t3b.pv.t3bepagos.gui.main.TA;
import com.t3b.pv.t3bepagos.gui.main.ta.ProductosTA;
import com.t3b.pv.t3bepagos.utils.Config;
import com.t3b.pv.t3bepagos.utils.messages.IMsgTA;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 */
public class ControladorTA extends ControladorG {
    
    TA ta = new TA();
    ProductosTA pTA = new ProductosTA();
    Config config = new Config();
    
    public ControladorTA(){
        //creaSubControladores();
    }
    
    public ControladorTA(com.t3b.pv.t3bcore.utils.Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
        creaConfig();
        //creaSubControladores();
        
    }

    private void creaConfig(){
        config = new Config();
    }
    
    
    private void showTA(){
        
        TA tmp = new TA(this);
        this.agregaVista(tmp, true, false);
        ta=tmp;
        
    }
    
    private void showProductosTA(ArrayList <HashMap<String,String>> productos){
        
        ProductosTA tmp = new ProductosTA(this);
        tmp.setProductos(productos);
        tmp.agregaProductos();
        this.agregaVista(tmp, true, false);
        pTA=tmp;
        tmp.setVisible(true);
        
    }
    
    private void consultaProductos(HashMap<String, Object> p){
        ArrayList <HashMap<String,String>> productos = null;
        Modelo modelo =  new Modelo();
        productos=modelo.consultaProductosTA(p.get("marca").toString());
        
        if(productos.size()>0) {
            //JOptionPane.showMessageDialog(null,"Productos encontrados");
            HashMap<String,Object> temporal = new HashMap<>();
            temporal.put("productos", productos);
            JInternalFrame tmp =(JInternalFrame) p.get("ventana");
            tmp.setVisible(false);
            this.ejecutaAccion("showProductosTA", temporal);
            
            
        }else {
            
            JOptionPane.showMessageDialog(null,IMsgTA.CONSULTA_PRODUCTOS_TA);
        }
        
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
            //case "consultaProductos":consultaProductos(accion);break;
            
            
        }
        
    }
    
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
            
            case "showTA": showTA();break;
            
            
            
        }
        
    }
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
            
                //case "consultaProductos":consultaProductos(p[0]);break;


            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
            case "consultaProductos":consultaProductos(p);break;
            case "showProductosTA":showProductosTA((ArrayList <HashMap<String,String>>)p.get("productos"));break;    
        }
        
       
        
    }
    
}
