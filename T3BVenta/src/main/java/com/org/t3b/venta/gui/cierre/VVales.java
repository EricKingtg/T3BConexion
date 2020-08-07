/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.gui.cierre;

import com.org.t3b.venta.controller.Controlador;
import com.org.t3b.venta.utils.Validador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author roberto
 */
public class VVales extends javax.swing.JInternalFrame implements KeyListener{

    private Controlador controlador;
    private VCierre cierre;
    private Validador validador;
    
    /**
     * Creates new form VEfectivo
     */
    public VVales() {
        initComponents();
    }
    
    public VVales(Controlador c,VCierre ci,Validador v) {
        this.controlador=c;
        this.cierre=ci;
        this.validador=v;
        initComponents();
        agregaListener();
        this.gettValor().setText(getDatoEfectivo("2"));
        tValor.setSelectionStart(0);
        tValor.setSelectionEnd(tValor.getText().length());
        setRestante();
        
    }
    
    
    private String getDatoEfectivo(String fpClave){
        String regreso="0.00";
        
        
        for (HashMap<String,String> tmp : validador.getConfigV().getFormasPago()) {
            
            if(tmp.get("fp_clave").equals(fpClave)){
                regreso=tmp.get("valor").toString();
                break;
            }
            
        }
        
        regreso=validador.getFormato().redondeaCero(validador.getFormato().formato2Dec(Float.valueOf(regreso)));
        
        return regreso;
    }
    
    private void setRestante(){
        
        this.lrestante.setText("$ "+validador.getFormato().redondeaCero(validador.getFormato().formato2Dec(validador.getRestantef())));
        
    }
    
    
    private void agregaListener(){
        tValor.addKeyListener(this);
        bEnter.addKeyListener(this);
        bEsc.addKeyListener(this);
        
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public VCierre getCierre() {
        return cierre;
    }

    public void setCierre(VCierre cierre) {
        this.cierre = cierre;
    }

    public Validador getValidador() {
        return validador;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
    }

    public JButton getbEnter() {
        return bEnter;
    }

    public void setbEnter(JButton bEnter) {
        this.bEnter = bEnter;
    }

    public JButton getbEsc() {
        return bEsc;
    }

    public void setbEsc(JButton bEsc) {
        this.bEsc = bEsc;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
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

    public JLabel getlCRestante() {
        return lCRestante;
    }

    public void setlCRestante(JLabel lCRestante) {
        this.lCRestante = lCRestante;
    }

    public JLabel getLrestante() {
        return lrestante;
    }

    public void setLrestante(JLabel lrestante) {
        this.lrestante = lrestante;
    }

    public JTextField gettValor() {
        return tValor;
    }

    public void settValor(JTextField tValor) {
        this.tValor = tValor;
    }
    
    private void salir(){
        this.cierre.transferFocus();
        this.setVisible(false);
        this.dispose();
    }
    
    private void agregarPago(){
        float pago=0;
        try {
            
            pago=Float.parseFloat(this.gettValor().getText());
            
        }catch(Exception e){
            
        }
        
        this.validador.validaVales(pago);
        
        this.salir();
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tValor = new javax.swing.JTextField();
        lCRestante = new javax.swing.JLabel();
        lrestante = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        bEnter = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        bEsc = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Efectivo"), "Vales"));
        jPanel1.setMaximumSize(new java.awt.Dimension(439, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(439, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(439, 200));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(427, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(427, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(427, 120));

        jLabel2.setText("Valor");

        tValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tValor.setText("0.00");

        lCRestante.setText("Cantidad Restante");

        lrestante.setText("$0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lCRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lrestante, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(tValor, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addContainerGap(74, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCRestante)
                    .addComponent(lrestante))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(425, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(425, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(425, 50));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(212, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(212, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(212, 50));
        jPanel5.setLayout(new java.awt.BorderLayout());

        bEnter.setText("Enter | Agregar");
        bEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnterActionPerformed(evt);
            }
        });
        jPanel5.add(bEnter, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);

        jPanel6.setMaximumSize(new java.awt.Dimension(212, 50));
        jPanel6.setMinimumSize(new java.awt.Dimension(212, 50));
        jPanel6.setPreferredSize(new java.awt.Dimension(212, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        bEsc.setText("Esc | Cancelar");
        bEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEscActionPerformed(evt);
            }
        });
        jPanel6.add(bEsc, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnterActionPerformed
        // TODO add your handling code here:
        agregarPago();
    }//GEN-LAST:event_bEnterActionPerformed

    private void bEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEscActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_bEscActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnter;
    private javax.swing.JButton bEsc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lCRestante;
    private javax.swing.JLabel lrestante;
    private javax.swing.JTextField tValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
            agregarPago();
        }
        
        if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            salir();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}