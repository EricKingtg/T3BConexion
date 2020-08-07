/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.log.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;












public class Logger3B
{
    static  {
      if (!Config.isLoaded) {
        Config.loadConfig();
      }
      verificaRuta();
    }


    public static void Log(int tipoError, String app, String clase, String metodo, String ex) {
      FileWriter fw = null;
      PrintWriter pw = null;
      try {
        String nomArchLog = Config.rutaArchLog.replaceAll("-", app);
        fw = new FileWriter(nomArchLog, true);
        pw = new PrintWriter(fw);
        String sTipoError = "[" + obtieneFecha() + "]:" + Config.class.getField("tipoError" + tipoError).get(Config.class.getField("tipoError" + tipoError)).toString();
        sTipoError = sTipoError + ": Applicacion: " + app + " Clase: " + clase + " Metodo: " + metodo + " " + Config.class.getField("tipoError" + tipoError).get(Config.class.getField("tipoError" + tipoError)).toString() + ": " + ex;
        pw.write(sTipoError + "\n");
      } catch (Exception e) {
        System.out.println("Excepcion e: " + e.getMessage());
      } finally {
        try {
          if (fw != null) {
            fw.close();
          }
          if (pw != null)
            pw.close(); 
        } catch (IOException ex1) {
          System.out.println("Excepcion e: " + ex1.getMessage());
        } 
      } 
    }


 
    public static void Log(int tipoError, String ex) {
      FileWriter fw = null;
      PrintWriter pw = null;
      try {
        fw = new FileWriter(Config.rutaArchLog, true);
        pw = new PrintWriter(fw);
        String sTipoError = "[" + obtieneFecha() + "]:" + Config.class.getField("tipoError" + tipoError).get(Config.class.getField("tipoError" + tipoError)).toString();
        sTipoError = sTipoError + " Excepcion: " + ex;
        pw.write(sTipoError + "\n");
      } catch (Exception e) {
        System.out.println("Excepcion e: " + e.getMessage());
      } finally {
        try {
          if (fw != null) {
            fw.close();
          }
          if (pw != null)
            pw.close(); 
        } catch (IOException ex1) {
          System.out.println("Excepcion e: " + ex1.getMessage());
        } 
      } 
    }
  
    public static void Log(int tipoError, String app, String ex) {
      FileWriter fw = null;
      PrintWriter pw = null;
      try {
        String nomArchLog = Config.rutaArchLog.replaceAll("-", app);
        fw = new FileWriter(nomArchLog, true);
        pw = new PrintWriter(fw);
        String sTipoError = "[" + obtieneFecha() + "]:" + Config.class.getField("tipoError" + tipoError).get(Config.class.getField("tipoError" + tipoError)).toString();
        sTipoError = sTipoError + ": Applicacion: " + app + " Excepcion: " + ex;
        pw.write(sTipoError + "\n");
      } catch (Exception e) {
        System.out.println("Excepcion e: " + e.getMessage());
      } finally {
        try {
          if (fw != null) {
            fw.close();
          }
          if (pw != null)
            pw.close(); 
        } catch (IOException ex1) {
          System.out.println("Excepcion e: " + ex1.getMessage());
        } 
      } 
    }
  
    public static void Log(int tipoError, String app, String clase, String ex) {
      FileWriter fw = null;
      PrintWriter pw = null;
      try {
        String nomArchLog = Config.rutaArchLog.replaceAll("-", app);
        fw = new FileWriter(nomArchLog, true);
        pw = new PrintWriter(fw);
        String sTipoError = "[" + obtieneFecha() + "]:" + Config.class.getField("tipoError" + tipoError).get(Config.class.getField("tipoError" + tipoError)).toString();
        sTipoError = sTipoError + ": Applicacion: " + app + " Clase: " + clase + " Excepcion: " + ex;
        pw.write(sTipoError + "\n");
      } catch (Exception e) {
        System.out.println("Excepcion e: " + e.getMessage());
      } finally {
        try {
          if (fw != null) {
            fw.close();
          }
          if (pw != null)
            pw.close(); 
        } catch (IOException ex1) {
          System.out.println("Excepcion e: " + ex1.getMessage());
        } 
      } 
    }




    private static void verificaRuta() {
      File carpeta = null;
      try {
        carpeta = new File(System.getProperty("user.dir") + File.separator + "LOG");
        if (!carpeta.exists()) {
          carpeta.mkdir();
        }
      } catch (Exception ex) {
        System.out.println("Excepcion e: " + ex.getMessage());
      } finally {
        carpeta = null;
      } 
    }



    private static String obtieneFecha() {
      SimpleDateFormat formato = new SimpleDateFormat();
      formato.applyPattern("dd/MM/yyyy HH:mm:ss z");
      return formato.format(new Date());
    }
}
