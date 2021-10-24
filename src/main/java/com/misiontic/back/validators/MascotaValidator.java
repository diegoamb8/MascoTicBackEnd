package com.misiontic.back.validators;

import com.misiontic.back.entity.Mascota;

public class MascotaValidator {

	public static void save(Mascota mascota) {
		
		if(mascota.getNombre() == null || mascota.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre es obligatorio.");
		}
		
		if (mascota.getNombre().length() > 100) {
			throw new RuntimeException("El nombre no puede ser mayor a 100 caracteres.");
		}
		
		if(mascota.getEdad() == null) {
			throw new RuntimeException("La edad es obligatoria.");
		}
		
		if(mascota.getTipo() == null || mascota.getTipo().trim().isEmpty()) {
			throw new RuntimeException("El tipo es obligatorio.");
		}
		
		if (mascota.getTipo().length() > 100) {
			throw new RuntimeException("El tipo no puede ser mayor a 100 caracteres.");
		}
		
		if(mascota.getResponsable() == null || mascota.getResponsable().trim().isEmpty()) {
			throw new RuntimeException("El responsable es obligatorio.");
		}
		
		if (mascota.getResponsable().length() > 100) {
			throw new RuntimeException("El responsable no puede ser mayor a 100 caracteres.");
		}
		
		if(mascota.getServicio() == null || mascota.getServicio().trim().isEmpty()) {
			throw new RuntimeException("El servicio es obligatorio.");
		}
		
		if (mascota.getServicio().length() > 100) {
			throw new RuntimeException("El servicio no puede ser mayor a 100 caracteres.");
		}
	}
}
