/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.gui.main;

import com.org.t3b.core.gui.VPantalla;
import com.org.t3b.venta.controller.Controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 *
 * @author roberto
 */
public class VMain extends VPantalla implements KeyListener{

    /**
     * Creates new form VMain
     */
    public VMain() {
        initComponents();
    }
    
    public VMain(Controlador c,HashMap<String, Object> p) {
        super(c, p);
        try {
            initComponents();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        iniciaListener();
    }

    private void iniciaListener(){
        this.tICB.addKeyListener(this);
        this.addKeyListener(this);
    }

    public JButton getbEsc() {
        return bEsc;
    }

    public void setbEsc(JButton bEsc) {
        this.bEsc = bEsc;
    }

    public JButton getbF1() {
        return bF1;
    }

    public void setbF1(JButton bF1) {
        this.bF1 = bF1;
    }

    public JButton getbF10() {
        return bF10;
    }

    public void setbF10(JButton bF10) {
        this.bF10 = bF10;
    }

    public JButton getbF11() {
        return bF11;
    }

    public void setbF11(JButton bF11) {
        this.bF11 = bF11;
    }

    public JButton getbF2() {
        return bF2;
    }

    public void setbF2(JButton bF2) {
        this.bF2 = bF2;
    }

    public JButton getbF3() {
        return bF3;
    }

    public void setbF3(JButton bF3) {
        this.bF3 = bF3;
    }

    public JButton getbF4() {
        return bF4;
    }

    public void setbF4(JButton bF4) {
        this.bF4 = bF4;
    }

    public JButton getbF5() {
        return bF5;
    }

    public void setbF5(JButton bF5) {
        this.bF5 = bF5;
    }

    public JButton getbF6() {
        return bF6;
    }

    public void setbF6(JButton bF6) {
        this.bF6 = bF6;
    }

    public JButton getbF7() {
        return bF7;
    }

    public void setbF7(JButton bF7) {
        this.bF7 = bF7;
    }

    public JButton getbF8() {
        return bF8;
    }

    public void setbF8(JButton bF8) {
        this.bF8 = bF8;
    }

    public JButton getbF9() {
        return bF9;
    }

    public void setbF9(JButton bF9) {
        this.bF9 = bF9;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getlImagen() {
        return lImagen;
    }

    public void setlImagen(JLabel jLabel3) {
        this.lImagen = jLabel3;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel10() {
        return jPanel10;
    }

    public void setjPanel10(JPanel jPanel10) {
        this.jPanel10 = jPanel10;
    }

    public JPanel getjPanel11() {
        return jPanel11;
    }

    public void setjPanel11(JPanel jPanel11) {
        this.jPanel11 = jPanel11;
    }

    public JPanel getjPanel12() {
        return jPanel12;
    }

    public void setjPanel12(JPanel jPanel12) {
        this.jPanel12 = jPanel12;
    }

    public JPanel getjPanel13() {
        return jPanel13;
    }

    public void setjPanel13(JPanel jPanel13) {
        this.jPanel13 = jPanel13;
    }

    public JPanel getjPanel14() {
        return jPanel14;
    }

    public void setjPanel14(JPanel jPanel14) {
        this.jPanel14 = jPanel14;
    }

    public JPanel getjPanel15() {
        return jPanel15;
    }

    public void setjPanel15(JPanel jPanel15) {
        this.jPanel15 = jPanel15;
    }

    public JPanel getjPanel16() {
        return jPanel16;
    }

    public void setjPanel16(JPanel jPanel16) {
        this.jPanel16 = jPanel16;
    }

    public JPanel getjPanel17() {
        return jPanel17;
    }

    public void setjPanel17(JPanel jPanel17) {
        this.jPanel17 = jPanel17;
    }

    public JPanel getjPanel18() {
        return jPanel18;
    }

    public void setjPanel18(JPanel jPanel18) {
        this.jPanel18 = jPanel18;
    }

    public JPanel getjPanel19() {
        return jPanel19;
    }

    public void setjPanel19(JPanel jPanel19) {
        this.jPanel19 = jPanel19;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel20() {
        return jPanel20;
    }

    public void setjPanel20(JPanel jPanel20) {
        this.jPanel20 = jPanel20;
    }

    public JPanel getjPanel21() {
        return jPanel21;
    }

    public void setjPanel21(JPanel jPanel21) {
        this.jPanel21 = jPanel21;
    }

    public JPanel getjPanel22() {
        return jPanel22;
    }

    public void setjPanel22(JPanel jPanel22) {
        this.jPanel22 = jPanel22;
    }

    public JPanel getjPanel23() {
        return jPanel23;
    }

    public void setjPanel23(JPanel jPanel23) {
        this.jPanel23 = jPanel23;
    }

    public JPanel getjPanel24() {
        return jPanel24;
    }

    public void setjPanel24(JPanel jPanel24) {
        this.jPanel24 = jPanel24;
    }

    public JPanel getjPanel25() {
        return jPanel25;
    }

    public void setjPanel25(JPanel jPanel25) {
        this.jPanel25 = jPanel25;
    }

    public JPanel getjPanel26() {
        return jPanel26;
    }

    public void setjPanel26(JPanel jPanel26) {
        this.jPanel26 = jPanel26;
    }

    public JPanel getjPanel27() {
        return jPanel27;
    }

    public void setjPanel27(JPanel jPanel27) {
        this.jPanel27 = jPanel27;
    }

    public JPanel getjPanel28() {
        return jPanel28;
    }

    public void setjPanel28(JPanel jPanel28) {
        this.jPanel28 = jPanel28;
    }

    public JPanel getjPanel29() {
        return jPanel29;
    }

    public void setjPanel29(JPanel jPanel29) {
        this.jPanel29 = jPanel29;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel30() {
        return jPanel30;
    }

    public void setjPanel30(JPanel jPanel30) {
        this.jPanel30 = jPanel30;
    }

    public JPanel getjPanel31() {
        return jPanel31;
    }

    public void setjPanel31(JPanel jPanel31) {
        this.jPanel31 = jPanel31;
    }

    public JPanel getjPanel32() {
        return jPanel32;
    }

    public void setjPanel32(JPanel jPanel32) {
        this.jPanel32 = jPanel32;
    }

    public JPanel getjPanel33() {
        return jPanel33;
    }

    public void setjPanel33(JPanel jPanel33) {
        this.jPanel33 = jPanel33;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    public JPanel getjPanel9() {
        return jPanel9;
    }

    public void setjPanel9(JPanel jPanel9) {
        this.jPanel9 = jPanel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JLabel getlAhorra() {
        return lAhorra;
    }

    public void setlAhorra(JLabel lAhorra) {
        this.lAhorra = lAhorra;
    }

    public JTextPane getlAnuncio1() {
        return lAnuncio1;
    }

    public void setlAnuncio1(JTextPane lAnuncio1) {
        this.lAnuncio1 = lAnuncio1;
    }

    public JLabel getlAnuncio2() {
        return lAnuncio2;
    }

    public void setlAnuncio2(JLabel lAnuncio2) {
        this.lAnuncio2 = lAnuncio2;
    }

    public JLabel getlAnuncio3() {
        return lAnuncio3;
    }

    public void setlAnuncio3(JLabel lAnuncio3) {
        this.lAnuncio3 = lAnuncio3;
    }

    public JTextPane getlAnuncio4() {
        return lAnuncio4;
    }

    public void setlAnuncio4(JTextPane lAnuncio4) {
        this.lAnuncio4 = lAnuncio4;
    }

    public JLabel getlTotal() {
        return lTotal;
    }

    public void setlTotal(JLabel lTotal) {
        this.lTotal = lTotal;
    }

    public JTable gettArticulos() {
        return tArticulos;
    }

    public void settArticulos(JTable tArticulos) {
        this.tArticulos = tArticulos;
    }

    public JTextField gettICB() {
        return tICB;
    }

    public void settICB(JTextField tICB) {
        this.tICB = tICB;
    }
    
    

    
    
    private void agregarArticuloICB(){
        
        String [] parametros = new String[30];
        Controlador venta = (Controlador)this.getControlador();
        parametros[0]=this.tICB.getText();
        parametros[1]="1";
        
        if(!venta.getConfigV().isChecarPrecio()) {
            venta.ejecutaAccion("Venta","agregaArticuloICB", parametros);
        }else{
            bF6.setForeground(Color.white);
            venta.ejecutaAccion("Venta","checarPrecio",parametros);
        }
    }
    
    private void f2CancelaArticulo(){
       
        Controlador tmp = (Controlador)this.getControlador();
        tmp.ejecutaAccion("Venta","cancelaArticulo");
           
    }
    
    
    private void f3CancelaVenta(){
          
        Controlador tmp = (Controlador)this.getControlador();
        tmp.ejecutaAccion("Venta","cancelaVenta");
               
    }
    
    private void f4RepetirArticulo(){
        
        Controlador tmp = (Controlador)this.getControlador();
        tmp.ejecutaAccion("Venta","repetirArticulo");
        
    }
    
    private void f5MultiplicarArticulo(){
        Controlador tmp = (Controlador)this.getControlador();
        tmp.ejecutaAccion("Venta","multiplicarArticulo");
    }
    
    private void f6ChecarPrecio(){
        Controlador tmp = (Controlador)this.getControlador();
        tmp.getConfigV().setChecarPrecio(true);
        bF6.setForeground(Color.red);
    }
    
    private void f12Buscar(){
        Controlador tmp = (Controlador)this.getControlador();
        tmp.ejecutaAccion("Busqueda","showBusqueda");
    }
    
    private void f1CierraVenta(){
        Controlador controlador = (Controlador)this.getControlador();
        if(controlador.getConfigV().getCar().getNum_productos()>0 && this.tArticulos.getRowCount()>0){
            Controlador tmp = (Controlador)this.getControlador();
            tmp.ejecutaAccion("Cierre","showCierraVenta");
        }
    }
    
    private void f10TA(){
        
        Controlador controlador = (Controlador)this.getControlador();
        
        try {
            
            if(controlador.getConfigV().getCar().getNum_productos()==0 && this.tArticulos.getRowCount()==0){

                Controlador tmp = (Controlador)this.getControlador();
                tmp.ejecutaAccion("cierraPantallaVenta");
                tmp.getContGeneral().ejecutaAccion("pv.t3bepagos","showTA",new String [1],tmp);
                //this.getContGeneral().ejecutaAccion(parametros[0],parametros[1], p, this);
            }
        
        }catch(Exception e){
            
            Controlador tmp = (Controlador)this.getControlador();
            tmp.ejecutaAccion("cierraPantallaVenta");
            tmp.getContGeneral().ejecutaAccion("pv.t3bepagos","showTA",new String [1],tmp);
            
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tICB = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tArticulos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lTotal = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        bF1 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        bF2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bF3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        bF4 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        bF5 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        bF6 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        bF7 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        bF8 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        bF9 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        bF10 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        bF11 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        bEsc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lImagen = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lAnuncio1 = new javax.swing.JTextPane();
        jPanel14 = new javax.swing.JPanel();
        lAhorra = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lAnuncio2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lAnuncio3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lAnuncio4 = new javax.swing.JTextPane();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setMaximumSize(new java.awt.Dimension(330, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(330, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 671));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(330, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(330, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(330, 50));

        jLabel1.setText("Codigo");

        jButton1.setText("F12 | Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(tICB, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tICB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jPanel4.setMinimumSize(new java.awt.Dimension(19, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(337, 200));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Articulo", "Cant", "PrecioU", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tArticulos);
        if (tArticulos.getColumnModel().getColumnCount() > 0) {
            tArticulos.getColumnModel().getColumn(0).setResizable(false);
            tArticulos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tArticulos.getColumnModel().getColumn(1).setResizable(false);
            tArticulos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tArticulos.getColumnModel().getColumn(2).setResizable(false);
            tArticulos.getColumnModel().getColumn(2).setPreferredWidth(10);
            tArticulos.getColumnModel().getColumn(3).setResizable(false);
            tArticulos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tArticulos.getColumnModel().getColumn(4).setResizable(false);
            tArticulos.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 110));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 110));
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 110));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        jPanel6.setPreferredSize(new java.awt.Dimension(346, 130));

        lTotal.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        lTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotal.setText("$ 00.00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        jPanel10.setMaximumSize(new java.awt.Dimension(340, 300));
        jPanel10.setMinimumSize(new java.awt.Dimension(340, 300));
        jPanel10.setPreferredSize(new java.awt.Dimension(340, 300));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        jPanel18.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel18.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel18.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.X_AXIS));

        jPanel24.setMaximumSize(new java.awt.Dimension(160, 48));
        jPanel24.setMinimumSize(new java.awt.Dimension(160, 40));
        jPanel24.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanel24.setLayout(new java.awt.BorderLayout());

        bF1.setText("F1 | Cerrar Venta");
        bF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF1ActionPerformed(evt);
            }
        });
        jPanel24.add(bF1, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel24);

        jPanel25.setMaximumSize(new java.awt.Dimension(160, 48));
        jPanel25.setMinimumSize(new java.awt.Dimension(160, 48));
        jPanel25.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanel25.setLayout(new java.awt.BorderLayout());

        bF2.setText("F2 |Cancelar Articulo");
        bF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF2ActionPerformed(evt);
            }
        });
        jPanel25.add(bF2, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel25);

        jPanel10.add(jPanel18);

        jPanel19.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel19.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel19.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.X_AXIS));

        jPanel7.setMaximumSize(new java.awt.Dimension(160, 48));
        jPanel7.setMinimumSize(new java.awt.Dimension(160, 48));
        jPanel7.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanel7.setLayout(new java.awt.BorderLayout());

        bF3.setText("F3 | Cancelar Venta");
        bF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF3ActionPerformed(evt);
            }
        });
        jPanel7.add(bF3, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel7);

        jPanel8.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel8.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel8.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel8.setLayout(new java.awt.BorderLayout());

        bF4.setText("F4 | Repetir Articulo");
        bF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF4ActionPerformed(evt);
            }
        });
        jPanel8.add(bF4, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel8);

        jPanel10.add(jPanel19);

        jPanel20.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel20.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel20.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.X_AXIS));

        jPanel26.setMaximumSize(new java.awt.Dimension(160, 48));
        jPanel26.setMinimumSize(new java.awt.Dimension(160, 48));
        jPanel26.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanel26.setLayout(new java.awt.BorderLayout());

        bF5.setText("F5 | Multiplicar");
        bF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF5ActionPerformed(evt);
            }
        });
        jPanel26.add(bF5, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel26);

        jPanel27.setMaximumSize(new java.awt.Dimension(160, 48));
        jPanel27.setMinimumSize(new java.awt.Dimension(160, 48));
        jPanel27.setName(""); // NOI18N
        jPanel27.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanel27.setLayout(new java.awt.BorderLayout());

        bF6.setText("F6 | Checar Precio");
        bF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF6ActionPerformed(evt);
            }
        });
        jPanel27.add(bF6, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel27);

        jPanel10.add(jPanel20);

        jPanel22.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel22.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel22.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.X_AXIS));

        jPanel28.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel28.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel28.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel28.setLayout(new java.awt.BorderLayout());

        bF7.setText("F7 | Operaciones");
        jPanel28.add(bF7, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel28);

        jPanel29.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel29.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel29.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel29.setLayout(new java.awt.BorderLayout());

        bF8.setText("F8 | Abrir Cajon");
        jPanel29.add(bF8, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel29);

        jPanel10.add(jPanel22);

        jPanel23.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel23.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel23.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.X_AXIS));

        jPanel30.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel30.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel30.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel30.setLayout(new java.awt.BorderLayout());

        bF9.setText("F9 | Servicios");
        jPanel30.add(bF9, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel30);

        jPanel31.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel31.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel31.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel31.setLayout(new java.awt.BorderLayout());

        bF10.setText("F10 | Tiempo Aire");
        bF10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bF10ActionPerformed(evt);
            }
        });
        jPanel31.add(bF10, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel31);

        jPanel10.add(jPanel23);

        jPanel21.setMaximumSize(new java.awt.Dimension(326, 45));
        jPanel21.setMinimumSize(new java.awt.Dimension(326, 45));
        jPanel21.setPreferredSize(new java.awt.Dimension(326, 45));
        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.X_AXIS));

        jPanel32.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel32.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel32.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel32.setLayout(new java.awt.BorderLayout());

        bF11.setText("F11 | PDS");
        jPanel32.add(bF11, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel32);

        jPanel33.setMaximumSize(new java.awt.Dimension(160, 50));
        jPanel33.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel33.setLayout(new java.awt.BorderLayout());

        bEsc.setText("Esc | Salir");
        jPanel33.add(bEsc, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel33);

        jPanel10.add(jPanel21);

        jPanel1.add(jPanel10);

        getContentPane().add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(689, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(689, 100));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(685, 500));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel12.setMaximumSize(new java.awt.Dimension(430, 32767));
        jPanel12.setMinimumSize(new java.awt.Dimension(430, 100));
        jPanel12.setPreferredSize(new java.awt.Dimension(430, 496));
        jPanel12.setLayout(new java.awt.BorderLayout());

        lImagen.setIcon(new javax.swing.ImageIcon("/home/roberto/Desarrollos/Modulo PV Version 3/T3BFramework/config/articulo_logo.jpg")); // NOI18N
        jPanel12.add(lImagen, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel12);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.Y_AXIS));

        jPanel15.setMaximumSize(new java.awt.Dimension(2147483647, 250));
        jPanel15.setMinimumSize(new java.awt.Dimension(0, 250));
        jPanel15.setPreferredSize(new java.awt.Dimension(251, 250));
        jPanel15.setLayout(new java.awt.BorderLayout());

        lAnuncio1.setBackground(new java.awt.Color(244, 240, 236));
        lAnuncio1.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        lAnuncio1.setForeground(new java.awt.Color(251, 8, 8));
        lAnuncio1.setText("Tiendas\n3B");
        lAnuncio1.setMaximumSize(new java.awt.Dimension(183, 118));
        jScrollPane2.setViewportView(lAnuncio1);

        jPanel15.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel15);

        jPanel14.setLayout(new java.awt.BorderLayout());

        lAhorra.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        lAhorra.setForeground(new java.awt.Color(249, 10, 10));
        lAhorra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAhorra.setText("Y AHORRATE");
        lAhorra.setMaximumSize(new java.awt.Dimension(49, 80));
        lAhorra.setMinimumSize(new java.awt.Dimension(49, 80));
        lAhorra.setName(""); // NOI18N
        lAhorra.setPreferredSize(new java.awt.Dimension(49, 80));
        jPanel14.add(lAhorra, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel14);

        jPanel17.setLayout(new java.awt.BorderLayout());

        lAnuncio2.setFont(new java.awt.Font("Ubuntu", 1, 45)); // NOI18N
        lAnuncio2.setForeground(new java.awt.Color(249, 10, 10));
        lAnuncio2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lAnuncio2.setText("!! $ 00.00 !!");
        lAnuncio2.setPreferredSize(new java.awt.Dimension(225, 100));
        jPanel17.add(lAnuncio2, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel17);

        jPanel16.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanel16.setMinimumSize(new java.awt.Dimension(49, 60));
        jPanel16.setPreferredSize(new java.awt.Dimension(251, 60));
        jPanel16.setLayout(new java.awt.BorderLayout());

        lAnuncio3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lAnuncio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAnuncio3.setText("Contra");
        jPanel16.add(lAnuncio3, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel16);

        jPanel9.add(jPanel13);

        jPanel2.add(jPanel9);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lAnuncio4.setBackground(new java.awt.Color(244, 240, 236));
        lAnuncio4.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jScrollPane3.setViewportView(lAnuncio4);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel11);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        f12Buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF1ActionPerformed
        // TODO add your handling code here:
        f1CierraVenta();
    }//GEN-LAST:event_bF1ActionPerformed

    private void bF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF2ActionPerformed
        // TODO add your handling code here:
        f2CancelaArticulo();
    }//GEN-LAST:event_bF2ActionPerformed

    private void bF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF3ActionPerformed
        // TODO add your handling code here:
        f3CancelaVenta();
    }//GEN-LAST:event_bF3ActionPerformed

    private void bF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF5ActionPerformed
        // TODO add your handling code here:
        f5MultiplicarArticulo();
    }//GEN-LAST:event_bF5ActionPerformed

    private void bF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF4ActionPerformed
        // TODO add your handling code here:
        f4RepetirArticulo();
    }//GEN-LAST:event_bF4ActionPerformed

    private void bF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF6ActionPerformed
        // TODO add your handling code here:
        f6ChecarPrecio();
    }//GEN-LAST:event_bF6ActionPerformed

    private void bF10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bF10ActionPerformed
        // TODO add your handling code here:
        f10TA();
    }//GEN-LAST:event_bF10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEsc;
    private javax.swing.JButton bF1;
    private javax.swing.JButton bF10;
    private javax.swing.JButton bF11;
    private javax.swing.JButton bF2;
    private javax.swing.JButton bF3;
    private javax.swing.JButton bF4;
    private javax.swing.JButton bF5;
    private javax.swing.JButton bF6;
    private javax.swing.JButton bF7;
    private javax.swing.JButton bF8;
    private javax.swing.JButton bF9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lAhorra;
    private javax.swing.JTextPane lAnuncio1;
    private javax.swing.JLabel lAnuncio2;
    private javax.swing.JLabel lAnuncio3;
    private javax.swing.JTextPane lAnuncio4;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lTotal;
    private javax.swing.JTable tArticulos;
    private javax.swing.JTextField tICB;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
        switch(e.getKeyCode()){
            case KeyEvent.VK_ENTER: agregarArticuloICB();break;
            case KeyEvent.VK_F1: f1CierraVenta();break;
            case KeyEvent.VK_F2: f2CancelaArticulo();break;
            case KeyEvent.VK_F3: f3CancelaVenta();break;
            case KeyEvent.VK_F4: f4RepetirArticulo();break;
            case KeyEvent.VK_F5: f5MultiplicarArticulo();break;
            case KeyEvent.VK_F6: f6ChecarPrecio();break;    
            case KeyEvent.VK_F12: f12Buscar();break;
                
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
