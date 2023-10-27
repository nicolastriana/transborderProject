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

import com.transborder.dto.PaisDto;
import com.transborder.model.Pais;
import com.transborder.service.IPaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<PaisDto>> getCotizaciones() throws Exception {
		
		List<PaisDto> listaPaises = paisService.getPaises().stream().map(p -> modelMapper.map(p,  PaisDto.class)).collect(Collectors.toList());
		return new ResponseEntity<>(listaPaises, HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PaisDto> getPaisById(@PathVariable Integer id) throws Exception {
		
		Pais pais = paisService.getPaisById(id);
		
		if(pais == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		PaisDto dtoResponse = modelMapper.map(pais, PaisDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<PaisDto> savePais(@RequestBody PaisDto dtoPaisRequest) throws Exception {
		
		Pais pais = modelMapper.map(dtoPaisRequest, Pais.class);		
		Pais paisResponse = paisService.savePais(pais);
		PaisDto dtoResponse = modelMapper.map(paisResponse, PaisDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<PaisDto> updatePais(@RequestBody PaisDto dtoPaisRequest) throws Exception {
		
		Pais p = paisService.getPaisById(dtoPaisRequest.getId()); 
				
		if(p == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		Pais pais = modelMapper.map(dtoPaisRequest, Pais.class);		
		Pais paisResponse = paisService.savePais(pais);
		PaisDto dtoResponse = modelMapper.map(paisResponse, PaisDto.class);
		
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePais(@PathVariable Integer id) throws Exception {
		
		Pais pais = paisService.getPaisById(id);
		
		if(pais == null) {
			throw new Exception("ID NO ENCONTRADO");
		}
		
		paisService.deletePais(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
