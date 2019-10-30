/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;
import com.t3b.pv.t3bcore.controller.ControladorG;
import com.t3b.pv.t3bcore.utils.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;





/**
 *
 * @author roberto
 */
public class ConfigV {
    
    
    private String properties=System.getProperty("user.dir")+File.separator+"config"+File.separator+"venta.properties";
    private Properties prop=null;
    private Config config;
    private Hashtable<String, String> ventasTag;
    private boolean ventaNueva=true;
    private boolean checarPrecio=false;
    private int numProductos=0;
    private Integer ultimoTicket=0;
    private Integer encId=0;
    private ControladorG itself;
    private Item lastItem;
    private Car car;
    private Car carComparativa;
    private boolean cancelacionPermiso=false;
    private float multiplicacion=1;
    private float maxMultiplicacion=0;
    private ArrayList <HashMap<String,String>> formasPago;
    private ArrayList <HashMap<String,String>> formasPagoHechos;
    private float cambio=0;
    private float totalEfectivo=0;
    private float totalEvale=0;
    private float totalVales=0;
    private float totalTC=0;
    private float totalTR=0;
    private int logIdEvale=0;
    private boolean cierreEvale=false;
    

    
    
    
    
    
    
    public ConfigV(Config c,ControladorG i){
        this.ventasTag = new Hashtable<String, String>();
        config=c;
        itself=i;
        cargaPropiedades();
        
        
    }
    
    
    public void iniciaVenta(){
        ventaNueva=false;
        checarPrecio=false;
        numProductos=0;
    }
    
    
    public void setVentaCerrada(){
        ventaNueva=true;
        checarPrecio=false;
        numProductos=0;
        cambio=0;
        Car carTmp = new Car();
        this.setCar(carTmp);
        this.setCarComparativa(carTmp);
        this.setTotalEfectivo(0);
        this.setTotalVales(0);
        this.setTotalEvale(0);
        this.setTotalTC(0);
        this.setTotalTR(0);
        logIdEvale=0;
        cierreEvale=false;
        
    }
    
     private void cargaPropiedadesLeng(){
        //System.out.println(config.getPathLeng()+config.getLeng()+"venta.properties");
        cargaPropiedades(properties);
        
       
        
    }
    
     
     private void cargaPropiedadesG(){
        
        cargaPropiedades(properties);
        
        if(prop.getProperty("CancelacionPermiso").equals("No"))
            cancelacionPermiso=false;
        else
            cancelacionPermiso=true;
        
        
        maxMultiplicacion=Float.parseFloat(prop.getProperty("MaxMultpilicacion"));
        
    }
    
    private void cargaPropiedades(){
        cargaPropiedadesG();
        cargaPropiedadesLeng();
    }
    
    
    private void cargaPropiedades(String archivo){
        
        prop = new Properties();
        try {
            prop.load(new FileInputStream(archivo));
            
            
        } catch (IOException ex) {
            //log.escribeLog("Error al cargar archivo de propiedades BD");
            
        }
        
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Hashtable<String, String> getVentasTag() {
        return ventasTag;
    }

    public void setVentasTag(Hashtable<String, String> ventasTag) {
        this.ventasTag = ventasTag;
    }

    public boolean isVentaNueva() {
        return ventaNueva;
    }

    public void setVentaNueva(boolean ventaNueva) {
        this.ventaNueva = ventaNueva;
    }

    public boolean isChecarPrecio() {
        return checarPrecio;
    }

    public void setChecarPrecio(boolean checarPrecio) {
        this.checarPrecio = checarPrecio;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public Integer getUltimoTicket() {
        return ultimoTicket;
    }

    public void setUltimoTicket(Integer ultimoTicket) {
        this.ultimoTicket = ultimoTicket;
    }

    public Integer getEncId() {
        return encId;
    }

    public void setEncId(Integer encId) {
        this.encId = encId;
    }

    public ControladorG getItself() {
        return itself;
    }

    public void setItself(ControladorG itself) {
        this.itself = itself;
    }

    public Item getLastItem() {
        return lastItem;
    }

    public void setLastItem(Item lastItem) {
        this.lastItem = lastItem;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isCancelacionPermiso() {
        return cancelacionPermiso;
    }

    public void setCancelacionPermiso(boolean cancelacionPermiso) {
        this.cancelacionPermiso = cancelacionPermiso;
    }

    public float getMultiplicacion() {
        return multiplicacion;
    }

    public void setMultiplicacion(float multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    public float getMaxMultiplicacion() {
        return maxMultiplicacion;
    }

    public void setMaxMultiplicacion(float maxMultiplicacion) {
        this.maxMultiplicacion = maxMultiplicacion;
    }

    public ArrayList <HashMap<String,String>> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(ArrayList <HashMap<String,String>> formasPago) {
        this.formasPago = formasPago;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }

    

    public ArrayList <HashMap<String,String>> getFormasPagoHechos() {
        return formasPagoHechos;
    }

    public void setFormasPagoHechos(ArrayList <HashMap<String,String>> formasPagoHechos) {
        this.formasPagoHechos = formasPagoHechos;
    }

    public float getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(float totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public float getTotalEvale() {
        return totalEvale;
    }

    public void setTotalEvale(float totalEvale) {
        this.totalEvale = totalEvale;
    }

    public float getTotalVales() {
        return totalVales;
    }

    public void setTotalVales(float totalVales) {
        this.totalVales = totalVales;
    }

    public float getTotalTC() {
        return totalTC;
    }

    public void setTotalTC(float totalTC) {
        this.totalTC = totalTC;
    }

    public float getTotalTR() {
        return totalTR;
    }

    public void setTotalTR(float totalTR) {
        this.totalTR = totalTR;
    }

    public Car getCarComparativa() {
        return carComparativa;
    }

    public void setCarComparativa(Car carComparativa) {
        this.carComparativa = carComparativa;
    }

    

    public int getLogIdEvale() {
        return logIdEvale;
    }

    public void setLogIdEvale(int logIdEvale) {
        this.logIdEvale = logIdEvale;
    }

    public boolean isCierreEvale() {
        return cierreEvale;
    }

    public void setCierreEvale(boolean cierreEvale) {
        this.cierreEvale = cierreEvale;
    }

    

    

    
    
    
    
    
}