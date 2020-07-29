/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bepagos.controller.model;

import com.t3b.pv.t3bconexion.utils.QryRespDTO;
import com.t3b.pv.t3bcore.model.ModeloG;
import com.t3b.pv.t3bcore.utils.Config;
import com.t3b.pv.t3bepagos.controller.Controlador;
import com.t3b.pv.t3bepagos.dao.db.IQryTA;
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
        ArrayList<Object> paramIn = new ArrayList();
        paramIn.add(marca);
        
        //System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsultaSP(sqlQuery,paramIn);
        
        
        return resultados;
        
        
    }
    
}
