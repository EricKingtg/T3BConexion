/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.model;

import com.t3b.pv.t3bcore.model.ModeloG;
import com.t3b.pv.t3bcore.utils.Config;
import com.t3b.pv.t3bventa.controller.Controlador;



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
