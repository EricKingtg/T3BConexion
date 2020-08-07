/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.t3b.core.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author roberto
 */
public class ConfigPV {

	private String tienda;
	private String caja;
	private String cajero;
	private String ptoImpresora;
	private String ptoScanner;
	private String region;
	private String userId = "";
	private String acceso = "";
	private String prefijoGranel;
	private String zona;
	private String apagar;
	private String linpos3bConfigFile;

	public ConfigPV(String linpos3bConfigFile) {
		this.linpos3bConfigFile = linpos3bConfigFile;
		cargaLinpos3b();
	}

	private void cargaLinpos3b() {

		// Get information from LinPOS Configuration File
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(linpos3bConfigFile);
		} catch (FileNotFoundException ex) {

		}
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		try {
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {

				if (strLine.equals("#TIENDA"))
					this.setTienda(String.valueOf(Integer.valueOf(br.readLine().trim())));
				if (strLine.equals("#CAJA"))
					this.setCaja(br.readLine().trim());
				if (strLine.equals("#CAJERO"))
					this.setCajero(br.readLine().trim());
				if (strLine.equals("#PTO_IMPRESORA"))
					this.setPtoImpresora(br.readLine().trim());
				if (strLine.equals("#PTO_SCANNER"))
					this.setPtoScanner(br.readLine().trim());
				if (strLine.equals("#REGION"))
					this.setRegion(br.readLine().trim());
				if (strLine.equals("#PREFIJO_GRANEL"))
					this.setPrefijoGranel(br.readLine().trim());
				if (strLine.equals("#APAGAR_SALIR"))
					this.setApagar(br.readLine().trim());
				if (strLine.equals("#ZONA"))
					this.setZona(br.readLine().trim());

			}
		} catch (IOException ex) {

		}
		try {
			// Close the input stream
			in.close();
		} catch (IOException ex) {

		}

	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	public String getCajero() {
		return cajero;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public String getPtoImpresora() {
		return ptoImpresora;
	}

	public void setPtoImpresora(String ptoImpresora) {
		this.ptoImpresora = ptoImpresora;
	}

	public String getPtoScanner() {
		return ptoScanner;
	}

	public void setPtoScanner(String ptoScanner) {
		this.ptoScanner = ptoScanner;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAcceso() {
		return acceso;
	}

	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}

	public String getPrefijoGranel() {
		return prefijoGranel;
	}

	public void setPrefijoGranel(String prefijoGranel) {
		this.prefijoGranel = prefijoGranel;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getApagar() {
		return apagar;
	}

	public void setApagar(String apagar) {
		this.apagar = apagar;
	}

}
