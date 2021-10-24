package com.misiontic.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.back.entity.Servicios;
import com.misiontic.back.repository.ServiciosRepository;
import com.misiontic.back.validators.ServiciosValidator;

@Service
public class ServiciosService {

	@Autowired
	private ServiciosRepository servicioRepo;

	public Servicios findById(Long servicioId) {
		Servicios servicio = servicioRepo.findById(servicioId)
				.orElseThrow(() -> new RuntimeException("No existe el servicio."));
		return servicio;
	}
	
	@Transactional
	public void delete(Long servicioId) {
		Servicios servicio = servicioRepo.findById(servicioId)
				.orElseThrow(() -> new RuntimeException("No existe el servicio."));
		servicioRepo.delete(servicio);
	}
	
	public List<Servicios> findAll() {
		List<Servicios> servicios = servicioRepo.findAll();
		return servicios;
	}
	
	@Transactional
	public Servicios save(Servicios servicio) {
		
		ServiciosValidator.save(servicio);
		
		if (servicio.getId() == null) {
			Servicios nuevoServicio = servicioRepo.save(servicio);
			return nuevoServicio;
		}
		
		Servicios existeServicio = servicioRepo.findById(servicio.getId())
				.orElseThrow(() -> new RuntimeException("No existe el servicio."));
		
		existeServicio.setNombre(servicio.getNombre());
		existeServicio.setPrecio(servicio.getPrecio());
		servicioRepo.save(existeServicio);
		
		return existeServicio;
	}
}
