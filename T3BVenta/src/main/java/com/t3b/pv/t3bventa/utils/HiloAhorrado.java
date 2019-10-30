/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;

import javax.swing.JLabel;

/**
 *
 * @author roberto
 */
public class HiloAhorrado extends Thread {
    
    private JLabel lAhorro;
    private String stringAhorro;
    
    public HiloAhorrado(){
        
    }
    
    public HiloAhorrado(JLabel ahorro,String ahorrof){
        lAhorro=ahorro;
        stringAhorro=ahorrof;
    }
    
    public void run(){
        
        
        while(true){
        
                    lAhorro.setText(stringAhorro);
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    lAhorro.setText("");
                    //System.out.println("Sigo aqui 1111");
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    
        }            
        
    }
    
    
}
