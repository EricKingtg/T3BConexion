/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bcore.utils;

/**
 *
 * @author roberto
 */
public class Perfil {
    
    private int idPerfil=0;
    private String descPerfil="";
    private String aliasPerfil="";
    private int estatus=0;

    public Perfil() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    public String getAliasPerfil() {
        return aliasPerfil;
    }

    public void setAliasPerfil(String aliasPerfil) {
        this.aliasPerfil = aliasPerfil;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
