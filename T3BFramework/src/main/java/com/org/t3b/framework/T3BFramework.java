/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.framework;

import com.org.t3b.framework.controller.Controlador;
import com.org.t3b.framework.gui.main.VMain;
import com.org.t3b.framework.model.Modelo;
import com.org.t3b.framework.utils.Config;
import com.org.t3b.log.utils.Logger3B;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author roberto
 */
public class T3BFramework {
	/**
	 * @param args the command line arguments
	 */

	public static VMain tmp = null;
	public static Controlador controlador;
	public static com.org.t3b.core.utils.Config config;
	public static Config configF;

	public static void main(String[] args) throws UnsupportedLookAndFeelException, ParseException {

		if (Config.existeConfig()) {
			config = new com.org.t3b.core.utils.Config();
			configF = new Config();

			controlador = new Controlador(configF, tmp);
			Config.cargaConfig();
			com.org.t3b.core.utils.Config.cargaConfig();
			Logger3B.Log(3, "INICIO DE APLICACION");

			Logger3B.Log(3, "CARGA DE LIBRERIAS");
			System.out.println("JARS cargados");
			try {
				inicializar();
			} catch (Exception ex) {
				Logger3B.Log(1, "T3BFramework", "t3b.framework", "main", ex.getMessage());
			}
			controlador.setEscritorio(tmp.getPanel());
			cargarJARS(Config.jars, Config.njars);
		} else {
			JOptionPane.showMessageDialog(null, "No existe archivo de configuracion, contacte a sistemas",
					"Aplicacion Almacen", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para llamar la ventana
	 */
	public static void inicializar() throws ParseException, UnsupportedLookAndFeelException {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
		// </editor-fold>

		// UIManager.setLookAndFeel(new
		// de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel());

		try {
			tmp = new VMain();
			tmp.setVisible(true);
		} catch (Exception ex) {
			Logger3B.Log(1, "T3BFramework", "t3b.framework", "inicializar", ex.getMessage());
		}
	}

	/**
	 * Metodo para llamar la carga de las JARS
	 */
	public static void cargarJARS(String jars, String njars) {

		ArrayList<HashMap<String, String>> modulos = new ArrayList<HashMap<String, String>>();

		Modelo modelo = new Modelo(config);
		modulos = modelo.obtenModulosSistema(Config.id_sistema);

		try {

			String ruta = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
			System.out.println("Ruta: " + ruta);

			for (HashMap<String, String> modulo : modulos) {
				URLClassLoader cl = ((URLClassLoader) ClassLoader.getSystemClassLoader());
				Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
				method.setAccessible(true);
				URL url = new File(ruta + modulo.get("paquete").toString()).toURI().toURL();
				method.invoke(cl, new Object[] { url });
				System.out.println("JAR Cargado: " + ruta + modulo.get("paquete").toString());

				Class clase = Class.forName("com.t3b." + modulo.get("clase").toString() + ".controller.Controlador");
				Class[] paramCons = new Class[3];

				paramCons[0] = com.org.t3b.core.utils.Config.class;
				paramCons[1] = JDesktopPane.class;
				paramCons[2] = com.org.t3b.core.controller.ControladorG.class;

				Constructor cons = clase.getConstructor(paramCons);
				Object obj = clase.cast(cons.newInstance(config, tmp.getPanel(), controlador));

				controlador.getModulos().put(modulo.get("clase").toString(), obj);

			}

			// System.out.println("Entro");

			if (!Config.moduloInicio.equals("")) {

				// System.out.println("Entro a ejecutar");

				String[] listap = Config.paramInicio.split("\\|");

				String[] parametros = new String[listap.length];
				int i = 0;
				for (String aux : listap) {
					parametros[i] = aux;
					i++;

				}

				Class clase = Class.forName("com.t3b." + Config.moduloInicio + ".controller.Controlador");
				Class[] paramCons = new Class[2];
				Class[] params = new Class[2];
				params[0] = String.class;
				params[1] = String[].class;
				Method metodo = clase.getDeclaredMethod("ejecutaAccion", params);
				Object[] params2 = new Object[2];
				params2[0] = Config.metodoInicio;
				params2[1] = parametros;
				Object obj2 = metodo.invoke(controlador.getModulos().get(Config.moduloInicio), params2);

			}

		} catch (Exception ex) {
			Logger3B.Log(1, "T3BFramework", "t3b.framework", "cargarJARS", ex.getMessage());
			System.out.println(ex);
		}
	}

}
