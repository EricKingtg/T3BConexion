/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.framework.model;

import com.org.t3b.core.model.ModeloG;
import com.org.t3b.core.utils.Config;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author roberto
 */
public class Modelo extends ModeloG{
    
    public Modelo(){
        
    }
    
    public Modelo(Config cf){
        super(null, cf);
    }
    
    public ArrayList <HashMap<String,String>> obtenModulosSistema(String id_sistema){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_APP_CONSULTA_MODULOS_SISTEMA('"+id_sistema+"')}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
    public ArrayList <HashMap<String,String>> obtenDatosUsuario(String id_usr){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BLOGIN_USUARIOSDATOS('"+id_usr+"')}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    public ArrayList <HashMap<String,String>> obtenPermisosUsuario(String id_perfil,String id_sistema){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BLOGIN_PERMISOPERFIL('"+id_perfil+"','"+id_sistema+"')}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
    
}
