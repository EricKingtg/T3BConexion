/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.controller;

import com.org.t3b.venta.gui.busqueda.VBusqueda;
import com.org.t3b.venta.model.ModeloBusqueda;
import com.org.t3b.venta.utils.ConfigV;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author roberto
 */
public class ControladorBusqueda {
    
    private ConfigV configV;
    private Controlador controlador;
    
    
    public ControladorBusqueda(){
        
    }
    
    public ControladorBusqueda(ConfigV c,Controlador cg){
        this.configV=c; 
        this.controlador=cg;
    }

    public ConfigV getConfigV() {
        return configV;
    }

    public void setConfigV(ConfigV configV) {
        this.configV = configV;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    
    
    
    private void showBusqueda(){
        this.controlador.ocultaVistaActual();
        VBusqueda tmp = new VBusqueda(this.controlador,null);
        this.controlador.agregaVista(tmp, true, false);
        
    }
    
    
    private void salirBusqueda(){
        this.controlador.cierraVista();
        this.controlador.regresaVistaOculta();
    }
    
    
    private void limpiarTabla(JTable tabla){
        int a =tabla.getModel().getRowCount()-1;
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        //System.out.println(“Tabla “+a);
        for(int i=a; i>=0;i--){
            //System.out.println("i "+i);
            model.removeRow(i);
        }
   }
    
    private void insertaTablaBusqueda(ArrayList <HashMap<String,String>> productos){
        VBusqueda tmp = (VBusqueda)this.controlador.getVista();
        DefaultTableModel model = (DefaultTableModel) tmp.gettProductos().getModel();
        limpiarTabla(tmp.gettProductos());
        for (HashMap<String, String> producto : productos) {
            model.addRow(new Object[]{
                producto.get("id_prod"),
                producto.get("codigo_barras"),
                producto.get("desc_art"),
                producto.get("desc_reg"),
                this.controlador.getFormato().redondeaCero(this.controlador.getFormato().formato2Dec(Float.parseFloat(producto.get("precio_venta"))))
                });
        }
        
    }
    
    private void busquedaProducto(String[] p){
        ModeloBusqueda modeloBusqueda = new ModeloBusqueda();
        ArrayList <HashMap<String,String>> productos = new ArrayList <HashMap<String,String>>();
        productos = modeloBusqueda.buscaProducto(p[0]);
        insertaTablaBusqueda(productos);
    }
    
    
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
           
            case "showBusqueda": showBusqueda();break;
            case "salirBusqueda": salirBusqueda();break;
//            case "showCierra": showCierra();break;
            
        }
        
    }
    
    
    private void agregarBusqueda(String [] p){
        salirBusqueda();
        this.controlador.ejecutaAccion("Venta","agregaArticuloICB", p);
    }
    
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
                
                case "busquedaProducto": busquedaProducto(p);break;
                case "agregarBusqueda": agregarBusqueda(p);break;    
            
            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
        }
        
       
        
    }
    
    
}
