package com.transborder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transborder.model.Ciudad;
import com.transborder.repository.ICiudadRepository;
import com.transborder.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {
	
	@Autowired
	private ICiudadRepository ciudadRepo;

	@Override
	public List<Ciudad> getCiudades() throws Exception {
		return ciudadRepo.findAll();
	}

	@Override
	public Ciudad getCiudadById(Integer id) throws Exception {
		return ciudadRepo.findById(id).orElse(null);	
	}

	@Override
	public Ciudad saveCiudad(Ciudad ciudad) throws Exception {
		return ciudadRepo.save(ciudad);	
	}

	@Override
	public Ciudad updateCiudad(Ciudad ciudad) throws Exception {
		return ciudadRepo.save(ciudad);	
	}

	@Override
	public void deleteCiudad(Integer id) throws Exception {
		ciudadRepo.deleteById(id);	
	}

}
