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

import com.transborder.dto.CiudadDto;
import com.transborder.model.Ciudad;
import com.transborder.service.ICiudadService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private ICiudadService ciudadService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<CiudadDto>> getCotizaciones() throws Exception {
		
		List<CiudadDto> listaCiudades = ciudadService.getCiudades().stream().map(c -> modelMapper.map(c,  CiudadDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(listaCiudades, HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CiudadDto> getCiudadById(@PathVariable Integer id) throws Exception {
		
		Ciudad ciudad = ciudadService.getCiudadById(id);
		
		if(ciudad == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		CiudadDto dtoResponse = modelMapper.map(ciudad, CiudadDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<CiudadDto> saveCiudad(@RequestBody CiudadDto dtoCiudadRequest) throws Exception {
		
		Ciudad ciudad = modelMapper.map(dtoCiudadRequest, Ciudad.class);		
		Ciudad ciudadResponse = ciudadService.saveCiudad(ciudad);
		CiudadDto dtoResponse = modelMapper.map(ciudadResponse, CiudadDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<CiudadDto> updateCiudad(@RequestBody CiudadDto dtoCiudadRequest) throws Exception {
		
		Ciudad c = ciudadService.getCiudadById(dtoCiudadRequest.getId()); 
				
		if(c == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		Ciudad ciudad = modelMapper.map(dtoCiudadRequest, Ciudad.class);		
		Ciudad ciudadResponse = ciudadService.updateCiudad(ciudad);
		CiudadDto dtoResponse = modelMapper.map(ciudadResponse, CiudadDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCiudad(@PathVariable Integer id) throws Exception {
		
		Ciudad ciudad = ciudadService.getCiudadById(id);
		
		if(ciudad == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		ciudadService.deleteCiudad(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
}
