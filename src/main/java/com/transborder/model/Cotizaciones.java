package com.transborder.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cotizaciones")
public class Cotizaciones {
	
	@Column(name = "numero_cotizacion")
	@Id
	private String numeroCotizacion;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "fecha_creacion", columnDefinition = "DATETIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
	private Date fechaCreacion;
	
	@Column(name = "vigencia_cotizacion", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vigenciaCotizacion;
	
	@Column(name = "moneda")
	private String moneda;
	
	@Column(name = "fecha_modificacion", columnDefinition = "DATETIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
	private Date fechaModificacion;
	
	@Column(name = "naviera")
	private String naviera;
	
	@Column(name = "mercancia")
	private String mercancia;
	
	@Column(name = "valor_mercancia")
	private Float valorMercancia;
	
	@ManyToOne
	@JoinColumn(name = "id_ciudad_origen", nullable = false, foreignKey = @ForeignKey(name = "FK_ciudad_origen"))
	private Ciudad ciudadOrigen;
	
	@ManyToOne
	@JoinColumn(name = "id_ciudad_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_ciudad_destino"))
	private Ciudad ciudadDestino;
	
	@Column(name = "fecha_cierre", columnDefinition = "DATETIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
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
