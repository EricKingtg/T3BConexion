/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;










public class Config
{
    public static String archConfig = System.getProperty("user.dir") + File.separator + "config" + File.separator + "log3B.properties";

    public static String rutaArchLog = "";
    public static String tipoError1 = "";
    public static String tipoError2 = "";
    public static String tipoError3 = "";
    


    public static boolean isLoaded = false;


    public static void loadConfig() {
      Properties props = null;
      try {
        props = new Properties();
        props.load(new FileInputStream(archConfig));
        rutaArchLog = System.getProperty("user.dir") + File.separator + props.getProperty("RUTARCHLOG");
        tipoError1 = props.getProperty("tipoError1");
        tipoError2 = props.getProperty("tipoError2");
        tipoError3 = props.getProperty("tipoError3");
        isLoaded = true;
      } catch (Exception ex) {
        System.out.println("Error ex: " + ex.getMessage());
        ex.printStackTrace();
      } 
    }
}
