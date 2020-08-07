/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.core.utils;

/**
 *
 * @author roberto
 */
public class Permiso {
    
    private int idPermiso=0;
    private String descPermiso="";
    private String aliasPermiso="";
    private int estatus=0;
    private int idSistema=0;
    private int idAccionModulo=0;
    private AccionModulo am=new AccionModulo();

    public Permiso() {
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getDescPermiso() {
        return descPermiso;
    }

    public void setDescPermiso(String descPermiso) {
        this.descPermiso = descPermiso;
    }

    public String getAliasPermiso() {
        return aliasPermiso;
    }

    public void setAliasPermiso(String aliasPermiso) {
        this.aliasPermiso = aliasPermiso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public int getIdAccionModulo() {
        return idAccionModulo;
    }

    public void setIdAccionModulo(int idAccionModulo) {
        this.idAccionModulo = idAccionModulo;
    }

    public AccionModulo getAm() {
        return am;
    }

    public void setAm(AccionModulo am) {
        this.am = am;
    }
    
    
    
    
    
}
