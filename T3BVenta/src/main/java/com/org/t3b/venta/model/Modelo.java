/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.model;

import com.org.t3b.core.model.ModeloG;
import com.org.t3b.core.utils.Config;
import com.org.t3b.venta.controller.Controlador;



/**
 *
 * @author roberto
 */
public class Modelo extends ModeloG{
    
    public Modelo(Controlador c,Config cf){
        super(c, cf);
    }
    
    public Modelo(){
        
    }
    
}
