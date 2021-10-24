package com.misiontic.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.back.entity.Mascota;
import com.misiontic.back.repository.MascotaRepository;
import com.misiontic.back.validators.MascotaValidator;

@Service
public class MascotaService {

	@Autowired
	private MascotaRepository mascotaRepo;

	public Mascota findById(Long mascotaId) {
		Mascota mascota = mascotaRepo.findById(mascotaId)
				.orElseThrow(() -> new RuntimeException("No existe la mascota."));
		return mascota;
	}
	
	@Transactional
	public void delete(Long mascotaId) {
		Mascota mascota = mascotaRepo.findById(mascotaId)
				.orElseThrow(() -> new RuntimeException("No existe la mascota."));
		mascotaRepo.delete(mascota);
	}
	
	public List<Mascota> findAll() {
		List<Mascota> mascotas = mascotaRepo.findAll();
		return mascotas;
	}
	
	@Transactional
	public Mascota save(Mascota mascota) {
		
		MascotaValidator.save(mascota);
		
		if (mascota.getId() == null) {
			Mascota nuevaMascota = mascotaRepo.save(mascota);
			return nuevaMascota;
		}
		
		Mascota existeMascota = mascotaRepo.findById(mascota.getId())
				.orElseThrow(() -> new RuntimeException("No existe la mascota."));
		
		existeMascota.setNombre(mascota.getNombre());
		existeMascota.setEdad(mascota.getEdad());
		existeMascota.setResponsable(mascota.getResponsable());
		existeMascota.setServicio(mascota.getServicio());
		mascotaRepo.save(existeMascota);
		
		return existeMascota;
	}
}
