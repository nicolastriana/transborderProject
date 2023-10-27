package com.transborder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transborder.model.Cotizaciones;

@Repository
public interface ICotizacionesRepository extends JpaRepository<Cotizaciones, String>, JpaSpecificationExecutor<Cotizaciones> {
	
	@Query(value = "SELECT MAX(c.numero_cotizacion) FROM Cotizaciones c", nativeQuery = true)
	String maxNumeroCotizacion();
	
	@Query(value = "SELECT * FROM Cotizaciones c WHERE DATE(c.fecha_creacion) = :fechaCreacion", nativeQuery = true)
	List<Cotizaciones> getCotizacionesFechaCreacion(@Param("fechaCreacion") String fechaCreacion);
	
	@Query("SELECT c FROM Cotizaciones c WHERE WEEK(c.fechaCreacion) = :semanaCreacion")
	List<Cotizaciones> getCotizacionesSemanaCreacion(@Param("semanaCreacion") Integer semanaCreacion);

}
