/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.epagos.gui.main.ta;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.org.t3b.epagos.controller.ControladorTA;

/**
 *
 * @author uam_r
 */
public class ProductosTA extends javax.swing.JInternalFrame {

    private ControladorTA controller;
    private ArrayList <HashMap<String,String>> productos;
    
    public ProductosTA(ControladorTA controller) {
        this.controller = controller;
        initComponents();
    }
    
    
    public void agregaProductos(){
        int i = 0;
        HashMap<String,String> tmp = new HashMap<>();
        DefaultTableModel modelo=(DefaultTableModel) this.gettProductos().getModel(); 
        
        
        
        for(i=0;i<this.getProductos().size();i++){
            tmp=this.getProductos().get(i);
            String [] arregloDatos = new String[5];
            arregloDatos[0]=tmp.get("id_prod").toString();
            arregloDatos[1]=tmp.get("desc_art").toString();
            arregloDatos[2]=tmp.get("precio_venta").toString();
            arregloDatos[3]=tmp.get("metodo").toString();
            arregloDatos[4]=tmp.get("codigo_barras").toString();
            
            modelo.addRow(arregloDatos);
            
        }
        
    }
    
    
    
    /**
     * Creates new form ProductosTA
     */
    public ProductosTA() {
        initComponents();
    }

    public ControladorTA getController() {
        return controller;
    }

    public void setController(ControladorTA controller) {
        this.controller = controller;
    }

    public ArrayList<HashMap<String, String>> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<HashMap<String, String>> productos) {
        this.productos = productos;
    }

    public JToolBar gettVentaTA() {
        return tVentaTA;
    }

    public void settVentaTA(JToolBar tVentaTA) {
        this.tVentaTA = tVentaTA;
    }

    public JTable gettProductos() {
        return tProductos;
    }

    public void settProductos(JTable tProductos) {
        this.tProductos = tProductos;
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tVentaTA = new javax.swing.JToolBar();
        lTienda = new javax.swing.JLabel();
        lCaja = new javax.swing.JLabel();
        lInternet = new javax.swing.JLabel();
        lFecha = new javax.swing.JLabel();
        lVersion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        tVentaTA.setRollover(true);

        lTienda.setText("Tienda: 1     ");
        tVentaTA.add(lTienda);

        lCaja.setText("Caja: 01    ");
        tVentaTA.add(lCaja);

        lInternet.setText("Internet: Si   ");
        tVentaTA.add(lInternet);

        lFecha.setText("Fecha: 2020-05-09   ");
        tVentaTA.add(lFecha);

        lVersion.setText("Version: 1.0");
        tVentaTA.add(lVersion);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona Producto"));

        tProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iclave", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tProductos);
        if (tProductos.getColumnModel().getColumnCount() > 0) {
            tProductos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tProductos.getColumnModel().getColumn(1).setPreferredWidth(25);
            tProductos.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Esc | Cancelar");

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("F1 | Seleccionar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tVentaTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tVentaTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCaja;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lInternet;
    private javax.swing.JLabel lTienda;
    private javax.swing.JLabel lVersion;
    private javax.swing.JTable tProductos;
    private javax.swing.JToolBar tVentaTA;
    // End of variables declaration//GEN-END:variables
}