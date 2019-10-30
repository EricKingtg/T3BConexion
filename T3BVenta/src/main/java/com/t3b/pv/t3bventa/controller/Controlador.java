/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.controller;

import com.t3b.pv.t3bcore.controller.ControladorG;
import com.t3b.pv.t3bcore.utils.Config;
import com.t3b.pv.t3bventa.gui.busqueda.VBusqueda;
import com.t3b.pv.t3bventa.gui.cierre.VCierre;
import com.t3b.pv.t3bventa.gui.main.VMain;
import com.t3b.pv.t3bventa.gui.main.VMain800;
import com.t3b.pv.t3bventa.utils.ConfigV;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 */
public class Controlador extends ControladorG{
    
    
    //private JInternalFrame vista;
    private ConfigV configV;
    private ControladorBusqueda controladorBusqueda=null;
    private ControladorVenta controladorVenta;
    private ControladorCierre controladorCierre;
    private VMain vMain;
    private VMain800 vMain800;
    private VBusqueda vBusqueda;
    private VCierre vCierre;
    private boolean ifcompartiva=false;
    
    
    
    
    public Controlador(){
        creaSubControladores();
    }
    
    public Controlador(Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
        creaConfig();
        creaSubControladores();
        
    }

    public ConfigV getConfigV() {
        return configV;
    }

    public void setConfigV(ConfigV configV) {
        this.configV = configV;
    }

    public ControladorBusqueda getControladorBusqueda() {
        return controladorBusqueda;
    }

    public void setControladorBusqueda(ControladorBusqueda controladorBusqueda) {
        this.controladorBusqueda = controladorBusqueda;
    }

    public ControladorVenta getControladorVenta() {
        return controladorVenta;
    }

    public void setControladorVenta(ControladorVenta controladorVenta) {
        this.controladorVenta = controladorVenta;
    }

    public VMain getvMain() {
        return vMain;
    }

    public void setvMain(VMain vMain) {
        this.vMain = vMain;
    }

    public VMain800 getvMain800() {
        return vMain800;
    }

    public void setvMain800(VMain800 vMain800) {
        this.vMain800 = vMain800;
    }

    public VBusqueda getvBusqueda() {
        return vBusqueda;
    }

    public void setvBusqueda(VBusqueda vBusqueda) {
        this.vBusqueda = vBusqueda;
    }

    public VCierre getvCierre() {
        return vCierre;
    }

    public void setvCierre(VCierre vCierre) {
        this.vCierre = vCierre;
    }

    public boolean isIfcompartiva() {
        return ifcompartiva;
    }

    public void setIfcompartiva(boolean ifcompartiva) {
        this.ifcompartiva = ifcompartiva;
    }
    
    
    
    
    public int mensajeVistaDecision(JInternalFrame v,String mensaje,String titulo){
        int regreso=JOptionPane.showConfirmDialog(v,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
        System.out.println("Confirmacion: "+regreso);
        return regreso;
    }
    
    
    public void mensajeVista(JInternalFrame v,String mensaje,String titulo){

        JOptionPane.showMessageDialog(v,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }
    
    
    public void mensajeVistaUnico(JInternalFrame v,String mensaje,String titulo){
       JOptionPane.showMessageDialog(v,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }   
    
    
    
    private void creaConfig(){
        configV = new ConfigV(null, this);
    }
    
    private void creaSubControladores(){
        
        controladorBusqueda =  new ControladorBusqueda(configV,this);
        controladorVenta =  new ControladorVenta(configV,this);
        controladorCierre =  new ControladorCierre(configV,this);
        
    }
    
    private void showPantallaPrincipal(){
        
        int tipo = this.tipoVista();
        
        if(tipo==1) {
            VMain800 tmp = new VMain800();
            this.agregaVista(tmp, true, true);
            vMain800=tmp;
        }
        
        if(tipo==2) {
            VMain800 tmp = new VMain800();
            this.agregaVista(tmp, true, false);
            vMain800=tmp;
        }
        
        if(tipo==3) {
            VMain tmp = new VMain(this,null);
            this.agregaVista(tmp, true, true);
            vMain=tmp;
            this.setIfcompartiva(true);
        }
        
        if(tipo==4) {
            VMain tmp = new VMain(this,null);
            this.agregaVista(tmp, true, false);
            vMain=tmp;
            this.setIfcompartiva(true);
        }
        
    }
    
    
    public void ejecutaAccion(String controlador,String accion,HashMap<String, Object> p){
        
    }
    
    public void ejecutaAccion(String controlador,String accion,String [] p){
        switch(controlador){
            case "Venta": controladorVenta.ejecutaAccion(accion,p);
            case "Busqueda": controladorBusqueda.ejecutaAccion(accion,p);
            case "Cierre": controladorCierre.ejecutaAccion(accion,p);
        }
    }
    
    
    public void ejecutaAccion(String controlador,String accion){
        
        switch(controlador){
            case "Busqueda": controladorBusqueda.ejecutaAccion(accion);
            case "Venta": controladorVenta.ejecutaAccion(accion);    
            case "Cierre": controladorCierre.ejecutaAccion(accion);   
            
        }
        
    }
    
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
            
            case "showPantallaPrincipal": showPantallaPrincipal();break;
            
            
        }
        
    }
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
                case "showPantallaPrincipal": showPantallaPrincipal();break;


            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
        }
        
       
        
    }
    
    
}
