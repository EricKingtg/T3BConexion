/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.controller;

import com.org.t3b.core.utils.Config;
import com.org.t3b.venta.gui.main.VMain;
import com.org.t3b.venta.model.ModeloBusqueda;
import com.org.t3b.venta.model.ModeloVenta;
import com.org.t3b.venta.utils.Car;
import com.org.t3b.venta.utils.ConfigV;
import com.org.t3b.venta.utils.Item;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author roberto
 */
public class ControladorVenta {
    
    private ConfigV configV;
    private Controlador controlador;
   
    
    
    public ControladorVenta(){
        
    }
    
    public ControladorVenta(ConfigV c,Controlador cg){
        this.configV=c; 
        this.controlador=cg;
    }

    public ConfigV getConfigV() {
        return configV;
    }

    public void setConfigV(ConfigV configV) {
        this.configV = configV;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    private boolean buscaProducto(String icb,String cantidad){
       
        boolean regresa=false;
        ArrayList <HashMap<String,String>> regresop = new ArrayList <HashMap<String,String>>();
       
       
       ModeloVenta modeloVenta = new ModeloVenta();
       
       
       regresop = modeloVenta.buscaProductoICB(icb);
       
       if(regresop.size()>0){
           
           HashMap<String, String> camposTabla = regresop.get(0);
           Item item = new Item(Integer.parseInt(camposTabla.get("id_prod")),icb,Float.valueOf(camposTabla.get("precio_venta")),camposTabla.get("desc_art"),
                camposTabla.get("desc_reg"),Float.parseFloat(camposTabla.get("iv_monto")),Float.parseFloat(camposTabla.get("ie_monto")),Float.parseFloat(cantidad),Integer.valueOf(camposTabla.get("id_prov")));
                configV.setLastItem(item);
                regresa=true;
           
       }
       
       
       return regresa;
       
    }
    
    
    private void abrirVentaBD(){
       ModeloVenta modeloVenta = new ModeloVenta(); 
       ArrayList <HashMap<String,String>> abd = new ArrayList <HashMap<String,String>>();
       HashMap<String,String> datos = new HashMap<>();
       Car car = new Car();
       Car carCompartiva = new Car();
       abd=modeloVenta.abrirVentaBD();
       if(abd.size()>0)
        datos=abd.get(0);
      int userId = Integer.parseInt(Config.configPV.getUserId());
      int id = Integer.parseInt(datos.get("id"));
       
       
       car.iniciaCar(userId, Config.configPV.getTienda(), Config.configPV.getCaja(),String.valueOf(datos.get("num_ticket")), id);
       configV.setCar(car);
       configV.setCarComparativa(carCompartiva);
       configV.setUltimoTicket(Integer.parseInt(datos.get("num_ticket")));
       configV.setEncId(Integer.parseInt(datos.get("id")));
       configV.setVentaNueva(false);
       //log.escribeLog("Abrir BD ultimo Ticket: "+configV.getUltimoTicket()+" Enc ID: "+configV.getEncId());
       
    }
    
    
    private void insertaTablaVenta(){
        //VPrincipal tmp = (VPrincipal)vista;
        VMain tmp = this.controlador.getvMain();
        configV.getCar().agregaArticulo(configV.getLastItem());
        DefaultTableModel model = (DefaultTableModel) tmp.gettArticulos().getModel();
        model.addRow(new Object[]{String.valueOf(configV.getCar().getNum_productos()), configV.getLastItem().getDescCompleta(),configV.getLastItem().getCantidad(),this.getControlador().getFormato().redondeaCero(this.getControlador().getFormato().formato2Dec(configV.getLastItem().getPrecio())),this.getControlador().getFormato().redondeaCero(this.getControlador().getFormato().formato2Dec(configV.getLastItem().getTotal()))});
        tmp.gettArticulos().changeSelection(configV.getCar().getNum_productos()-1, 1, false, false);
       
   }
    
    private void insertaArticuloBD(String icb,Float cantidad){
       ModeloVenta modeloVenta = new ModeloVenta(this.configV); 
       if(modeloVenta.insertaArticuloBD(icb,String.valueOf(cantidad))){
           //log.escribeLog("Inserta Articulo ICB: "+icb+" Cant: "+cantidad);
           insertaTablaVenta();
           //imprimeArticulo(cantidad);
       }
       
    }
    
     private void limpiaICB(){
       
       this.controlador.getvMain().gettICB().setText("");
    }
    
     
    private void ajustaTotalesVista(){
       
       this.controlador.getvMain().getlTotal().setText("$ "+this.getControlador().getFormato().redondeaCero(this.getControlador().getFormato().formato2Dec(configV.getCar().getTotal())));
       
    } 
     
    
    private void cargaComparativa(String icb,Float cantidad){
       
        ModeloBusqueda modeloBusqueda = new ModeloBusqueda();
        ArrayList <HashMap<String,String>> comparativas = new ArrayList<>();
        HashMap<String, String> camposTabla=new HashMap<String, String>();
        comparativas=modeloBusqueda.buscaProductoComparativa(icb);
        
        if(comparativas.size()>0) {
            
            camposTabla=comparativas.get(0);
            VMain tmp = this.controlador.getvMain();
            //ResizeImage img = new ResizeImage();

            if(camposTabla.size()>0 && !camposTabla.get("descripcion").equals("")){

                 //try {


                 System.out.print("iclave:"+camposTabla.get("id_prod_mp"));
                 System.out.print("path:"+camposTabla.get("path_imagen"));
                 System.out.print("desc:"+camposTabla.get("desc_corta_mp"));
                 System.out.print("dif:"+camposTabla.get("diferencia").toString());
                 System.out.print("cant:"+cantidad);

                 Item itemTmp = new Item(Integer.parseInt(camposTabla.get("id_prod_mp")),camposTabla.get("path_imagen"),camposTabla.get("desc_corta_mp"),Float.parseFloat(camposTabla.get("diferencia").toString()),cantidad);   
                 configV.getCarComparativa().agregaArticuloComparativa(itemTmp);
                 String [] array=new String[2];
                 String nombreImagen;
                 array=camposTabla.get("path_imagen").split("\\.");
                 nombreImagen=array[0];

                 //try {
                 System.out.println("Nombre Imagen: "+nombreImagen);
                 //img.scaleImage("/home/pos3b/programas/"+camposTabla.get("path_imagen"),"/home/pos3b/programas/"+nombreImagen+"m.jpg","/home/pos3b/programas/"+nombreImagen+"s.jpg");
                 //tmp.getTpCompra().setText("Compra");
                 //tmp.getTpAhorra().setText("Y Ahorrate");
                 tmp.getlImagen().setIcon(new javax.swing.ImageIcon("/home/pos3b/programas/"+nombreImagen+".jpg")); // NOI18N
                 tmp.getlImagen().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                 tmp.getlAnuncio1().setText(camposTabla.get("desc_corta_mp"));
                 tmp.getlAnuncio2().setText("!!  $ "+this.controlador.getFormato().redondeaCero(this.controlador.getFormato().formato2Dec(Float.parseFloat(camposTabla.get("diferencia"))))+"  ¡¡");
                 tmp.getlAnuncio3().setText("Contra \n"+camposTabla.get("desc_corta_mc"));
                 tmp.getlAnuncio4().setText(camposTabla.get("descripcion"));

//                 }catch(Exception e){
//                   System.out.println(e);
//                 }


            }else {
                //Poner logo u otra cosa

            }
        }
       
   }
    
    
     
    private void agregaArticuloICB(String [] p){
       
        
        
        if(configV.getMultiplicacion()>1){
            System.out.println("Aqui multiplicando");
            p[1]=String.valueOf(configV.getMultiplicacion());
            configV.setMultiplicacion(1);
            VMain tmp = this.controlador.getvMain();
            tmp.getbF5().setText("F5 | Multiplicar");

        }
        
        
        if(buscaProducto(p[0],p[1])){
        
            if(configV.isVentaNueva()){ //Venta Nueva Abrir BD

                abrirVentaBD();
                //Aqui Imprime el encabezado
                //imprimeCabecera();

            }
//            //Aqui me quede para insertar el articulo, falta mandar la cantidad o la multiplicacion
            if(this.controlador.isIfcompartiva())
                cargaComparativa(p[0],Float.parseFloat(p[1]));
            insertaArticuloBD(p[0],Float.parseFloat(p[1]));
            limpiaICB();
            ajustaTotalesVista();
            
            System.out.println("Producto Encontrado");


        }else {
            /*
             * Aqui debe ir la parte de Tarjeta REX
             * 
             */
            System.out.println("Aqui Producto no encontrado");
                
            this.controlador.getVista().setVisible(false);
            this.controlador.mensajeVistaUnico(this.controlador.getVista(),"No existe el producto en BD","Busca Producto");
            this.controlador.getVista().setVisible(true);
                
            this.controlador.getvMain().gettICB().setText("");
            this.controlador.getvMain().gettICB().requestFocus();
        }
       
        configV.setChecarPrecio(false);
       
       
    }
    
    
    private void cancelaArticulo(){
       
       String [] p = new String[2];
       VMain tmp = this.controlador.getvMain();
       int numProductos=0;
       try{
            numProductos=configV.getCar().getNum_productos();
       }catch(Exception e){
           numProductos=0;
       }
       
       if(numProductos>0) {
       if(this.controlador.mensajeVistaDecision(tmp,"¿Desea Cancelar el Articulo?","Cancelar Articulo")==0) {
       
        

             int itemSeleccionado=tmp.gettArticulos().getSelectedRow();
             Item itemTmp= configV.getCar().getItems().get(itemSeleccionado);
             //System.out.println("Cantidad: "+itemTmp.getCantidad());
             if(itemTmp.getCantidad()>0 && itemTmp.getStatus()==1) {
                 p[0]=itemTmp.getIcb();
                 p[1]=String.valueOf(itemTmp.getCantidad()*-1);
                 this.agregaArticuloICB(p);
                 itemTmp.setStatus(0);
                 configV.getCar().getItems().set(itemSeleccionado, itemTmp);
                
             }else {
                 this.controlador.mensajeVista(tmp,"El articulo no puede ser cancelado","Cancelar Articulo");
             }    
        }
       
       }
       
        tmp.gettICB().requestFocus();    
        
        
        
    }
    
    
    private void cancelaVenta(){
        
        int i=0;
       String [] p = new String[2];
       VMain tmp = this.controlador.getvMain();
       int numProductos=0;
       try{
            numProductos=configV.getCar().getNum_productos();
       }catch(Exception e){
           numProductos=0;
       }
       
       if(numProductos>0){
       if(this.controlador.mensajeVistaDecision(tmp,"¿Desea Cancelar la Veta?","Cancelar Venta")==0) {
        
         for(i=0;i<configV.getCar().getNum_productos();i++){
            Item itemTmp  = configV.getCar().getItems().get(i);
            //System.out.println("Cantidad: "+itemTmp.getCantidad());
            if(itemTmp.getCantidad()>0 && itemTmp.getStatus()==1) {
                 p[0]=itemTmp.getIcb();
                 p[1]=String.valueOf(itemTmp.getCantidad()*-1);
                 this.agregaArticuloICB(p);
                 itemTmp.setStatus(0);
                 configV.getCar().getItems().set(i, itemTmp);
            }

         }
        }
       }
       tmp.gettICB().requestFocus();
        
        
        
    }
    
    
    
    
    
    private void repetirArticulo(){
        String [] p = new String[2];
        VMain tmp = this.controlador.getvMain();
       
        if(configV.getCar().getNum_productos()>0) {
       
            int itemSeleccionado=tmp.gettArticulos().getSelectedRow();
            Item itemTmp= configV.getCar().getItems().get(itemSeleccionado);

            if(itemTmp.getCantidad()>0) {
                p[0]=itemTmp.getIcb();
                p[1]=String.valueOf(itemTmp.getCantidad());
                this.agregaArticuloICB(p);
            } 
        }
    }
    
    
    
    private void multiplicarArticulo(){
       VMain tmp = this.controlador.getvMain();
       String regreso=JOptionPane.showInputDialog(tmp,"Multiplicacion","Multiplicacion",JOptionPane.ERROR_MESSAGE);
       float numero=0;
       System.out.println("Multiplicacion: "+regreso);
       
       try {
           
           numero = Float.valueOf(regreso);
           
       }catch(Exception e){
           
           numero=1;
           
       }
       
       if(numero>configV.getMaxMultiplicacion()){
           numero=1;
       }
       
       
       tmp.getbF5().setText("F5 | Multiplicar"+" x "+numero);
       
       configV.setMultiplicacion(numero);
       
       
    }
    
    
    
    private void checarPrecio(String [] p){
       
        
        VMain tmp = this.controlador.getvMain();
        
       if(this.buscaProducto(p[0],p[1])){
           
            if(this.controlador.mensajeVistaDecision(tmp,"El producto tiene el precio de : $"+configV.getLastItem().getPrecio()+"\n"+"¿Desea Agregarlo?","Verificar Precio")==0){
               
               ejecutaAccion("agregaArticuloICB",p);
               
            }else {
                
                
                this.configV.getCar().eliminaArticulo(this.configV.getCar().getItems().size()-1);
                this.configV.setLastItem(this.configV.getCar().getItems().get(this.configV.getCar().getItems().size()-1));
                
                
            }
            
           
           
           
       }
       
       
       
       tmp.getbF6().setForeground(Color.black);
       tmp.gettICB().setText("");
       tmp.gettICB().requestFocus();
       
       
    }
    
    
    
    
    
    public void ejecutaAccion(String accion){
        
        switch(accion){
            
            case "cancelaArticulo": cancelaArticulo();break;
            case "cancelaVenta": cancelaVenta();break;
            case "repetirArticulo": repetirArticulo();break;
            case "multiplicarArticulo": multiplicarArticulo();break;
                
            
        }
        
    }
    
    
    
    public void ejecutaAccion(String accion,String [] p){
        //this.getContGeneral().verificaPermiso(accion);
        
        //if(this.getContGeneral().isPermitido()){
            switch(accion){
               case "agregaArticuloICB": agregaArticuloICB(p);break;
               case "checarPrecio": checarPrecio(p);break;
                   

            }
        //}     
        
    }
    
    
    
    public void ejecutaAccion(String accion,HashMap<String, Object> p){
        
        
        switch(accion){
            //case "seleccionaDestino":   seleccionaDestino(p); break;
        }
        
       
        
    }
    
    
}
