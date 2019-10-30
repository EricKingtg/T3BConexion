/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bcore.utils;

import java.text.DecimalFormat;

/**
 *
 * @author roberto
 */
public class FormatoNumero {
    
    public FormatoNumero(){
        
    }
    
    
    public Double formato2Dec(float numero){
        
        Double decimal = Double.valueOf(numero);
        // use of DecimalFormat

        DecimalFormat decFormat = new DecimalFormat("#.00");

        double formatDecimal = new Double(decFormat.format(decimal)).doubleValue();

        //System.out.println("DecimalFormat rounded in 2nd decimal: "+String.valueOf(formatDecimal));

        return formatDecimal;
    }
    
    public String redondeaCero(Double decimal){
        String regreso = null;
        String tmp = "";
        String []array = new String[2];
        
        tmp=String.valueOf(decimal);
        
        array=tmp.split("\\.");
        
        
        if(array[1].length()==1)
            regreso=tmp+"0";
        else
            regreso=tmp;
        
        
        
        
        return regreso;
        
        
        
    }
    
    
    
    
    
    
}
