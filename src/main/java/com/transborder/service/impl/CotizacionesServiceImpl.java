package com.transborder.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.transborder.dto.CotizacionesDto;
import com.transborder.dto.RequestCiudadDto;
import com.transborder.dto.RequestEstadoDto;
import com.transborder.dto.RequestFechaCreacionDto;
import com.transborder.dto.RequestSemanaCreacionDto;
import com.transborder.dto.ResponseEstadoDto;
import com.transborder.model.Cotizaciones;
import com.transborder.repository.ICotizacionesRepository;
import com.transborder.service.ICotizacionesService;
import com.transborder.specification.CotizacionesSpecification;

@Service
public class CotizacionesServiceImpl implements ICotizacionesService {

	@Autowired
	private ICotizacionesRepository cotizacionesRepo;
	
	@Override
	public List<Cotizaciones> getCotizaciones() throws Exception {
		return cotizacionesRepo.findAll();
	}

	@Override
	public Cotizaciones getCotizacionById(String numeroCotizacion) throws Exception {		
		return cotizacionesRepo.findById(numeroCotizacion).orElse(null);		
	}
	
	@Override
	public Cotizaciones saveCotizaciones(Cotizaciones cotizaciones) throws Exception {
		
		String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyy"));
		String formatoNumeroCotizacion = "1-" + fecha + "-";
				
		String maxNumeroCotizacion = cotizacionesRepo.maxNumeroCotizacion();
				
		if(maxNumeroCotizacion == null) {
			
			formatoNumeroCotizacion += "00001";
			
		} else {
			
			int num = Integer.parseInt(maxNumeroCotizacion.substring(9)) + 1;
            formatoNumeroCotizacion += String.format("%05d", num);
			
        }
		
        cotizaciones.setNumeroCotizacion(formatoNumeroCotizacion);
        
		return cotizacionesRepo.save(cotizaciones);
		
	}
	
	@Override
	public Cotizaciones updateCotizaciones(Cotizaciones cotizaciones) throws Exception {
		return cotizacionesRepo.save(cotizaciones);		
	}

	@Override
	public void deleteCotizaciones(String id) throws Exception {		
		cotizacionesRepo.deleteById(id);		
	}
	
	@Override
	public List<Cotizaciones> fechaCreacionCotizaciones(RequestFechaCreacionDto requestFechaDto) throws Exception {

		List<Cotizaciones> listaCotizaciones = cotizacionesRepo.getCotizacionesFechaCreacion(requestFechaDto.getFechaCreacion());
		return listaCotizaciones;
		
	}

	@Override
	public List<ResponseEstadoDto> estadoCotizaciones(RequestEstadoDto requestEstadoDto) throws Exception {

		List<ResponseEstadoDto> listaCotizaciones = new ArrayList<>();
		
		Specification<Cotizaciones> specEstado = CotizacionesSpecification.igualEstado(requestEstadoDto.getEstado());
		
		Specification<Cotizaciones> specEstadoCotizaciones = Specification.where(specEstado);
		
		List<Cotizaciones> cotizaciones = cotizacionesRepo.findAll(specEstadoCotizaciones);
		
		for(Cotizaciones c : cotizaciones) {
			
			ResponseEstadoDto cotizacion = new ResponseEstadoDto();
			
			cotizacion.setNumeroCotizacion(c.getNumeroCotizacion());
			cotizacion.setVigenciaCotizacion(c.getVigenciaCotizacion());
			cotizacion.setNaviera(c.getNaviera());
			cotizacion.setMercancia(c.getMercancia());
			cotizacion.setPaisDestino(c.getCiudadDestino().getPais());
			cotizacion.setCiudadDestino(c.getCiudadDestino());
			
			listaCotizaciones.add(cotizacion);
			
		}		
		
		return listaCotizaciones;
		
	}

