package com.transborder.service;

import java.util.List;

import com.transborder.dto.CotizacionesDto;
import com.transborder.dto.RequestCiudadDto;
import com.transborder.dto.RequestEstadoDto;
import com.transborder.dto.RequestFechaCreacionDto;
import com.transborder.dto.RequestSemanaCreacionDto;
import com.transborder.dto.ResponseEstadoDto;
import com.transborder.model.Cotizaciones;

public interface ICotizacionesService {
	
	List<Cotizaciones> getCotizaciones() throws Exception;
	
	Cotizaciones getCotizacionById(String numeroCotizacion) throws Exception;
	
	Cotizaciones saveCotizaciones(Cotizaciones cotizaciones) throws Exception;
	
	Cotizaciones updateCotizaciones(Cotizaciones cotizaciones) throws Exception;
	
	void deleteCotizaciones(String numeroCotizacion) throws Exception;
	
	List<Cotizaciones> fechaCreacionCotizaciones(RequestFechaCreacionDto requestFechaDto) throws Exception;
	
	List<ResponseEstadoDto> estadoCotizaciones(RequestEstadoDto requestEstadoDto) throws Exception;
	
	List<CotizacionesDto> ciudadOrigenCotizaciones(RequestCiudadDto requestCiudadOrigenDto) throws Exception;
	
	List<Cotizaciones> semanaCreacionCotizaciones(RequestSemanaCreacionDto requestSemanaCreacionDto) throws Exception;
	
	Cotizaciones modificacionCotizaciones(Cotizaciones cotizaciones) throws Exception;
	
	Cotizaciones cerrarCotizaciones(Cotizaciones cotizaciones) throws Exception;

}
