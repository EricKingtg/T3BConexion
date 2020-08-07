/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.utils;

import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public class Car {
    
    private int num_productos=0;
    private int numProductosReales=0;
    private float total=0;
    private float iva=0;
    private float ieps=0;
    private int userId=0;
    private String tclave="";
    private String caja="";
    private String numTicket="";
    private int encId=0;
    private ArrayList <Item> items= new ArrayList <Item> ();
    
    
    public Car(){
        
    }

    
    public void iniciaCar(int userIdp,String tclavep,String cajap,String numTicketp,int encIdp){
        num_productos=0;
        userId=userIdp;
        tclave=tclavep;
        caja=cajap;
        numTicket=numTicketp;
        encId=encIdp;
    }
    
    
    private void calculaTotales(Item item,boolean suma){
        
        
        if(suma==true) {
            this.num_productos++;
            this.numProductosReales=this.numProductosReales+(int)item.getCantidad();
            total=total+item.getTotal();
            iva=iva+(item.getTotal()*item.getFactorIVA());
            ieps=ieps+(item.getFactorIEPS()*item.getFactorIEPS());
            
        }else {
            this.num_productos--;
            this.numProductosReales=this.numProductosReales-(int)item.getCantidad();
            total=total-item.getTotal();
            iva=iva-(item.getTotal()*item.getFactorIVA());
            ieps=ieps-(item.getFactorIEPS()*item.getFactorIEPS());
        }
        if(total<0)
            total=(-1)*total;
        
    }
    
    
    public void agregaArticulo(Item itemTmp){
        
        calculaTotales(itemTmp,true);
        items.add(itemTmp);
        
        
    }
    
    
    private int buscaItem(Item itemTmp){
        
        
        int i=0,regresa=-1;
        
        for(i=0;i<items.size();i++){
            Item tmp2;
            tmp2=items.get(i);
            if(tmp2.getIclave()==itemTmp.getIclave()){
                regresa=i;
                break;
            }
            
        }
        
        
        
        return regresa;
    }
    
    
    public void reemplazaItem(int index,Item itemTmp){
        Item tmp2,nuevo;
        tmp2=items.get(index);
        
        nuevo=new Item(tmp2.getIclave(),tmp2.getPathImagen(),tmp2.getDesCortaMP(),tmp2.getPrecio(),tmp2.getCantidad()+itemTmp.getCantidad());
        items.set(index, nuevo);
        
        
    }
    
    
    
    public void agregaArticuloComparativa(Item itemTmp){
        int posicion=0;
        calculaTotales(itemTmp,true);
        
        if((posicion=buscaItem(itemTmp))==-1){
            items.add(itemTmp);
        }else {
            reemplazaItem(posicion,itemTmp);
        }        
        
        
    }
    
    
    
    public void eliminaArticulo(int indice){
        calculaTotales(items.get(indice),false);
        items.remove(indice);
        
    }
    
    
    
    public int getNum_productos() {
        return num_productos;
    }

    public void setNum_productos(int num_productos) {
        this.num_productos = num_productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getIeps() {
        return ieps;
    }

    public void setIeps(float ieps) {
        this.ieps = ieps;
    }

    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTclave() {
        return tclave;
    }

    public void setTclave(String tclave) {
        this.tclave = tclave;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public int getEncId() {
        return encId;
    }

    public void setEncId(int encId) {
        this.encId = encId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getNumProductosReales() {
        return numProductosReales;
    }

    public void setNumProductosReales(int numProductosReales) {
        this.numProductosReales = numProductosReales;
    }

   
    
    
    
    
    
    
    
}
