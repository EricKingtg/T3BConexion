/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.org.t3b.core.utils.FormatoNumero;


/**
 *
 * @author roberto
 */
public class ValidadorCierre implements TableModelListener {

    
    private JTable tabla;
    private JLabel total;
    private JLabel pagado;
    private JLabel cambio;
    private JButton aceptar;
    private float tot;
    private ConfigV configV;
    private FormatoNumero formato=new FormatoNumero();
    private boolean vEvale=false;
    private boolean vTregalo=false;
    
    public ValidadorCierre(){
        
    }
    
    
    public ValidadorCierre(JLabel t,JLabel p,JLabel c,JButton a,float totaln,JTable tab,ConfigV config){
        tabla = tab;
        total=t;
        pagado=p;
        cambio=c;
        tot=totaln;
        aceptar=a;
        configV=config;
    }
    
    
    private float calculaCambio(float sumaImportesCambio,float sumaImportes){
        float cambio=0;
        
        
        
        cambio  = (tot-sumaImportes)-sumaImportesCambio;
        
        if(cambio<0){
            cambio=(-1)*cambio;
        }
        
        return cambio;
    }
    
    
    private float sumaMenosEvale(){
        float regreso=0;
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       int i=0;
       for(i=0;i<model.getRowCount();i++){
           String id = model.getValueAt(i, 0).toString();
           if(!id.equals("3")){
               regreso=regreso+Float.parseFloat(model.getValueAt(i, 2).toString());
           }
           
       }
        
       
        
        return regreso;
    }
    
    
    private float sumaMenosTregalo(){
        float regreso=0;
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       int i=0;
       for(i=0;i<model.getRowCount();i++){
           String id = model.getValueAt(i, 0).toString();
           if(!id.equals("7")){
               regreso=regreso+Float.parseFloat(model.getValueAt(i, 2).toString());
           }
           
       }
        
       
        
        return regreso;
    }
    
    
    
    
    
//    private void validaTregalo(int lastRow){
//       DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//       int i=0;
//       for(i=0;i<model.getRowCount();i++){
//           String id = model.getValueAt(i, 0).toString();
//           
//           if(id.equals("7") && lastRow==i){
//               
//               if(configV.isCierreTregalo()==false){
//                   model.setValueAt("", i, 3);
//                   //model.setValueAt("", i, 2);
//               }
//               
//               try{
//                   
//                   if(configV.getSaldotr().getSaldo()>0 && configV.isCierreTregalo()){
//                    
//                       float importe = 0;
//                       float difNoEvale = 0;
//                       
//                       try{
//                        importe = Float.parseFloat(model.getValueAt(i, 2).toString());
//                       }catch(Exception a){
//                           importe=0;
//                       }
//                       try{
//                        difNoEvale=configV.getCar().getTotal()-sumaMenosTregalo();
//                       }catch(Exception b){
//                           difNoEvale=0;
//                       }
//                       
//                       //System.out.println("Diferencia: "+difNoEvale+" Importe: "+importe);
//                       
//                       if(difNoEvale<=importe  && !this.isvTregalo()){
//                           this.setvTregalo(true);
//                           if(difNoEvale>0){
//                               model.setValueAt(formato.redondeaCero(formato.formato2Dec(difNoEvale)), i, 2);
//                               //model.setValueAt(configV.getSaldo().getSaldo(), i, 2);
//                               //model.setValueAt("", i, 2);
//                           }else{
//                               model.setValueAt("0.00", i, 2);
//                           }
//                           
//                       }
//                       
//                       importe = Float.parseFloat(model.getValueAt(i, 2).toString());
//                       
//                       if(importe>configV.getSaldotr().getSaldo()){
//                           model.setValueAt(formato.redondeaCero(formato.formato2Dec(configV.getSaldo().getSaldo())), i, 2);
//                       }
//                       
//                       
//                       
//                   }else {
//                       //model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
//                       //model.setValueAt("0.00", i, 2);
//                   }
//                   
//               }catch(Exception e){
//               
//                  //model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
//                  //model.setValueAt("0.00", i, 2);
//                   
//               }
//               
//           }
//           
//       }
//    }
//    
//    
//    
//    
//    private void validaEvale(int lastRow){
//       DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//       int i=0;
//       for(i=0;i<model.getRowCount();i++){
//           String id = model.getValueAt(i, 0).toString();
//           
//           if(id.equals("3") && lastRow==i){
//               
//               if(configV.isCierreEvale()==false){
//                   model.setValueAt("", i, 3);
//                   //model.setValueAt("", i, 2);
//               }
//               
//               try{
//                   
//                   if(configV.getSaldo().getSaldo()>0 && configV.isCierreEvale()){
//                    
//                       float importe = 0;
//                       float difNoEvale = 0;
//                       
//                       try{
//                        importe = Float.parseFloat(model.getValueAt(i, 2).toString());
//                       }catch(Exception a){
//                           importe=0;
//                       }
//                       try{
//                        difNoEvale=configV.getCar().getTotal()-sumaMenosEvale();
//                       }catch(Exception b){
//                           difNoEvale=0;
//                       }
//                       
//                       //System.out.println("Diferencia: "+difNoEvale+" Importe: "+importe);
//                       
//                       if(difNoEvale<=importe  && !this.isvEvale()){
//                           this.setvEvale(true);
//                           if(difNoEvale>0){
//                               model.setValueAt(formato.redondeaCero(formato.formato2Dec(difNoEvale)), i, 2);
//                               //model.setValueAt(configV.getSaldo().getSaldo(), i, 2);
//                               //model.setValueAt("", i, 2);
//                           }else{
//                               model.setValueAt("0.00", i, 2);
//                           }
//                           
//                       }
//                       
//                       importe = Float.parseFloat(model.getValueAt(i, 2).toString());
//                       
//                       if(importe>configV.getSaldo().getSaldo()){
//                           model.setValueAt(formato.redondeaCero(formato.formato2Dec(configV.getSaldo().getSaldo())), i, 2);
//                       }
//                       
//                       
//                       
//                   }else {
//                       //model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
//                       //model.setValueAt("0.00", i, 2);
//                   }
//                   
//               }catch(Exception e){
//               
//                  //model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
//                  //model.setValueAt("0.00", i, 2);
//                   
//               }
//               
//           }
//           
//       }
//    }
    
    
    
