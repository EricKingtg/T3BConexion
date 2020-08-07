/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

import com.org.t3b.venta.gui.cierre.VCierre;



/**
 *
 * @author roberto
 */
public class CVKeyListener implements KeyListener {
    
    private VCierre cierre;
    
    public CVKeyListener(){
        
    }
    
    public CVKeyListener(VCierre cierre){
        
        this.cierre=cierre;
        
    }

    public VCierre getCierre() {
        return cierre;
    }

    public void setCierre(VCierre cierre) {
        this.cierre = cierre;
    }

    
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Teclado: "+e.getKeyCode());
        
        
        if ((e.getKeyCode() == KeyEvent.VK_1)) {
            this.cierre.muestraEfectivo();
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_2)) {
            this.cierre.muestraVales();
        }
               
        if ((e.getKeyCode() == KeyEvent.VK_3)) {
            this.cierre.muestraEvale();
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_4)) {
            this.cierre.muestraTarjetaCredito();
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_5)) {
            
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_6)) {
            
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_7)) {
            
        }
        
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
