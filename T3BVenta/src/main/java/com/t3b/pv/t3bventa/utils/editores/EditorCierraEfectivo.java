/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils.editores;

import com.t3b.pv.t3bventa.utils.ConfigV;
import javax.swing.DefaultCellEditor;
import javax.swing.InputVerifier;
import javax.swing.JTextField;


/**
 *
 * @author roberto
 */
public class EditorCierraEfectivo extends DefaultCellEditor{
    
    VerificadorMontoEfectivo ivtmp;
    int idPago=0;
    ConfigV configV;

    public EditorCierraEfectivo(JTextField textField,VerificadorMontoEfectivo i,int p,ConfigV c) {
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
