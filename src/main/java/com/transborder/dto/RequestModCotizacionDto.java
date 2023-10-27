package com.transborder.dto;

import java.util.Date;

import com.transborder.model.Ciudad;

public class RequestModCotizacionDto {
	
	private String numeroCotizacion;
	
	private Date vigenciaCotizacion;
	
	private String naviera;
	
	private Ciudad ciudadOrigen;
	
	private Ciudad ciudadDestino;
	

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public Date getVigenciaCotizacion() {
		return vigenciaCotizacion;
	}

	public void setVigenciaCotizacion(Date vigenciaCotizacion) {
		this.vigenciaCotizacion = vigenciaCotizacion;
	}

	public String getNaviera() {
		return naviera;
	}

	public void setNaviera(String naviera) {
		this.naviera = naviera;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

}
