package com.transborder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transborder.model.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

}
