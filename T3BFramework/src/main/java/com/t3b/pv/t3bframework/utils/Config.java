/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bframework.utils;

import com.t3b.pv.t3bcore.utils.AccionModulo;
import com.t3b.pv.t3bcore.utils.Perfil;
import com.t3b.pv.t3bcore.utils.Permiso;
import com.t3b.pv.t3bcore.utils.PermisoPerfil;
import com.t3b.pv.t3bcore.utils.Usuario;
import com.t3b.pv.t3blog.utils.Logger3B;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


/**
 *
 * @author daniel
 */
public class Config {
    
    public static String nomarch = System.getProperty("user.dir")+File.separator+"config"+File.separator+"t3bframework.properties";
    public static String nomArchLog = System.getProperty("user.dir")+File.separator+"LOG"+File.separator+"T3BFramework.log";
    
    public static String dbUser = "";
    public static String dbPass = "";
    public static String dbHost = "";
    public static String dbPort = "";
    public static String dbName = "";
    public static String dbClassDriver = "";
    public static String dbUrl = "";
    
    public static String appName = "";
    public static String appDvlp = "";
    public static String appOwne = "";
    
    public static String jars = "";
    public static String njars = "";
    public static String moduloInicio="";
    public static String metodoInicio="";
    public static String paramInicio="";
    public static String sistema="";
    public static String id_sistema="";
    public static int idUser=0;
    
    public static Usuario usuario=new Usuario();
    public static Perfil perfil=new Perfil();
    public static ArrayList <AccionModulo> accionModulos = new ArrayList<>();
    public static ArrayList <PermisoPerfil> permisoPerfiles=new ArrayList<>();
    public static ArrayList <Permiso> permisos = new ArrayList<>();
    public static boolean configCargada = false;
    public static ConfigPV configPV;
    public static String pvConf;
    
    
    
    
    
    
    
    /**
     * Metodo para cargar la configuracion para la aplicacion
     * @return 
     */
    public static boolean cargaConfig(){
        boolean flag = true;
        try{
            Properties props = new Properties();
            props.load(new FileInputStream(nomarch));
            if(props != null){
                dbUser          = props.getProperty("dbUser") != null?props.getProperty("dbUser"):"";
                dbPass          = props.getProperty("dbPass") != null?props.getProperty("dbPass"):"";
                dbHost          = props.getProperty("dbHost") != null?props.getProperty("dbHost"):"";
                dbPort          = props.getProperty("dbPort") != null?props.getProperty("dbPort"):"";
                dbName          = props.getProperty("dbName") != null?props.getProperty("dbName"):"";
                dbClassDriver   = props.getProperty("dbClassDriver") != null?props.getProperty("dbClassDriver"):"";
                dbUrl           = props.getProperty("dbUrl") != null?props.getProperty("dbUrl"):"";
                appName         = props.getProperty("appName") != null?props.getProperty("appName"):"";
                appDvlp         = props.getProperty("appDvlp") != null?props.getProperty("appDvlp"):"";
                appOwne         = props.getProperty("appOwne") != null?props.getProperty("appOwne"):"";
                jars            = props.getProperty("jars") != null?props.getProperty("jars"):"";
                njars            = props.getProperty("njars") != null?props.getProperty("njars"):"";
                moduloInicio            = props.getProperty("moduloInicio") != null?props.getProperty("moduloInicio"):"";
                metodoInicio            = props.getProperty("metodoInicio") != null?props.getProperty("metodoInicio"):"";
                paramInicio            = props.getProperty("paramInicio") != null?props.getProperty("paramInicio"):"";
                sistema            = props.getProperty("sistema") != null?props.getProperty("sistema"):"";
                id_sistema            = props.getProperty("id_sistema") != null?props.getProperty("id_sistema"):"";
                pvConf  = props.getProperty("pvConf") != null?props.getProperty("pvConf"):"";
                 
                
                
                if(id_sistema.equals("1")){
                    configPV =  new ConfigPV(pvConf);
                }
                
                configCargada = true;
            }
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", "t3b.appalmacen.utils.Config", "cargaConfig", ex.getMessage());
            configCargada = false;
        }
        return flag;
    }
    
    /**
     * Metodo para saber si la configuracion esta cargada
     * @return 
     */
    public static boolean existeConfig(){
        return new File(nomarch).exists() && new File(nomarch).isFile();
    }
    
    /**
     * Metodo que devuelve la configuracion para el resto de las aplicaciones/ventanas
     * requiere tener los campos como cadenas, se llame como se 
     * @param dtoConfig
     * @return 
     */
    public static Object devuelveConfiguracion(Object dtoConfig){
        try{
            if(dtoConfig != null){
                dtoConfig.getClass().getField("dbUser").set(dtoConfig, dbUser);
                dtoConfig.getClass().getField("dbPass").set(dtoConfig, dbPass);
                dtoConfig.getClass().getField("dbHost").set(dtoConfig, dbHost);
                dtoConfig.getClass().getField("dbPort").set(dtoConfig, dbPort);
                dtoConfig.getClass().getField("dbName").set(dtoConfig, dbName);
                dtoConfig.getClass().getField("dbClassDriver").set(dtoConfig, dbClassDriver);
                dtoConfig.getClass().getField("appName").set(dtoConfig, appName);
                dtoConfig.getClass().getField("appDvlp").set(dtoConfig, appDvlp);
                dtoConfig.getClass().getField("appOwne").set(dtoConfig, appOwne);
                dtoConfig.getClass().getField("dbUrl").set(dtoConfig, dbUrl);
            }
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", "t3b.appalmacen.utils.Config", "devuelveConfiguracion", ex.getMessage());
            dtoConfig = null;
        }finally{
            return dtoConfig;
        }
    }
    
    
    public static HashMap<String, String> devuelveConfiguracion(){
        HashMap<String, String> dtoConfig = new HashMap();
        try{
            dtoConfig.put("dbUser", dbUser);
            dtoConfig.put("dbPass", dbPass);
            dtoConfig.put("dbHost", dbHost);
            dtoConfig.put("dbPort", dbPort);
            dtoConfig.put("dbName", dbName);
            dtoConfig.put("dbClassDriver", dbClassDriver);
            dtoConfig.put("appName", appName);
            dtoConfig.put("appDvlp", appDvlp);
            dtoConfig.put("appOwne", appOwne);            
            dtoConfig.put("dbUrl", dbUrl);    
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", "t3b.appalmacen.utils.Config", "devuelveConfiguracion", ex.getMessage());
            dtoConfig = null;
        }
        return dtoConfig;
        
    }
    
    
    
    
}
