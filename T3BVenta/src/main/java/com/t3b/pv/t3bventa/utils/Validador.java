/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;

import com.t3b.pv.t3bcore.utils.FormatoNumero;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author roberto
 */
public class Validador {
    
    private ConfigV configV;
    private JLabel total;
    private JLabel pagado;
    private JLabel cambio;
    private JButton bF1;
    private JButton aceptar;
    private JTable pagos;
    private float totalf;
    private float cambiof;
    private float pagadof;
    private float restantef;
    private FormatoNumero formato=new FormatoNumero();
    private boolean vEvale=false;
    private boolean vTregalo=false;
    
    public Validador(){
        
    }
    
    public Validador(ConfigV c,JLabel total,JLabel pagado,JLabel cambio,float totalf,JButton f1,JTable p){
        this.configV=c;
        this.total=total;
        this.pagado=pagado;
        this.cambio=cambio;
        this.bF1=f1;
        this.pagos=p;
        this.totalf=totalf;
        cambiof=0;
        pagadof=0;
        restantef=0;
    }

    
    
    private void setTablaDato(float pago,String fp_clave){
        
        DefaultTableModel model = (DefaultTableModel) pagos.getModel();
        
        
        for (int i = 0; i < model.getRowCount(); i++) {
            if(model.getValueAt(i, 0).toString().equals(fp_clave))
                model.setValueAt(formato.redondeaCero(formato.formato2Dec(pago)), i, 2);
            
        }
        
        
    }
    
    
    private void limpiaDatoTabla(float pago,String fp_clave){
        
        for (HashMap <String,String> tmp: configV.getFormasPago()) {
            
            if(tmp.get("fp_clave").toString().equals(fp_clave)){
                tmp.remove("valor");
                tmp.put("valor",String.valueOf("0.00"));
            }
            
            
        }
        setTablaDato(pago, fp_clave);
        
    }
    
    private void recalculaPagado(){
        
        //System.out.println("Pagado: "+pagadof);
        //System.out.println("Restante: "+restantef);
        
        pagadof=0;
        restantef=0;
        DefaultTableModel model = (DefaultTableModel) pagos.getModel();
        
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            
            
            float pagadofp=0;
            
            try {
                pagadofp=Float.valueOf(model.getValueAt(i, 2).toString());
            }catch(Exception e){
                
            }
            //System.out.println("Pagado x registro: "+pagadofp);
            pagadof=pagadof+pagadofp;
            
            
            
        }
        
        
    }
    
    
    private void activaBoton(){
        if(pagadof>=totalf){
            bF1.setEnabled(true);
        }else {
            bF1.setEnabled(false);
        }
    }
    
    
    public void validaEfectivo(float porpagar){
        
        limpiaDatoTabla(0, "1");
        recalculaPagado();
        
        pagadof=pagadof+porpagar;
        
        //System.out.println("Pagado 2: "+pagadof);
        //System.out.println("Total: "+totalf);
        
        if((pagadof-totalf)>0){
            cambiof=pagadof-totalf;
            restantef=0;
        }else {
            restantef=(-1)*(pagadof-totalf);
            cambiof=0;
        }
        
        this.pagado.setText("$ "+formato.redondeaCero(formato.formato2Dec(pagadof)));
        this.cambio.setText("$ "+formato.redondeaCero(formato.formato2Dec(cambiof)));
        
        for (HashMap <String,String> tmp: configV.getFormasPago()) {
            
            if(tmp.get("fp_clave").toString().equals("1")){
                tmp.remove("valor");
                tmp.put("valor",String.valueOf(porpagar));
            }
            
            
        }
        
        setTablaDato(porpagar,"1");
        activaBoton();
        
    }
    
    
    public void validaVales(float porpagar){
        
        limpiaDatoTabla(0, "2");
        recalculaPagado();
        
        pagadof=pagadof+porpagar;
        
        //System.out.println("Pagado 2: "+pagadof);
        //System.out.println("Total: "+totalf);
        
        if((pagadof-totalf)>0){
            //cambiof=pagadof-totalf;
            restantef=0;
        }else {
            restantef=(-1)*(pagadof-totalf);
            //cambiof=0;
        }
        
        this.pagado.setText("$ "+formato.redondeaCero(formato.formato2Dec(pagadof)));
        //this.cambio.setText("$ "+formato.redondeaCero(formato.formato2Dec(cambiof)));
        
        for (HashMap <String,String> tmp: configV.getFormasPago()) {
            
            if(tmp.get("fp_clave").toString().equals("1")){
                tmp.remove("valor");
                tmp.put("valor",String.valueOf(porpagar));
            }
            
            
        }
        
        setTablaDato(porpagar,"2");
        activaBoton();
        
    }
    
    
    public void validaEvale(float porpagar){
        
        limpiaDatoTabla(0, "2");
        recalculaPagado();
        
        pagadof=pagadof+porpagar;
        
        //System.out.println("Pagado 2: "+pagadof);
        //System.out.println("Total: "+totalf);
        
        if((pagadof-totalf)>0){
            //cambiof=pagadof-totalf;
            restantef=0;
        }else {
            restantef=(-1)*(pagadof-totalf);
            //cambiof=0;
        }
        
        this.pagado.setText("$ "+formato.redondeaCero(formato.formato2Dec(pagadof)));
        //this.cambio.setText("$ "+formato.redondeaCero(formato.formato2Dec(cambiof)));
        
        for (HashMap <String,String> tmp: configV.getFormasPago()) {
            
            if(tmp.get("fp_clave").toString().equals("1")){
                tmp.remove("valor");
                tmp.put("valor",String.valueOf(porpagar));
            }
            
            
        }
        
        setTablaDato(porpagar,"2");
        activaBoton();
        
    }
    
    public ConfigV getConfigV() {
        return configV;
    }

    public void setConfigV(ConfigV configV) {
        this.configV = configV;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JLabel getPagado() {
        return pagado;
    }

    public void setPagado(JLabel pagado) {
        this.pagado = pagado;
    }

    public JLabel getCambio() {
        return cambio;
    }

    public void setCambio(JLabel cambio) {
        this.cambio = cambio;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
    }

    public float getTotalf() {
        return totalf;
    }

    public void setTotalf(float totalf) {
        this.totalf = totalf;
    }

    public float getCambiof() {
        return cambiof;
    }

    public void setCambiof(float cambiof) {
        this.cambiof = cambiof;
    }

    public float getPagadof() {
        return pagadof;
    }

    public void setPagadof(float pagadof) {
        this.pagadof = pagadof;
    }

    public FormatoNumero getFormato() {
        return formato;
    }

    public void setFormato(FormatoNumero formato) {
        this.formato = formato;
    }

    public boolean isvEvale() {
        return vEvale;
    }

    public void setvEvale(boolean vEvale) {
        this.vEvale = vEvale;
    }

    public boolean isvTregalo() {
        return vTregalo;
    }

    public void setvTregalo(boolean vTregalo) {
        this.vTregalo = vTregalo;
    }

    public float getRestantef() {
        return restantef;
    }

    public void setRestantef(float restantef) {
        this.restantef = restantef;
    }

    public JButton getbF1() {
        return bF1;
    }

    public void setbF1(JButton bF1) {
        this.bF1 = bF1;
    }

    public JTable getPagos() {
        return pagos;
    }

    public void setPagos(JTable pagos) {
        this.pagos = pagos;
    }
    
    
    
    
            
    
}
