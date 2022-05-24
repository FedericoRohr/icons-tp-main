package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.ContinenteEntity;
import com.example.demo.entity.IconEntity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaisDTO {
	
	private Long id;
	
	private String denominacion;
	
	private Long cantidadHabitantes;
	
	private Float superficie;
	
	private Long continenteId;
	
	
	private Set<IconoDTO>icons= new HashSet<>();
	
}
