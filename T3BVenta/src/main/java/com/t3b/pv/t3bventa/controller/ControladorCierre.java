/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.controller;

import com.t3b.pv.t3bventa.gui.cierre.VCierre;
import com.t3b.pv.t3bventa.gui.cierre.VEfectivo;
import com.t3b.pv.t3bventa.gui.cierre.VEvale;
import com.t3b.pv.t3bventa.gui.cierre.VTarjetaCredito;
import com.t3b.pv.t3bventa.gui.cierre.VVales;
import com.t3b.pv.t3bventa.model.ModeloCierre;
import com.t3b.pv.t3bventa.utils.ConfigV;
import com.t3b.pv.t3bventa.utils.Validador;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author roberto
 */
public class ControladorCierre {
    
    private ConfigV configV;
    private Controlador controlador;
    private Validador validador;
    
    public ControladorCierre(){
        
    }
    
    public ControladorCierre(ConfigV c,Controlador cg){
        this.configV=c; 
        this.controlador=cg;
        validador = new Validador();
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
    
    
    
    
    
    private void cargaInformacionCV(){
        
        ArrayList <HashMap<String,String>> formasPago;
        ModeloCierre modeloCierre =  new ModeloCierre();
        int i=0;
       
        VCierre tmp = this.controlador.getvCierre();
        
        JTable fp = tmp.gettFormasPago();
        DefaultTableModel model = (DefaultTableModel) fp.getModel();
        System.out.println("Total: "+configV.getCar().getTotal());
        tmp.getlTotal().setText("$ "+this.getControlador().getFormato().redondeaCero(this.getControlador().getFormato().formato2Dec(configV.getCar().getTotal())));
        formasPago=modeloCierre.buscaFormasPago();
       
            
        
       
        for(i=0;i<formasPago.size();i++){
            
            model.addRow(new Object[]{formasPago.get(i).get("fp_clave"),
                new JButton(formasPago.get(i).get("fp_desc").toString()+" | "+formasPago.get(i).get("fp_clave").toString()),
                "0.00",""});
            formasPago.get(i).put("valor","0");
        }
        
 
       
       configV.setFormasPago(formasPago);
       
    }
    
    
    private void setValidador(VCierre tmp){
        validador.setConfigV(configV);
        validador.setTotal(tmp.getlTotal());
        validador.setPagado(tmp.getLimportePagado());
        validador.setCambio(tmp.getLcambio());
        validador.setTotalf(configV.getCar().getTotal());
        validador.setbF1(tmp.getbF1());
        validador.setPagos(tmp.gettFormasPago());
    }
    
    
    private void showCierraVenta(){
        this.controlador.ocultaVistaActual();
        VCierre tmp = new VCierre(this.controlador,null);
        setValidador(tmp);
        tmp.setValidador(validador);
        this.controlador.agregaVista(tmp, true, false);
        this.controlador.setvCierre(tmp);
        cargaInformacionCV();
        
    }
    
     private void salirCierre(){
        this.controlador.cierraVista();
        this.controlador.regresaVistaOculta();
    }
     
    private void showEfectivo(){
        VEfectivo tmp = new VEfectivo(this.controlador,this.controlador.getvCierre(),validador);
        this.controlador.agregaVistaTemporal(tmp, true, false);
    } 
    
    private void showVales(){
        VVales tmp = new VVales(this.controlador,this.controlador.getvCierre(),validador);
        this.controlador.agregaVistaTemporal(tmp, true, false);
    } 
    
    private void showEvale(){
        VEvale tmp = new VEvale();
        this.controlador.agregaVistaTemporal(tmp, true, false);
    } 
    private void showTarjetaCredito(){
        VTarjetaCredito tmp = new VTarjetaCredito();
        this.controlador.agregaVistaTemporal(tmp, true, false);
    } 
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
            
            case "showCierraVenta": showCierraVenta();break;
            case "showEfectivo": showEfectivo();break;
            case "showVales": showVales();break;
            case "showEvale": showEvale();break;
            case "showTarjetaCredito": showTarjetaCredito();break;
            case "salirCierre": salirCierre();break;

                
            
        }
        
    }
    
    
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
//               case "agregaArticuloICB": agregaArticuloICB(p);break;
//               case "checarPrecio": checarPrecio(p);break;
                   

            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
        }
        
       
        
    }

    
    
}
