/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;

import com.t3b.pv.t3bventa.gui.busqueda.VBusqueda;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/**
 *
 * @author roberto
 */
public class BKeyListener implements KeyListener {

    private VBusqueda busqueda;
    
    public BKeyListener(){
        
    }
    
    public BKeyListener(VBusqueda busqueda){
        this.busqueda=busqueda;
    }

    public VBusqueda getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(VBusqueda busqueda) {
        this.busqueda = busqueda;
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if ((e.getKeyCode() == KeyEvent.VK_F1)) {
            busqueda.f1Aceptar();
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            busqueda.salir();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
