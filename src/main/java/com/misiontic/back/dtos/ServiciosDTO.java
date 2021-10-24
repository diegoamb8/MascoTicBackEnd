package com.misiontic.back.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServiciosDTO {

	private Long id;
	private String nombre;
	private String precio;

}
