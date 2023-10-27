package com.transborder.specification;

import org.springframework.data.jpa.domain.Specification;

import com.transborder.model.Ciudad;
import com.transborder.model.Cotizaciones;

public class CotizacionesSpecification {
	
	public static Specification<Cotizaciones> igualEstado(String estado) {
		return (root, query, builder) ->
			estado == null ?
				builder.conjunction() :
				builder.equal(root.get("estado"), estado);
	}
	
	public static Specification<Cotizaciones> igualCiudadOrigen(Ciudad ciudadOrigen) {
		return (root, query, builder) ->
			ciudadOrigen == null ?
				builder.conjunction() :
				builder.equal(root.get("ciudadOrigen"), ciudadOrigen);
	}

}
