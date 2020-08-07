/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.epagos.controller.model;

import com.org.t3b.core.model.ModeloG;
import com.org.t3b.core.utils.Config;
import com.org.t3b.epagos.controller.Controlador;
import com.org.t3b.epagos.dao.db.IQryTA;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author roberto
 */
public class Modelo extends ModeloG{
    
    public Modelo(){
        
    }
    
    public Modelo(Controlador c,Config cf){
        super(c, cf);
    }
    
    
    
    public ArrayList <HashMap<String,String>> consultaProductosTA(String marca){
        
        ArrayList<Integer> paramOut = new ArrayList<>();
        paramOut.add(java.sql.Types.INTEGER);
        paramOut.add(java.sql.Types.VARCHAR);
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<>();
        
        
        String sqlQuery=IQryTA.CONSULTA_PRODUCTOS_TA;
        ArrayList<Object> paramIn = new ArrayList<>();
        paramIn.add(marca);
        
        //System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsultaSP(sqlQuery,paramIn);
        
        
        return resultados;
        
        
    }
    
}
