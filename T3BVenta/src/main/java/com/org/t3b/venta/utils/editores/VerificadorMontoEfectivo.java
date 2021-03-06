/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.utils.editores;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.org.t3b.venta.utils.ConfigV;


/**
 *
 * @author roberto
 */
public class VerificadorMontoEfectivo extends InputVerifier{

    private JLabel pagado;
    private JLabel cambio;
    private int idPago=0;
    private ConfigV configV;
    private boolean permiteEscribir=true;
    
    public VerificadorMontoEfectivo(JLabel p,JLabel c,ConfigV cf,int id,boolean pe){
        this.pagado=p;
        this.cambio=c;
        this.configV=cf;
        this.idPago=id;
        this.permiteEscribir=pe;
    }
    
    private boolean validaMontos(String texto,JTextField input){
        boolean regreso=true;
        
        return regreso;
    }
    
    @Override
    public boolean verify(JComponent input) {
        VerificadorMontoEfectivo tmp = new VerificadorMontoEfectivo(this.pagado,this.cambio,this.configV,this.idPago,this.permiteEscribir);
        JTextField field = (JTextField) input;
        boolean valido=this.validaMontos(field.getText(),field);
        return valido;
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean valid = verify(input);
        if (!valid) {
            JOptionPane.showMessageDialog(null, "Validacion Monto mal");
            JTextField field = (JTextField) input;
            field.setText("0");
        }
        return valid;
    }
    
}
