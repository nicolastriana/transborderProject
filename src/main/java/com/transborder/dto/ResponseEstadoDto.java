package com.transborder.dto;

import java.util.Date;

import com.transborder.model.Ciudad;
import com.transborder.model.Pais;

public class ResponseEstadoDto {
	
	private String numeroCotizacion;
	
	private Date vigenciaCotizacion;
	
	private String naviera;
	
	private String mercancia;
	
	private Pais paisDestino;
	
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

	public String getMercancia() {
		return mercancia;
	}

	public void setMercancia(String mercancia) {
		this.mercancia = mercancia;
	}

	public Pais getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(Pais paisDestino) {
		this.paisDestino = paisDestino;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

}
