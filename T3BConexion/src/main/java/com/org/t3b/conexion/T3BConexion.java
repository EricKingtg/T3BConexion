/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.conexion;

import com.org.t3b.conexion.db.Consulta;
import com.org.t3b.conexion.dto.Conexion;
import com.org.t3b.conexion.utils.QryRespDTO;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public class T3BConexion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Conexion con = new Conexion();
		con.creaConexion(
				"201.161.95.39", 
				"dba",
				"5575349",
				"2638",
				"ws1_pvcloud",
				"com.sybase.jdbc4.jdbc.SybDriver",
				"jdbc:sybase:Tds:");
		
		/**con.creaConexion(
		"localhost", 
		"root", 
		"123456", 
		"3306", 
		"modprod",
		"com.mysql.jdbc.Driver", 
		"jdbc:mysql:");**/
		Connection conn = con.getConexion();
		QryRespDTO resp = null;
		Consulta qry = new Consulta();
		if (conn != null) {
			ArrayList<Object> params = new ArrayList<>();
			params.add("50");
			params.add("01");
			params.add("2019-08-31");
			String sql = "{call S_CONCILIACION_PV(?,?,?);}";

			resp = new Consulta().ejecutaSelectSP(conn, sql, params);

			System.out.println("resp: " + resp.toString());
			System.out.println("resp: " + resp.toString());
		}

		qry.cerrarConexion(conn);
	}

}