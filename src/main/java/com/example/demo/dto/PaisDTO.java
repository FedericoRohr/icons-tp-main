package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.ContinenteEntity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaisDTO {
	
	private Long id;
	
	private String denominacion;
	
	private Long cantidadHabitantes;
	
	private Float superficie;
	
	private ContinenteEntity contiente;
	
	private Long continenteId;
	
	private String Imagen;
	
	
	private List<IconoDTO>icons= new ArrayList<>();
	
}
