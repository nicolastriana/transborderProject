package com.transborder.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transborder.dto.CotizacionesDto;
import com.transborder.dto.RequestCerrarCotizacionDto;
import com.transborder.dto.RequestCiudadDto;
import com.transborder.dto.RequestEstadoDto;
import com.transborder.dto.RequestFechaCreacionDto;
import com.transborder.dto.RequestModCotizacionDto;
import com.transborder.dto.RequestSemanaCreacionDto;
import com.transborder.dto.ResponseEstadoDto;
import com.transborder.model.Cotizaciones;
import com.transborder.service.ICotizacionesService;

@RestController
@RequestMapping("/cotizaciones")
public class CotizacionesController {
	
	@Autowired
	private ICotizacionesService cotizacionesService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<CotizacionesDto>> getCotizaciones() throws Exception {
		
		List<CotizacionesDto> listaCotizaciones = cotizacionesService.getCotizaciones().stream().map(c -> modelMapper.map(c,  CotizacionesDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(listaCotizaciones, HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CotizacionesDto> getCotizacionById(@PathVariable String id) throws Exception {
		
		Cotizaciones cotizacion = cotizacionesService.getCotizacionById(id);
		
		if(cotizacion == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		CotizacionesDto dtoResponse = modelMapper.map(cotizacion, CotizacionesDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<CotizacionesDto> saveCotizaciones(@RequestBody CotizacionesDto dtoCotizacionesRequest) throws Exception {
		
		Cotizaciones cotizacion = modelMapper.map(dtoCotizacionesRequest, Cotizaciones.class);		
		Cotizaciones cotizacionResponse = cotizacionesService.saveCotizaciones(cotizacion);
		CotizacionesDto dtoResponse = modelMapper.map(cotizacionResponse, CotizacionesDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<CotizacionesDto> updateCotizaciones(@RequestBody CotizacionesDto dtoCotizacionesRequest) throws Exception {
		
		Cotizaciones c = cotizacionesService.getCotizacionById(dtoCotizacionesRequest.getNumeroCotizacion()); 
				
		if(c == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		Cotizaciones cotizacion = modelMapper.map(dtoCotizacionesRequest, Cotizaciones.class);		
		Cotizaciones cotizacionResponse = cotizacionesService.updateCotizaciones(cotizacion);
		CotizacionesDto dtoResponse = modelMapper.map(cotizacionResponse, CotizacionesDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCotizaciones(@PathVariable String id) throws Exception {
		
		Cotizaciones cotizacion = cotizacionesService.getCotizacionById(id);
		
		if(cotizacion == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		cotizacionesService.deleteCotizaciones(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("/fecha/creacion")
	public ResponseEntity<List<CotizacionesDto>> fechaCreacionCotizaciones(@RequestBody RequestFechaCreacionDto requestFechaCreacionDto) throws Exception {
	
		List<CotizacionesDto> listaCotizaciones = cotizacionesService.fechaCreacionCotizaciones(requestFechaCreacionDto)
													.stream().map(c -> modelMapper.map(c,  CotizacionesDto.class))
													.collect(Collectors.toList());
			
		return new ResponseEntity<>(listaCotizaciones, HttpStatus.OK);
		
	}
	
	@PostMapping("/estado")
	public ResponseEntity<List<ResponseEstadoDto>> estadoCotizaciones(@RequestBody RequestEstadoDto requestEstadoDto) throws Exception {
	
		List<ResponseEstadoDto> listaCotizaciones = cotizacionesService.estadoCotizaciones(requestEstadoDto);		
		return new ResponseEntity<>(listaCotizaciones, HttpStatus.OK);
		
	}
	
	@PostMapping("/ciudad/origen")
	public ResponseEntity<List<CotizacionesDto>> ciudadOrigenCotizaciones(@RequestBody RequestCiudadDto requestCiudadOrigenDto) throws Exception {
	
		List<CotizacionesDto> listaCotizaciones = cotizacionesService.ciudadOrigenCotizaciones(requestCiudadOrigenDto);	
		return new ResponseEntity<>(listaCotizaciones, HttpStatus.OK);
		
	}
	
	@PostMapping("/semana/creacion")
	public ResponseEntity<List<CotizacionesDto>> semanaCreacionCotizaciones(@RequestBody RequestSemanaCreacionDto requestSemanaCreacionDto) throws Exception {
	
		List<CotizacionesDto> listaCotizaciones = cotizacionesService.semanaCreacionCotizaciones(requestSemanaCreacionDto)
													.stream().map(c -> modelMapper.map(c,  CotizacionesDto.class))
													.collect(Collectors.toList());
			
		return new ResponseEntity<>(listaCotizaciones, HttpStatus.OK);
		
	}
	
	@PostMapping("/modificar")
	public ResponseEntity<CotizacionesDto> modificarCotizacion(@RequestBody RequestModCotizacionDto requestModDto) throws Exception {
	
		Cotizaciones c = cotizacionesService.getCotizacionById(requestModDto.getNumeroCotizacion()); 
		
		if(c == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		Cotizaciones cotizacion = modelMapper.map(requestModDto, Cotizaciones.class);		
		Cotizaciones cotizacionResponse = cotizacionesService.modificacionCotizaciones(cotizacion);
		CotizacionesDto dtoResponse = modelMapper.map(cotizacionResponse, CotizacionesDto.class);
	
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@PostMapping("/cerrar")
	public ResponseEntity<CotizacionesDto> cerrarCotizacion(@RequestBody RequestCerrarCotizacionDto requestCerrarDto) throws Exception {
	
		Cotizaciones c = cotizacionesService.getCotizacionById(requestCerrarDto.getNumeroCotizacion()); 
		
		if(c == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		Cotizaciones cotizacion = modelMapper.map(requestCerrarDto, Cotizaciones.class);		
		Cotizaciones cotizacionResponse = cotizacionesService.cerrarCotizaciones(cotizacion);
		CotizacionesDto dtoResponse = modelMapper.map(cotizacionResponse, CotizacionesDto.class);
	
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}

}
