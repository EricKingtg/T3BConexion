/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bventa.utils;

import com.t3b.pv.t3bcore.utils.FormatoNumero;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


/**
 *
 * @author roberto
 */
public class SelectingEditor extends DefaultCellEditor{
    
    private static final long serialVersionUID = 1L;
    private FormatoNumero formato=new FormatoNumero();
		
		
		public SelectingEditor(JTextField textField) { 
			super(textField); 
		}						
		
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
			Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column); 
			if ( c instanceof JTextComponent) { 
				JTextComponent jtc = (JTextComponent)c;
                                try{
                                    jtc.setText(formato.redondeaCero(formato.formato2Dec(Float.parseFloat(jtc.getText()))));
                                }catch(Exception e){
                                    jtc.setText("0.00");
                                    
                                }
                                
				jtc.requestFocus(); 
				jtc.selectAll(); 
			} 
			return c; 
		} 
    
}
