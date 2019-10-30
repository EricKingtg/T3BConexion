/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;

/**
 *
 * @author roberto
 */
public class Item {
    
    private int iclave;
    private String icb;
    private float precio;
    private String descCompleta;
    private String descTicket;
    private float factorIVA=0;
    private float factorIEPS=0;
    private float cantidad;
    private float total=0;
    private String pathImagen;
    private String desCortaMP;
    private int status=1;
    private int prov_id=0;
    
    
    public Item(){
        
    }
    
    public Item(int iclavep,String icbp,float preciop,String descCompletap,String descTicketp,float factorIVAp,float factorIEPSp,float cantidadp,int prov_idp){
        
        iclave=iclavep;
        icb=icbp;
        precio=preciop;
        descCompleta=descCompletap;
        descTicket=descTicketp;
        factorIVA=factorIVAp;
        factorIEPS=factorIEPSp;
        cantidad=cantidadp;
        total=cantidad*precio;
        prov_id=prov_idp;
        
    }
    
    
    public Item(int iclavep,String path,String desc,float preciop,float cantidadp){
        
        iclave=iclavep;
        precio=preciop;
        cantidad=cantidadp;
        total=cantidad*precio;
        pathImagen=path;
        desCortaMP=desc;
        
    }
    
    
    

    public int getIclave() {
        return iclave;
    }

    public void setIclave(int iclave) {
        this.iclave = iclave;
    }

    public String getIcb() {
        return icb;
    }

    public void setIcb(String icb) {
        this.icb = icb;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescCompleta() {
        return descCompleta;
    }

    public void setDescCompleta(String descCompleta) {
        this.descCompleta = descCompleta;
    }

    public String getDescTicket() {
        return descTicket;
    }

    public void setDescTicket(String descTicket) {
        this.descTicket = descTicket;
    }

    public float getFactorIVA() {
        return factorIVA;
    }

    public void setFactorIVA(float factorIVA) {
        this.factorIVA = factorIVA;
    }

    public float getFactorIEPS() {
        return factorIEPS;
    }

    public void setFactorIEPS(float factorIEPS) {
        this.factorIEPS = factorIEPS;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getDesCortaMP() {
        return desCortaMP;
    }

    public void setDesCortaMP(String desCortaMP) {
        this.desCortaMP = desCortaMP;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }
    
    
    
    
    
}
