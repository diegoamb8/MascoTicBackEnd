package com.misiontic.back.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MascotaDTO {

	private Long id;
	private String nombre;
	private Long edad;
	private String tipo;
	private String responsable;
	private String servicio;
}
