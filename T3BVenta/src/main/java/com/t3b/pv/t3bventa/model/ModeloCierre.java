/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.model;

import com.t3b.pv.t3bcore.utils.Config;
import com.t3b.pv.t3bventa.controller.Controlador;
import com.t3b.pv.t3bventa.utils.ConfigV;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author roberto
 */
public class ModeloCierre extends Modelo{
    
    private ConfigV configV;
    
    public ModeloCierre(){
        
    }
    
    public ModeloCierre(ConfigV c){
        this.configV=c;
    }
    
    public ModeloCierre(Controlador c, Config cf) {
        super(c, cf);
    }
    
    
    public ArrayList <HashMap<String,String>> buscaFormasPago(){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BVENTA_FORMAS_PAGO()}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
    
    
}
