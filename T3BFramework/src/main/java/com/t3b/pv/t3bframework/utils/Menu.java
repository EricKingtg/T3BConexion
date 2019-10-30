/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3b.pv.t3bframework.utils;


import com.t3b.pv.t3bconexion.db.Consulta;
import com.t3b.pv.t3bconexion.dto.Conexion;
import com.t3b.pv.t3bconexion.utils.CampoDTO;
import com.t3b.pv.t3bconexion.utils.QryRespDTO;
import com.t3b.pv.t3bframework.gui.main.VMain;
import com.t3b.pv.t3blog.utils.Logger3B;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



/**
 * Clase para el control de las ventanas y acceso al menu principal
 * Todo lo tomara de la BD, para que sea dinamico
 * @author daniel
 */
public class Menu {
    
    private Conexion conex = null;
    private int idusuario = 0;
    private VMain padre = null;
    
    public Menu(VMain padre){
        this.padre = padre;
    }
    
    public Menu(VMain padre, int idusuario){
        this.padre = padre;
        this.idusuario = idusuario;
    }
    
    /**
     * Metodo para crear el menu de la aplicacion
     * @return objeto JMenuBar creado
     */
    public JMenuBar creaMenu(){
        JMenuBar menu = new JMenuBar();
        Connection conn = null;
        try{
            conex = new Conexion();
            conex.creaConexion(Config.dbHost, Config.dbUser, Config.dbPass, Config.dbPort, Config.dbName, Config.dbClassDriver, Config.dbUrl);
            conn = conex.getConexion();
            ArrayList<Object> params = new ArrayList();
            params.add(1);
            params.add(Config.id_sistema);
            QryRespDTO resp = new Consulta().ejecutaSelectSP(conn, "{CALL SP_APP_MENU_FN_CONSULTA_MENUBARAPP(?,?)}", params);
            if(resp.getRes() == 1){
                for(HashMap<String, CampoDTO> mapa : resp.getDatosTabla()){
                    JMenu aux = new JMenu();
                    int idmenu = Integer.parseInt(mapa.get("idmenu").getValor().toString());
                    aux.setName("menu"+idmenu);
                    aux.setText(mapa.get("texto").getValor().toString().toUpperCase());
                    aux.setToolTipText(mapa.get("tooltip").getValor().toString().toUpperCase());
                    javax.swing.ImageIcon icono = this.poneIcono(mapa.get("icono").getValor().toString());
                    if(icono != null)
                        aux.setIcon(icono);
                    /*realiza la busqueda de los elementos de cada menu...*/
                    ArrayList lista = obtieneItemsMenu(idmenu, this.idusuario, conn);
                    if(lista != null){
                        for(Object obj: lista){
                            if( obj instanceof javax.swing.JMenuItem)
                                aux.add((javax.swing.JMenuItem)obj);
                            else
                                aux.add((javax.swing.JMenu)obj);
                        }
                    }
                    menu.add(aux);
                }
            }else{
                menu = this.creaMenuDefault();
            }
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", this.getClass().toString(), "creaMenu", ex.getMessage());
            menu = this.creaMenuDefault();
        }finally{
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex1){
                
            }
            
        }
        return menu;
    }
    
    /**
     * Metodo que regresa un ImageIcon para ponerlo en el menu
     * @param ruta
     * @return 
     */
    private javax.swing.ImageIcon poneIcono(String ruta){
        javax.swing.ImageIcon icono = null;
        try{
            if(ruta != null){
                if(ruta.length()>0){
                    ruta = ruta.replaceAll("\\|", File.separator);
                    if(new File(System.getProperty("user.dir")+File.separator+ruta).exists())
                        icono = new javax.swing.ImageIcon(System.getProperty("user.dir")+File.separator+ruta);
                }
            }
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", this.getClass().toString(), "poneIcono", ex.getMessage());
            icono = null;
        }        
        return icono;
    }
    
    /**
     * Metodo para cargar los items de un menu especificado
     * @param idmenu
     * @param idusr
     * @param conn
     * @return 
     */
    private ArrayList<Object> obtieneItemsMenu(int idmenu, int idusr, Connection conn){
        ArrayList<Object> lista = new ArrayList();
        try{
            ArrayList<Object> params = new ArrayList();
            params.add(idmenu);
            params.add(1);
            params.add(idusr);
            params.add(Config.id_sistema);
            QryRespDTO resp = new Consulta().ejecutaSelectSP(conn, "{call SP_APP_MENU_FN_OBTIENEOPCIONESMENU(?,?,?,?)}", params);
            if(resp != null){
                for(final HashMap<String, CampoDTO> fila:resp.getDatosTabla()){
                    if(fila.get("idpadre").getValor().toString().equals("0")){
                        final JMenuItem itm = new JMenuItem();
                        itm.setName("_"+fila.get("idmenu").getValor().toString()+"_"+fila.get("idopcion").getValor().toString());
                        itm.setText(fila.get("texto").getValor().toString().toUpperCase());
                        itm.setToolTipText(fila.get("tooltip").getValor().toString().toUpperCase());
                        javax.swing.ImageIcon icono = this.poneIcono(fila.get("icono").getValor().toString());
                        if(icono != null){
                            itm.setIcon(icono);
                        }
                        itm.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Class clase = Class.forName(fila.get("clase").getValor().toString());
                                    Class[] paramCons = new Class[2];
                                    paramCons[0] = JDesktopPane.class;
                                    paramCons[1] = HashMap.class;
                                    Constructor cons = clase.getConstructor(paramCons);
                                    
                                    Object obj = clase.cast(cons.newInstance(padre.getPanel(), padre.obtieneConfig()));
                                    
                                    Class[] params = new Class[2];
                                    params[0] = String.class;
                                    params[1] = Object.class;
                                    Method metodo = clase.getDeclaredMethod("ejecutar", params);
                                    
                                    Object[] params2 = new Object[2];
                                    params2[0] = fila.get("metodo").getValor().toString();
                                    params2[1] = null;
                                    Object obj2 = metodo.invoke(obj, params2);
                                    
                                    System.out.println("Haciendo clic en el menu: " + itm.getText());
                                }catch(Exception ex){
                                    System.out.println("Excepcion en el actionPerformed " + ex);
                                    System.out.println(ex.toString());
                                }                                
                            }
                        });
                        lista.add(itm);
                    }else{
                        JMenu aux = new JMenu();
                        idmenu = Integer.parseInt(fila.get("idmenu").getValor().toString());
                        aux.setName("menu"+idmenu);
                        aux.setText(fila.get("texto").getValor().toString());
                        aux.setToolTipText(fila.get("tooltip").getValor().toString());
                        javax.swing.ImageIcon icono = this.poneIcono(fila.get("icono").getValor().toString());
                        if(icono != null)
                            aux.setIcon(icono);
                        lista.add(aux);
                    }
                        
                }
            }
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", this.getClass().toString(), "obtieneItemsMenu", ex.getMessage());
            lista = null;
        }        
        return lista;
    }
    
    
    /**
     * Metodo que crea la barra de menu por defecto, indica que hay un error
     * @return 
     */
    private JMenuBar creaMenuDefault(){
        JMenuBar menu = new JMenuBar();
        try{
            JMenu menu1 = new JMenu();
            menu1.setText("Aplicacion");
            JMenu menu2 = new JMenu();
            menu2.setText("Acerca De");
            
            menu.add(menu1);
            menu.add(menu2);
        }catch(Exception ex){
            Logger3B.Log(1, "T3BAppAlmacen", this.getClass().toString(), "creaMenuDefault", ex.getMessage());
        }        
        return menu;
    }
    
}
