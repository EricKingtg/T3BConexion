/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.model;

import com.org.t3b.core.utils.Config;
import com.org.t3b.venta.controller.Controlador;
import com.org.t3b.venta.utils.ConfigV;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author roberto
 */
public class ModeloBusqueda extends Modelo{
    
    private ConfigV configV;
    
    public ModeloBusqueda(){
        
    }
    
    public ModeloBusqueda(ConfigV c){
        this.configV=c;
    }
    
    public ModeloBusqueda(Controlador c, Config cf) {
        super(c, cf);
    }
    
    
    public ArrayList <HashMap<String,String>> buscaProducto(String busqueda){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BVENTA_BUSCA_ARTICULO('"+busqueda+"')}";
        
        //System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
    public ArrayList <HashMap<String,String>> buscaProductoComparativa(String icb){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BVENTA_BUSCA_PRODUCTO_REL('"+icb+"')}";
        
        //System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
}
