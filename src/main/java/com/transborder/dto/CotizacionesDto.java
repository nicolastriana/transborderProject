package com.transborder.dto;

import java.util.Date;

import com.transborder.model.Ciudad;

public class CotizacionesDto {
	
	private String numeroCotizacion;
	
	private String estado;

	private Date fechaCreacion;

	private Date vigenciaCotizacion;

	private String moneda;

	private Date fechaModificacion;

	private String naviera;

	private String mercancia;
	
	private Float valorMercancia;
	
	private Ciudad ciudadOrigen;
	
	private Ciudad ciudadDestino;
	
	private Date fechaCierre;
	

	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getVigenciaCotizacion() {
		return vigenciaCotizacion;
	}

	public void setVigenciaCotizacion(Date vigenciaCotizacion) {
		this.vigenciaCotizacion = vigenciaCotizacion;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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

	public Float getValorMercancia() {
		return valorMercancia;
	}

	public void setValorMercancia(Float valorMercancia) {
		this.valorMercancia = valorMercancia;
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

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}	

}
