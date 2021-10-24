package com.misiontic.back.validators;

import com.misiontic.back.entity.Servicios;

public class ServiciosValidator {

	public static void save(Servicios servicio) {
		
		if(servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre es obligatorio.");
		}
		
		if (servicio.getNombre().length() > 100) {
			throw new RuntimeException("El nombre no puede ser mayor a 100 caracteres.");
		}
		
		if(servicio.getPrecio() == null || servicio.getPrecio().trim().isEmpty()) {
			throw new RuntimeException("El precio es obligatorio.");
		}
	}
}
