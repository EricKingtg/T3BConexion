/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.venta.gui.cierre;

import com.org.t3b.core.gui.VPantalla;
import com.org.t3b.venta.controller.Controlador;
import com.org.t3b.venta.utils.CVKeyListener;
import com.org.t3b.venta.utils.HiloAhorrado;
import com.org.t3b.venta.utils.ImageRenderer;
import com.org.t3b.venta.utils.Item;
import com.org.t3b.venta.utils.MyTableModel;
import com.org.t3b.venta.utils.Validador;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author roberto
 */
public class VCierre extends VPantalla implements KeyListener{

    private MyTableModel modelo = new MyTableModel();
    private HiloAhorrado hiloAhorrro=null;
    private Validador validador;
    public Controlador controlador;
    /**
     * Creates new form VCierre
     */
    public VCierre() {
        initComponents();
    }

    
    
    public VCierre(Controlador c,HashMap<String, Object> p) {
        super(c, p);
        initComponents();
        this.controlador=c;
        this.getbF1().setEnabled(false);
        configuraTablaCompartiva();
        cargaDatosCompartiva();
        if(c.getConfigV().getCarComparativa().getItems().size()>0)
            mensajeAhorro();
        
        setTabla();
        configuraTablaFP();
        iniciaListener();
        
    }
    
    
    private void iniciaListener(){
        this.bF1.addKeyListener(this);
        this.bEsc.addKeyListener(this);
        this.tFormasPago.addKeyListener(new CVKeyListener(this));
        this.addKeyListener(this);
    }
    
    
    private void setTabla() {
       
        
        

        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{
            "Id",
            "Descripcion",
            "Importe",
            ""
            };

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            JButton.class,
            java.lang.String.class,
            java.lang.String.class
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        Object[][] datos = new Object[][]{
            
        };

        // Defino el TableModel y le indico los datos y nombres de columnas
        tFormasPago.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;
            
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                boolean regreso=false;
//                if(columnIndex==1)
//                    regreso=true;
//                else
//                    regreso=false;
                    return regreso;
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

//            @Override
//            public boolean isCellEditable(int row, int column) {
//                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
//                return !(this.getColumnClass(column).equals(JButton.class));
//            }
        });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        tFormasPago.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto también implica que en 
         * lugar de poner un botón en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un botón. Es posible capturar el clic del botón, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es más "simple"
         */
        tFormasPago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tFormasPago.rowAtPoint(e.getPoint());
                int columna = tFormasPago.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tFormasPago.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tFormasPago.getModel().getColumnCount(); i++) {
                        if (!tFormasPago.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(tFormasPago.getModel().getColumnName(i)).append(": ").append(tFormasPago.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                    
                    if(Integer.valueOf(tFormasPago.getModel().getValueAt(fila, 0).toString())==1){
                        muestraEfectivo();
                    }
                    
                    
                }
            }
        });
    }
    
    
    
    
    private void configuraTablaFP(){
        
        TableColumnModel columnModel = tFormasPago.getColumnModel();
        tFormasPago.setRowHeight(22);
        
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(90);
        
        
        columnModel.getColumn(0).setMinWidth(20);
        columnModel.getColumn(1).setMinWidth(140);
        columnModel.getColumn(2).setMinWidth(90);
        columnModel.getColumn(3).setMinWidth(90);
        
        
        
        columnModel.getColumn(0).setMaxWidth(20);
        columnModel.getColumn(1).setMaxWidth(140);
        columnModel.getColumn(2).setMaxWidth(90);
        columnModel.getColumn(3).setMaxWidth(90);
        
    }
    
    
    
    private void mensajeAhorro(){
        hiloAhorrro = new HiloAhorrado(this.lAhorro,"Puedes Ahorrar: $ "+controlador.getFormato().redondeaCero(controlador.getFormato().formato2Dec(this.controlador.getConfigV().getCarComparativa().getTotal())));
        hiloAhorrro.start();
    }
    
    private void cargaDatosCompartiva(){
        
        int i=0;
        
        for(i=0;i<this.controlador.getConfigV().getCarComparativa().getItems().size();i++){
            Item tmp = this.controlador.getConfigV().getCarComparativa().getItems().get(i);
            String []pathArray=tmp.getPathImagen().split("\\.");
            String pathSmall="/home/pos3b/programas/"+pathArray[0]+"s.jpg";
            modelo.addRow(new Object[]{tmp.getDesCortaMP(),
                                        "Ahorra !! $ "+controlador.getFormato().redondeaCero(controlador.getFormato().formato2Dec(tmp.getTotal()))+" ¡¡",
                                        pathSmall});
            
            
        
        }
        
        
        
        this.tComparacion.repaint();
        
    }
    
    private void configuraTablaCompartiva(){
        
        String[] nombreColumnas = {"","",""};
        Object[][] datosFila = {}; //vacio 
        modelo.setDataVector(datosFila, nombreColumnas);
        tComparacion.setModel(modelo);
        
        tComparacion.getColumnModel().getColumn(2).setCellRenderer( new ImageRenderer() );
        tComparacion.setRowHeight(60);
        
        
        
       TableColumnModel columnModel = tComparacion.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(180);
        columnModel.getColumn(2).setPreferredWidth(50);
        //columnModel.getColumn(3).setPreferredWidth(0);
        
        
        columnModel.getColumn(0).setMinWidth(250);
        columnModel.getColumn(1).setMinWidth(180);
        columnModel.getColumn(2).setMinWidth(50);
        //columnModel.getColumn(3).setMinWidth(0);
        
        
        
        columnModel.getColumn(0).setMaxWidth(250);
        columnModel.getColumn(1).setMaxWidth(180);
        columnModel.getColumn(2).setMaxWidth(50);
        //columnModel.getColumn(3).setMaxWidth(0);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tComparacion.getColumnModel().getColumn(1).setCellRenderer(tcr);
        
        
        tComparacion.addMouseListener(new java.awt.event.MouseAdapter() {
             
             
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
                 int row = tComparacion.rowAtPoint(evt.getPoint());
                 int col = tComparacion.columnAtPoint(evt.getPoint());
                 
                 if ( row >= 0 && col >= 0 ) 
                 {   
                     //si celda contiene imagen
                     if( modelo.getValueAt(row, col) != null )
                     {
                         
                         String pathTmp=controlador.getConfigV().getCarComparativa().getItems().get(row).getPathImagen();
                         
                         
                         //obtiene la ruta que corresponde a la celda donde se hizo el clic
                         File fichero = new File( "/home/pos3b/programas/"+pathTmp );
                         //se carga la imagen en un jlabel
                         JLabel picLabel = new JLabel(new ImageIcon( fichero.getAbsolutePath() ));
                         //se muestra la imagen en el jdialog
                         JOptionPane.showMessageDialog(null, picLabel, "Vista Previa", JOptionPane.PLAIN_MESSAGE, null);
                     }                             
                 }
             }
         });
        
        
    }
    
    
    public void muestraEfectivo(){
        this.controlador.ejecutaAccion("Cierre", "showEfectivo");
    }
    
    public void muestraVales(){
        this.controlador.ejecutaAccion("Cierre", "showVales");
    }
    
    public void muestraEvale(){
        this.controlador.ejecutaAccion("Cierre", "showEvale");
    }
    
    public void muestraTarjetaCredito(){
        this.controlador.ejecutaAccion("Cierre", "showTarjetaCredito");
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

    public MyTableModel getModelo() {
        return modelo;
    }

    public void setModelo(MyTableModel modelo) {
        this.modelo = modelo;
    }

    public HiloAhorrado getHiloAhorrro() {
        return hiloAhorrro;
    }

    public void setHiloAhorrro(HiloAhorrado hiloAhorrro) {
        this.hiloAhorrro = hiloAhorrro;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable gettFormasPago() {
        return tFormasPago;
    }

    public void settFormasPago(JTable tFormasPago) {
        this.tFormasPago = tFormasPago;
    }

    
    
    
    
    
    
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getlAhorro() {
        return lAhorro;
    }

    public void setlAhorro(JLabel lAhorro) {
        this.lAhorro = lAhorro;
    }

    public JLabel getlTotal() {
        return lTotal;
    }

    public void setlTotal(JLabel lTotal) {
        this.lTotal = lTotal;
    }

    public JLabel getLcambio() {
        return lcambio;
    }

    public void setLcambio(JLabel lcambio) {
        this.lcambio = lcambio;
    }

    public JLabel getLimportePagado() {
        return limportePagado;
    }

    public void setLimportePagado(JLabel limportePagado) {
        this.limportePagado = limportePagado;
    }

    public JTable gettComparacion() {
        return tComparacion;
    }

    public void settComparacion(JTable tComparacion) {
        this.tComparacion = tComparacion;
    }

    public Validador getValidador() {
        return validador;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
    }
    
    
    

        
    public void salir(){
        Controlador controlador = (Controlador)this.getControlador();
        controlador.ejecutaAccion("Cierre","salirCierre");
    }
    
    public void validaEfectivo(){
        
        System.out.println("Validando efectivo");
        
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
        jPanel4 = new javax.swing.JPanel();
        lTotal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tFormasPago = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        limportePagado = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lcambio = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        bF1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        bEsc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tComparacion = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        lAhorro = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerrar Venta"));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(350, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 548));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de la Venta"));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        lTotal.setFont(new java.awt.Font("Ubuntu", 1, 42)); // NOI18N
        lTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotal.setText("$ 00.00");
        jPanel4.add(lTotal, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagos"));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 250));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 250));
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel5.setLayout(new java.awt.BorderLayout());

        tFormasPago.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tFormasPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tipo", "Importe", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tFormasPago);
        if (tFormasPago.getColumnModel().getColumnCount() > 0) {
            tFormasPago.getColumnModel().getColumn(0).setResizable(false);
            tFormasPago.getColumnModel().getColumn(1).setResizable(false);
            tFormasPago.getColumnModel().getColumn(2).setResizable(false);
            tFormasPago.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Importe Pagado"));
        jPanel6.setPreferredSize(new java.awt.Dimension(350, 70));
        jPanel6.setLayout(new java.awt.BorderLayout());

        limportePagado.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        limportePagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        limportePagado.setText("$ 00.00");
        jPanel6.add(limportePagado, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambio"));
        jPanel7.setPreferredSize(new java.awt.Dimension(350, 70));
        jPanel7.setLayout(new java.awt.BorderLayout());

        lcambio.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        lcambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lcambio.setText("$ 00.00");
        jPanel7.add(lcambio, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel8.setMinimumSize(new java.awt.Dimension(0, 60));
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 60));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.X_AXIS));

        jPanel9.setLayout(new java.awt.BorderLayout());

        bF1.setText("F1 | Aceptar");
        jPanel9.add(bF1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        bEsc.setText("Esc | Cancelar");
        bEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEscActionPerformed(evt);
            }
        });
        jPanel10.add(bEsc, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10);

        jPanel2.add(jPanel8);

        jPanel1.add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(530, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(530, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(530, 548));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setMaximumSize(new java.awt.Dimension(32767, 450));
        jPanel11.setMinimumSize(new java.awt.Dimension(0, 450));
        jPanel11.setPreferredSize(new java.awt.Dimension(530, 450));
        jPanel11.setLayout(new java.awt.BorderLayout());

        tComparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tComparacion);

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel11);

        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 120));
        jPanel12.setMinimumSize(new java.awt.Dimension(0, 120));
        jPanel12.setPreferredSize(new java.awt.Dimension(530, 120));
        jPanel12.setLayout(new java.awt.BorderLayout());

        lAhorro.setFont(new java.awt.Font("Ubuntu", 1, 34)); // NOI18N
        lAhorro.setForeground(new java.awt.Color(248, 7, 7));
        lAhorro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lAhorro.setText("Puedes Ahorrar:     $ 00.00");
        jPanel12.add(lAhorro, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel12);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEscActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_bEscActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEsc;
    private javax.swing.JButton bF1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAhorro;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lcambio;
    private javax.swing.JLabel limportePagado;
    private javax.swing.JTable tComparacion;
    private javax.swing.JTable tFormasPago;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
