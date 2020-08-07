/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.model;

import com.org.t3b.core.utils.Config;
import com.org.t3b.venta.controller.Controlador;
import com.org.t3b.venta.utils.ConfigV;
import com.org.t3b.venta.utils.Item;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author roberto
 */
public class ModeloVenta extends Modelo{

    private ConfigV configV;
    
    public ModeloVenta(Controlador c, Config cf) {
        super(c, cf);
    }
    
    public ModeloVenta(){
        
    }
    
    public ModeloVenta(ConfigV c){
        this.configV=c;
    }
    
    
    public ArrayList <HashMap<String,String>> buscaProductoICB(String icb){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BVENTA_BUSCA_PRODUCTO('"+icb+"')}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    public ArrayList <HashMap<String,String>> abrirVentaBD(){
        
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery = "{call SP_T3BVENTA_ABRIR_VENTA()}";
        
        System.out.println("Query:"+sqlQuery);
        resultados=this.ejecutaConsulta(sqlQuery);
        
        
        return resultados;
        
    }
    
    
    public boolean insertaArticuloBD(String codigo,String cantidad){
        boolean regreso=false;
        Item itemTmp = configV.getLastItem();
        
        ArrayList <HashMap<String,String>> resultados= new ArrayList<HashMap<String,String>>();
        String sqlQuery="call SP_T3BVENTA_INSERTA_ARTICULO('"+configV.getUltimoTicket()+"','"+codigo+"','"+Config.configPV.getCaja()+"','"+cantidad+"','"+Config.configPV.getUserId()+"',"
                + "'"+itemTmp.getIclave()+"','"+itemTmp.getProv_id()+"','"+itemTmp.getFactorIVA()+"','"+itemTmp.getFactorIEPS()+"','"+itemTmp.getPrecio()+"')";
        System.out.println(sqlQuery);
        try {
        
            System.out.println("Query:"+sqlQuery);
            resultados=this.ejecutaConsulta(sqlQuery);
            regreso=true;
        }catch(Exception e){
            regreso=false;
            
        }    
        
        return regreso;
        
        
    }
    
    
}