    private void calculaTotales(){
       
        int i=0;
        float sumaImportes=0;
        float sumaImportesCambio=0;
        float sumaImportesSinCambio=0;
        float sumaCambioReal=0;
        boolean ifCambio=false;
        aceptar.setEnabled(false);
        
        ArrayList<Hashtable<String, String>> ArrayList = new ArrayList<Hashtable<String, String>>();
        this.setvEvale(false);
        this.setvTregalo(false);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       
       for(i=0;i<model.getRowCount();i++){
           try{
            String id = configV.getFormasPago().get(i).get("idPago");
            String camb = configV.getFormasPago().get(i).get("cambio");

            System.out.println("Importe: "+model.getValueAt(i, 2)+" Cambio:"+camb);
            
                sumaImportes=sumaImportes+Float.valueOf(model.getValueAt(i, 2).toString());
           

           
            
            
            
            if(camb.equals("1")) {
                
                float importeCambio = Float.valueOf(model.getValueAt(i, 2).toString());
                sumaImportesCambio = importeCambio+sumaImportesCambio;
                //if(importeCambio>0)
                    ifCambio=true;
                
                
            }else {
                float importeCambio = Float.valueOf(model.getValueAt(i, 2).toString());
                sumaImportesSinCambio = importeCambio+sumaImportesSinCambio;
            }    
           }catch(Exception ex){
               
           }
       }
       
       
       System.out.println("suma: "+formato.formato2Dec(sumaImportes)+"  total: "+formato.formato2Dec(tot));
       
       
       
       
       
       if(formato.formato2Dec(sumaImportes)>=formato.formato2Dec(tot))
           aceptar.setEnabled(true);
       
       if(sumaImportesCambio>0){
           sumaCambioReal=calculaCambio(sumaImportesCambio,sumaImportesSinCambio);
           cambio.setText("$ "+formato.redondeaCero(formato.formato2Dec(sumaCambioReal)));
           configV.setCambio(sumaCambioReal);
       }
       
       pagado.setText("$ "+formato.redondeaCero(formato.formato2Dec(sumaImportes)));
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); 
       
