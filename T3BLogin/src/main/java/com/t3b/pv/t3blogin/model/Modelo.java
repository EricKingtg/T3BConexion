/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3blogin.model;


import com.t3b.pv.t3bconexion.utils.CampoDTO;
import com.t3b.pv.t3bconexion.utils.QryRespDTO;
import com.t3b.pv.t3bcore.model.ModeloG;
import com.t3b.pv.t3bcore.utils.Config;
import com.t3b.pv.t3blogin.controller.Controlador;
import com.t3b.pv.t3blogin.model.interfaces.IntModelo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author roberto
 */
public class Modelo extends ModeloG {
    
    private int userId=0;
    
    public Modelo(Controlador c,Config cf){
        super(c, cf);
    }
    
    public boolean validaLogin(String user,String password){
        QryRespDTO resultados = new QryRespDTO();
        boolean resultado=false;
        //String sqlQuery = "{call SP_T3BLOGIN_LOGIN(?,?,?,?)}";
        String sqlQuery=IntModelo.LOGINUSUARIO;
        ArrayList<Object> paramIn = new ArrayList();
        paramIn.add(user);
        paramIn.add(password);
        
        ArrayList<Integer> paramOut = new ArrayList();
        paramOut.add(java.sql.Types.INTEGER);
        paramOut.add(java.sql.Types.VARCHAR);
        
        resultados = this.ejecutaSP(sqlQuery, paramIn, paramOut);
        
        CampoDTO campo1 = resultados.getParamOut().get(0);
        try {
            if((userId=Integer.parseInt(campo1.getValor().toString()))>0){
                Config.configPV.setUserId(String.valueOf(userId));
                resultado=true;
            }
        }catch(Exception e){
            resultado=false;
        }
        
        
        return resultado;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
    
}
