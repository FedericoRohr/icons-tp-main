package com.example.demo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.IconEntity;
import com.example.demo.entity.PaisEntity;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class IconoDTO {
	private Long id;
	private String denominacion;
	private String Imagen;
    private LocalDate fechaCreacion;
	private long altura;
	private String historia;
	private List<PaisDTO>paises = new ArrayList<>();

}
