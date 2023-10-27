package com.transborder.service;

import java.util.List;

import com.transborder.model.Pais;

public interface IPaisService {
	
	List<Pais> getPaises() throws Exception;
	
	Pais getPaisById(Integer id) throws Exception;
	
	Pais savePais(Pais pais) throws Exception;
	
	Pais updatePais(Pais pais) throws Exception;
	
	void deletePais(Integer id) throws Exception;

}
