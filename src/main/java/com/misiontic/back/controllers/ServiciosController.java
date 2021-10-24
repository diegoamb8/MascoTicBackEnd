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

import com.misiontic.back.dtos.ServiciosDTO;
import com.misiontic.back.entity.Servicios;
import com.misiontic.back.services.ServiciosService;

@RestController
public class ServiciosController {

	@Autowired
	private ServiciosService servicioService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/servicios/{servicioId}")
	public ResponseEntity<ServiciosDTO> findById(@PathVariable("servicioId") Long servicioId) {
		Servicios servicio = servicioService.findById(servicioId);
		
		ServiciosDTO serviciosDto = ServiciosDTO.builder()
				.id(servicio.getId())
				.nombre(servicio.getNombre())
				.precio(servicio.getPrecio())
				.build();
		
		return new ResponseEntity<ServiciosDTO>(serviciosDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/servicios/{servicioId}")
	public ResponseEntity<Void> delete(@PathVariable("servicioId") Long servicioId) {
		servicioService.delete(servicioId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/servicios")
	public ResponseEntity<List<ServiciosDTO>> findAll() {
		List<Servicios> servicioss = servicioService.findAll();
		
		List<ServiciosDTO> serviciosDto = servicioss.stream().map(servicios -> {
			return ServiciosDTO.builder()
					.id(servicios.getId())
					.nombre(servicios.getNombre())
					.precio(servicios.getPrecio())
					.build();
		})
		.collect(Collectors.toList());
		
		return new ResponseEntity<List<ServiciosDTO>>(serviciosDto, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/servicios")
	public ResponseEntity<ServiciosDTO> create(@RequestBody Servicios servicios) {
		Servicios nuevoServicio= servicioService.save(servicios);
		
		ServiciosDTO serviciosDto = ServiciosDTO.builder()
				.id(nuevoServicio.getId())
				.nombre(nuevoServicio.getNombre())
				.precio(nuevoServicio.getPrecio())
				.build();
		
		return new ResponseEntity<ServiciosDTO>(serviciosDto, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/servicios")
	public ResponseEntity<ServiciosDTO> update(@RequestBody Servicios servicios) {
		Servicios existeServicio = servicioService.save(servicios);
		
		ServiciosDTO serviciosDto = ServiciosDTO.builder()
				.id(existeServicio.getId())
				.nombre(existeServicio.getNombre())
				.precio(existeServicio.getPrecio())
				.build();
		
		return new ResponseEntity<ServiciosDTO>(serviciosDto, HttpStatus.OK);
	}
}
