/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bframework.controller;

import com.t3b.pv.t3bcore.controller.ControladorG;
import com.t3b.pv.t3bcore.utils.AccionModulo;
import com.t3b.pv.t3bcore.utils.Permiso;
import com.t3b.pv.t3bframework.model.Modelo;
import com.t3b.pv.t3bframework.utils.Config;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author roberto
 */
public class Controlador extends ControladorG{
    
    private Config configF;
    private JFrame principal;
    
    public Controlador(){
        
    }
    
    public Controlador(Config cf,JFrame p){
        this.principal=p;
        this.configF=cf;
    }
    
    public Controlador(com.t3b.pv.t3bcore.utils.Config c,JDesktopPane escritorio,ControladorG cg){
        super(c,escritorio,cg);
    }

    public Config getConfigF() {
        return configF;
    }

    public void setConfigF(Config configF) {
        this.configF = configF;
    }
    
    
    
    
   
    
    
    private void cargaDatosUsuario(String userid){
        
        ArrayList <HashMap<String,String>> usuarios= new ArrayList<HashMap<String,String>>();
        ArrayList <HashMap<String,String>> permisos= new ArrayList<HashMap<String,String>>();
        HashMap<String,String> usuario = new HashMap<>();
        
        Modelo modelo = new Modelo(null);
        usuarios=modelo.obtenDatosUsuario(userid);
        
        usuario=usuarios.get(0);
        Config.idUser=Integer.valueOf(userid);
        Config.usuario.setId_usr(Integer.valueOf(userid));
        Config.usuario.setNombres(usuario.get("nombres").toString());
        Config.usuario.setPaterno(usuario.get("paterno").toString());
        Config.usuario.setMaterno(usuario.get("materno").toString());
        Config.usuario.setEmail(usuario.get("email").toString());
        Config.usuario.setTelefono(usuario.get("telefono").toString());
        Config.usuario.setIdPerfil(Integer.valueOf(usuario.get("id_perfil").toString()));
        Config.usuario.setDescPerfil(usuario.get("desc_perfil").toString());
        Config.usuario.setIdDepto(Integer.valueOf(usuario.get("id_depto").toString()));
        Config.usuario.setDescDespto(usuario.get("desc_depto").toString());
        Config.usuario.setIdPuesto(Integer.valueOf(usuario.get("id_puesto").toString()));
        Config.usuario.setDescPuesto(usuario.get("desc_puesto").toString());
        Config.usuario.setIdTienda(Integer.valueOf(usuario.get("id_tienda").toString()));
        Config.usuario.setIdDistrito(Integer.valueOf(usuario.get("id_distrito").toString()));
        Config.usuario.setNumEmpleado(Integer.valueOf(usuario.get("num_empleado").toString()));
        Config.usuario.setEstatus(Integer.valueOf(usuario.get("estatus").toString()));
        
        Config.perfil.setIdPerfil(Integer.valueOf(usuario.get("id_perfil").toString()));
        Config.perfil.setDescPerfil(usuario.get("desc_perfil").toString());
        Config.perfil.setAliasPerfil(usuario.get("alias_perfil").toString());
        Config.perfil.setEstatus(Integer.valueOf(usuario.get("estatus").toString()));
        
        permisos=modelo.obtenPermisosUsuario(String.valueOf(Config.perfil.getIdPerfil()), Config.id_sistema);
        
        
        for (HashMap<String, String> permiso : permisos) {
            
            Permiso tmpp =  new Permiso();
            AccionModulo tmpam =  new AccionModulo();
            
            
            tmpam.setId(Integer.valueOf(permiso.get("id_accion_modulo")));
            tmpam.setId_modulo(Integer.valueOf(permiso.get("id_modulo").toString()));
            tmpam.setAccion(permiso.get("accion").toString());
            tmpam.setVerificar(Integer.valueOf(permiso.get("verificar").toString()));
            tmpam.setStatus(Integer.valueOf(permiso.get("status").toString()));
            
            tmpp.setIdPermiso(Integer.valueOf(permiso.get("id_permiso").toString()));
            tmpp.setDescPermiso(permiso.get("desc_permiso").toString());
            tmpp.setAliasPermiso(permiso.get("alias_permiso").toString());
            tmpp.setIdSistema(Integer.valueOf(permiso.get("id_sistema")));
            tmpp.setIdAccionModulo(Integer.valueOf(permiso.get("id_accion_modulo")));
            tmpp.setAm(tmpam);
            
            Config.permisos.add(tmpp);
            
            
        }
        
        this.setIdUser(Config.idUser);
        this.setUsuario(Config.usuario);
        this.setPerfil(Config.perfil);
        this.setPermisos(Config.permisos);
        
            
        
    }
    
    

    
    
    public void ejecutaAccion(String accion,String [] p){
        
        switch(accion){
            
            case "cargaDatosUsuario": cargaDatosUsuario(p[0]);break;
            
                
        }        
        
    }
    
    
}