        for(i=0;i<modelo.getRowCount();i++){
            Hashtable<String, String> camposTabla=new Hashtable<String, String>();
           try{
                String id = configV.getFormasPago().get(i).get("idPago");
                String cambio = configV.getFormasPago().get(i).get("cambio");
                camposTabla.put("idPago",id);
                camposTabla.put("importe_recibido",modelo.getValueAt(i, 2).toString());
                if(id.equals("1")){
                    camposTabla.put("importe_cambio", String.valueOf(sumaCambioReal));
                }else {
                    camposTabla.put("importe_cambio", "0");
                }
                
                System.out.println("Referencia: "+modelo.getValueAt(i, 3).toString());
                
                camposTabla.put("referencia",modelo.getValueAt(i, 3).toString());
                
                if(id.equals("1"))
                    configV.setTotalEfectivo(Float.parseFloat(modelo.getValueAt(i, 2).toString()));
                if(id.equals("2"))
                    configV.setTotalVales(Float.parseFloat(modelo.getValueAt(i, 2).toString()));
                if(id.equals("3") && configV.isCierreEvale())
                    configV.setTotalEvale(Float.parseFloat(modelo.getValueAt(i, 2).toString()));
                if(id.equals("4"))
                    configV.setTotalTC(Float.parseFloat(modelo.getValueAt(i, 2).toString()));
                if(id.equals("7"))
                    configV.setTotalTR(Float.parseFloat(modelo.getValueAt(i, 2).toString()));
                
            
           }catch(Exception ex1){
               
           } 
           
           ArrayList.add(camposTabla);
           
        }   
       
        //configV.setFormasPagoHechos(ArrayList);
        
        
        
    }
    
    
    private void validaTC(int lastRow){
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       int i=0;
       float efectivo=0;
       float vales=0;
       float valese=0;
       float tregalo=0;
       float sumamax=0;
       System.out.println("Entroo");
       for(i=0;i<model.getRowCount();i++){
           String id = model.getValueAt(i, 0).toString();
           
           if(id.equals("4")){
                System.out.println("Entroo");
                float importe = 0;
                       
                       
                try{
                    
                    importe = Float.parseFloat(model.getValueAt(i, 2).toString());
                }catch(Exception a){
                           importe=0;
                }
                
               if(configV.getCar().getTotal()>0 && importe>0){
                   
                     System.out.println("Entroo: "+configV.getCar().getTotal());
                    
                       
                       
                       
                       efectivo=configV.getTotalEfectivo();
                       vales=configV.getTotalVales();
                       valese=configV.getTotalEvale();
                       tregalo=configV.getTotalTR();
                       
                       sumamax=configV.getCar().getTotal()-efectivo-vales-valese-tregalo;
                       
                       System.out.println("Suma diferencia: "+sumamax);
                       if(importe>=configV.getCar().getTotal()){
                        if(sumamax<importe){

                                if(sumamax>0)
                                    model.setValueAt(formato.redondeaCero(formato.formato2Dec(sumamax)), i, 2);
                                else
                                    model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
                                //model.setValueAt(configV.getSaldo().getSaldo(), i, 2);
                                //model.setValueAt("", i, 2);


                        }
                       }else{
                           if(sumamax<importe){
                               if(sumamax>0)
                                    model.setValueAt(formato.redondeaCero(formato.formato2Dec(sumamax)), i, 2);
                                else
                                    model.setValueAt(formato.redondeaCero(formato.formato2Dec(0)), i, 2);
                           }
                           
                           
                       }
                       
                       
               }       
               
               
           }
           
           
       }   
        
           
        
    }
    
    
    
    
    
    @Override
    public void tableChanged(TableModelEvent e) {
        
        int lastRow = e.getLastRow();
        int index = e.getColumn();
        
        
        if(index==2) {
            
//            this.validaEvale(lastRow);
//            this.validaTregalo(lastRow);
            this.validaTC(lastRow);
            this.calculaTotales();
        }
        
        if(index==3) {
            this.calculaTotales();
        }
        
         
        
        
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
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

    public float getTot() {
        return tot;
    }

    public void setTot(float tot) {
        this.tot = tot;
    }

    public ConfigV getConfigV() {
        return configV;
    }

    public void setConfigV(ConfigV configV) {
        this.configV = configV;
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
    
    
    
    
}