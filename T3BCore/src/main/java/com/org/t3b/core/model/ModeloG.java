/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.core.model;

import com.org.t3b.conexion.db.Consulta;
import com.org.t3b.conexion.dto.Conexion;
import com.org.t3b.conexion.utils.CampoDTO;
import com.org.t3b.conexion.utils.ColumnaDTO;
import com.org.t3b.conexion.utils.QryRespDTO;
import com.org.t3b.core.controller.ControladorG;
import com.org.t3b.core.utils.Config;
import com.org.t3b.log.utils.Logger3B;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author roberto
 */
public class ModeloG {

	private ControladorG controlador;
	private Config config;
	private Connection con;
	private Conexion conexion;

	public ModeloG() {

	}

	public ModeloG(ControladorG c, Config cf) {
		this.controlador = c;
		this.config = cf;
		// cargaConfig();
	}

	private void cargaConfig() {
		Config.cargaConfig();
	}

	private void abreConexion() {

		conexion = new Conexion();
		conexion.creaConexion(Config.dbHost, Config.dbUser, Config.dbPass, Config.dbPort, Config.dbName, Config.dbClassDriver, Config.dbUrl);
		con = conexion.getConexion();

	}

	public ArrayList<HashMap<String, String>> ejecutaConsulta(String sqlQuery) {
		this.abreConexion();
		ArrayList<HashMap<String, String>> resultados = new ArrayList<HashMap<String, String>>();
		QryRespDTO dtotmp = new Consulta().consulta(con, sqlQuery);
		if (dtotmp.getRes() == 1) {
			for (HashMap<String, CampoDTO> tmp : dtotmp.getDatosTabla()) {
				HashMap<String, String> resultado = new HashMap<String, String>();
				for (ColumnaDTO tmp2 : dtotmp.getColumnas()) {
					tmp.get(tmp2.getEtiqueta()).getValor(); // obtiene el valor de la celda
					tmp.get(tmp2.getEtiqueta()).getClase();
					resultado.put(tmp2.getEtiqueta(), tmp.get(tmp2.getEtiqueta()).getValor().toString());
				}
				resultados.add(resultado);
			}
		}

		this.cierraConexion();
		return resultados;
	}

	
	public ArrayList<HashMap<String, String>> ejecutaConsultaSP(String sqlQuery, ArrayList<Object> paramIn) {
		this.abreConexion();
		ArrayList<HashMap<String, String>> resultados = new ArrayList<HashMap<String, String>>();
		QryRespDTO dtotmp = new Consulta().ejecutaSelectSP(con, sqlQuery, paramIn);
		if (dtotmp.getRes() == 1) {
			for (HashMap<String, CampoDTO> tmp : dtotmp.getDatosTabla()) {
				HashMap<String, String> resultado = new HashMap<String, String>();
				for (ColumnaDTO tmp2 : dtotmp.getColumnas()) {
					// CampoDTO dto1 = tmp1.get(tmp2.getEtiqueta());
					tmp.get(tmp2.getEtiqueta()).getValor(); // obtiene el valor de la celda
					tmp.get(tmp2.getEtiqueta()).getClase();
					resultado.put(tmp2.getEtiqueta(), tmp.get(tmp2.getEtiqueta()).getValor().toString());

				}

				resultados.add(resultado);
			}
		}

		this.cierraConexion();
		return resultados;
	}

	
	public QryRespDTO ejecutaSP(String sqlQuery, ArrayList<Object> paramIn, ArrayList<Integer> paramOut) {
		this.abreConexion();
		QryRespDTO resultado = new QryRespDTO();
		resultado = new Consulta().ejecutaSP(con, sqlQuery, paramIn, paramOut);
		this.cierraConexion();
		return resultado;
	}

	private void cierraConexion() {
		try {
			con.close();
		} catch (SQLException ex) {
			Logger3B.Log(1, "T3BCore", "t3b.core", "cierraConexion", ex.getMessage());
		}
	}

	public ControladorG getControlador() {
		return controlador;
	}

	public void setControlador(ControladorG controlador) {
		this.controlador = controlador;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

}
