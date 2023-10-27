package com.transborder.service;

import java.util.List;

import com.transborder.model.Ciudad;

public interface ICiudadService {

	List<Ciudad> getCiudades() throws Exception;
	
	Ciudad getCiudadById(Integer id) throws Exception;
	
	Ciudad saveCiudad(Ciudad ciudad) throws Exception;
	
	Ciudad updateCiudad(Ciudad ciudad) throws Exception;
	
	void deleteCiudad(Integer id) throws Exception;
	
}
