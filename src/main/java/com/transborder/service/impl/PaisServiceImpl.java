package com.transborder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transborder.model.Pais;
import com.transborder.repository.IPaisRepository;
import com.transborder.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {

	@Autowired
	private IPaisRepository paisRepo;
	
	@Override
	public List<Pais> getPaises() throws Exception {		
		return paisRepo.findAll();		
	}

	@Override
	public Pais getPaisById(Integer id) throws Exception {		
		return paisRepo.findById(id).orElse(null);		
	}

	@Override
	public Pais savePais(Pais pais) throws Exception {		
		return paisRepo.save(pais);		
	}

	@Override
	public Pais updatePais(Pais pais) throws Exception {		
		return paisRepo.save(pais);		
	}

	@Override
	public void deletePais(Integer id) throws Exception {		
		paisRepo.deleteById(id);		
	}

}