	@Override
	public List<CotizacionesDto> ciudadOrigenCotizaciones(RequestCiudadDto requestCiudadOrigenDto) throws Exception {

		List<CotizacionesDto> listaCotizaciones = new ArrayList<>();
		
		Specification<Cotizaciones> specCiudadOrigen = CotizacionesSpecification.igualCiudadOrigen(requestCiudadOrigenDto.getCiudadOrigen());
		
		Specification<Cotizaciones> specCiudadCotizaciones = Specification.where(specCiudadOrigen);
		
		List<Cotizaciones> cotizaciones = cotizacionesRepo.findAll(specCiudadCotizaciones);
		
		for(Cotizaciones c : cotizaciones) {
			
			CotizacionesDto cotizacion = new CotizacionesDto();
			
			cotizacion.setNumeroCotizacion(c.getNumeroCotizacion());
			cotizacion.setEstado(c.getEstado());
			cotizacion.setFechaCreacion(c.getFechaCreacion());
			cotizacion.setVigenciaCotizacion(c.getVigenciaCotizacion());
			cotizacion.setMoneda(c.getMoneda());
			cotizacion.setFechaModificacion(c.getFechaModificacion());
			cotizacion.setNaviera(c.getNaviera());
			cotizacion.setMercancia(c.getMercancia());
			cotizacion.setValorMercancia(c.getValorMercancia());
			cotizacion.setCiudadOrigen(c.getCiudadOrigen());
			cotizacion.setCiudadDestino(c.getCiudadDestino());
			cotizacion.setFechaCierre(c.getFechaCierre());
			
			listaCotizaciones.add(cotizacion);
			
		}
		
		return listaCotizaciones;
		
	}
	
	@Override
	public List<Cotizaciones> semanaCreacionCotizaciones(RequestSemanaCreacionDto requestSemanaCreacionDto) throws Exception {

		List<Cotizaciones> listaCotizaciones = cotizacionesRepo.getCotizacionesSemanaCreacion(requestSemanaCreacionDto.getSemanaFechaCreacion());
		return listaCotizaciones;
		
	}

	@Override
	public Cotizaciones modificacionCotizaciones(Cotizaciones cotizaciones) throws Exception {
		
		Cotizaciones oldCotizacion = getCotizacionById(cotizaciones.getNumeroCotizacion());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = localDateTime.format(formatter);
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formattedDateTime);
		
		cotizaciones.setEstado("Modificada");
		cotizaciones.setFechaCreacion(oldCotizacion.getFechaCreacion());
		cotizaciones.setFechaModificacion(date);
		cotizaciones.setMercancia(oldCotizacion.getMercancia());
		cotizaciones.setMoneda(oldCotizacion.getMoneda());
		cotizaciones.setValorMercancia(oldCotizacion.getValorMercancia());		
		
		return cotizacionesRepo.save(cotizaciones);	
		
	}

	@Override
	public Cotizaciones cerrarCotizaciones(Cotizaciones cotizaciones) throws Exception {
		
		Cotizaciones oldCotizacion = getCotizacionById(cotizaciones.getNumeroCotizacion());

		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = localDateTime.format(formatter);
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formattedDateTime);
		
		cotizaciones.setEstado("Cerrada");
		cotizaciones.setFechaCierre(date);
		cotizaciones.setFechaCreacion(oldCotizacion.getFechaCreacion());
		cotizaciones.setFechaModificacion(oldCotizacion.getFechaModificacion());
		cotizaciones.setMercancia(oldCotizacion.getMercancia());
		cotizaciones.setMoneda(oldCotizacion.getMoneda());
		cotizaciones.setNaviera(oldCotizacion.getNaviera());
		cotizaciones.setValorMercancia(oldCotizacion.getValorMercancia());
		cotizaciones.setVigenciaCotizacion(oldCotizacion.getVigenciaCotizacion());
		cotizaciones.setCiudadDestino(oldCotizacion.getCiudadDestino());
		cotizaciones.setCiudadOrigen(oldCotizacion.getCiudadOrigen());
		
		return cotizacionesRepo.save(cotizaciones);	
		
	}

}
