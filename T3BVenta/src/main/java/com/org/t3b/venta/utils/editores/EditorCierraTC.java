/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.utils.editores;

import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JTextField;

import com.org.t3b.venta.utils.ConfigV;


/**
 *
 * @author roberto
 */
public class EditorCierraTC extends DefaultCellEditor{
    
    InputVerifier ivtmp;
    int idPago=0;
    ConfigV configV;

    public EditorCierraTC(JTextField textField,InputVerifier i,int p,ConfigV c) {
        super(textField);
        this.ivtmp=i;
        this.idPago=p;
        this.configV=c;
    }
    
    @Override
    public boolean stopCellEditing() {
        if (!ivtmp.shouldYieldFocus(getComponent())) return false;
            return super.stopCellEditing();
    }

    @Override
    public JTextField getComponent() {
        return (JTextField) super.getComponent();
    }
    
    
    
}
