/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;


import javax.swing.table.DefaultTableModel;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class MyTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}