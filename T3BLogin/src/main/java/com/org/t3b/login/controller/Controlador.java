/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.login.controller;


import com.org.t3b.core.controller.ControladorG;
import com.org.t3b.core.utils.Config;
import com.org.t3b.log.utils.Logger3B;
import com.org.t3b.login.gui.main.VLogin;
import com.org.t3b.login.model.Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


/**
 *
 * @author roberto
 */
public class Controlador extends ControladorG {
    private JInternalFrame vista;
    private VLogin login;
    private String [] parametros;
    
    public Controlador(){
        
    }
    
    public Controlador(Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
    }
    
    
    private void showLogin(String param[]){
        VLogin tmp = new VLogin(this);
        this.agregaVista(tmp, true, false);
        login=tmp;
        vista=tmp; 
        parametros=param;
    }
    
    private void close(){
        vista.setVisible(false);
        
    }
    
//    private void showTransacciones(){
//        
//        
//        String [] p = new String[1];
//        this.getContGeneral().ejecutaAccion("transacciones", "showMenuClose", p, this);
//    }
    
    private void ejecutaModulo(){
        
        String [] p = new String[1];
        System.out.println("Parametros: "+parametros[0]+" "+parametros[1]);
        
        login.setVisible(false);
        login.dispose();
        this.getContGeneral().ejecutaAccion(parametros[0],parametros[1], p, this);
        
        
    }
    
    
    
    
    
    
    private void validaLogin(String user,String password){
        Modelo modelo = new Modelo(this, null);
        if(modelo.validaLogin(user, password)){
            System.out.println("Usuario valido");
            String [] p=new String[1];
            p[0]=String.valueOf(modelo.getUserId());
            this.getContGeneral().ejecutaAccion("cargaDatosUsuario", p);
            Logger3B.Log(3, "Login: validaLogin Res: Verdadero User:"+user+"Password: "+password);
            this.ejecutaModulo();
        }else {
            login.informacion("Usuario no valido, verifique sus datos");
        }
        
    }
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> parametros){
        
        Logger3B.Log(3, "Login: Accion: "+accion);
        if(accion.equals("validaLogin")){
            validaLogin(parametros.get("user").toString(),parametros.get("password").toString());
        }
            
            
            
               
    }
    
    
    
    
    
    public void ejecutaAccion(String accion,String [] p){

        Logger3B.Log(3, "Login: Accion: "+accion);
        if(accion.equals("showLogin"))
            showLogin(p);
        if(accion.equals("close"))
            close();

    }
    
    
}
