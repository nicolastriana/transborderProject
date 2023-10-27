package com.transborder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transborder.model.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, Integer> {

}
