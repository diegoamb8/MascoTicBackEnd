package com.misiontic.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="mascotas")
public class Mascota {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;	
	
	@Column(name="edad", nullable = false, length = 10)
	private Long edad;
	
	@Column(name="tipo", nullable = false, length = 100)
	private String tipo;
	
	@Column(name="responsable", nullable = false, length = 100)
	private String responsable;

	@Column(name="servicio", nullable = false, length = 100)
	private String servicio;

}
