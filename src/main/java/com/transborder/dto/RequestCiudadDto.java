package com.transborder.dto;

import com.transborder.model.Ciudad;

public class RequestCiudadDto {
	
	private Ciudad ciudadOrigen;
	

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

}
