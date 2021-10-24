package com.misiontic.back.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.back.dtos.MascotaDTO;
import com.misiontic.back.entity.Mascota;
import com.misiontic.back.services.MascotaService;

@RestController
public class MascotasController {

	@Autowired
	private MascotaService mascotaService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/mascota/{mascotaId}")
	public ResponseEntity<MascotaDTO> findById(@PathVariable("mascotaId") Long mascotaId) {
		Mascota mascota = mascotaService.findById(mascotaId);
		
		MascotaDTO mascotaDto = MascotaDTO.builder()
				.id(mascota.getId())
				.nombre(mascota.getNombre())
				.edad(mascota.getEdad())
				.tipo(mascota.getTipo())
				.responsable(mascota.getResponsable())
				.servicio(mascota.getServicio())
				.build();
		
		return new ResponseEntity<MascotaDTO>(mascotaDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/mascota/{mascotaId}")
	public ResponseEntity<Void> delete(@PathVariable("mascotaId") Long mascotaId) {
		mascotaService.delete(mascotaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/mascota")
	public ResponseEntity<List<MascotaDTO>> findAll() {
		List<Mascota> mascotas = mascotaService.findAll();
		
		List<MascotaDTO> mascotaDto = mascotas.stream().map(mascota -> {
			return MascotaDTO.builder()
					.id(mascota.getId())
					.nombre(mascota.getNombre())
					.edad(mascota.getEdad())
					.tipo(mascota.getTipo())
					.responsable(mascota.getResponsable())
					.servicio(mascota.getServicio())
					.build();
		})
		.collect(Collectors.toList());
		
		return new ResponseEntity<List<MascotaDTO>>(mascotaDto, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/mascota")
	public ResponseEntity<MascotaDTO> create(@RequestBody Mascota mascota) {
		Mascota nuevaMascota = mascotaService.save(mascota);
		
		MascotaDTO mascotaDto = MascotaDTO.builder()
				.id(nuevaMascota.getId())
				.nombre(nuevaMascota.getNombre())
				.edad(nuevaMascota.getEdad())
				.tipo(nuevaMascota.getTipo())
				.responsable(nuevaMascota.getResponsable())
				.servicio(nuevaMascota.getServicio())
				.build();
		
		return new ResponseEntity<MascotaDTO>(mascotaDto, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/mascota")
	public ResponseEntity<MascotaDTO> update(@RequestBody Mascota mascota) {
		Mascota existeMascota = mascotaService.save(mascota);
		
		MascotaDTO mascotaDto = MascotaDTO.builder()
				.id(existeMascota.getId())
				.nombre(existeMascota.getNombre())
				.edad(existeMascota.getEdad())
				.responsable(existeMascota.getResponsable())
				.servicio(existeMascota.getServicio())
				.build();
		
		return new ResponseEntity<MascotaDTO>(mascotaDto, HttpStatus.OK);
	}
}
