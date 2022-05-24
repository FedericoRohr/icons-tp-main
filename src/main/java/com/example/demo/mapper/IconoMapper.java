package com.example.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.entity.IconEntity;


@Component
public class IconoMapper {
@Autowired	
private	PaisMapper paisMapper;
	public IconEntity IconDTO2Entity(IconoDTO dto) {
		IconEntity icon = new IconEntity();
		icon.setAltura(dto.getAltura());
		icon.setDenominacion(dto.getDenominacion());
		icon.setFechaCreacion(dto.getFechaCreacion()); 
		icon.setHistoria(dto.getHistoria());
		icon.setImagen(dto.getImagen());
		return icon;
	}
	
	public IconoDTO IconEntity2DTO(IconEntity entity) {
		IconoDTO icon = new IconoDTO();
		icon.setAltura(entity.getAltura());
		icon.setDenominacion(entity.getDenominacion());
		icon.setFechaCreacion(entity.getFechaCreacion()); 
		icon.setHistoria(entity.getHistoria());
		icon.setImagen(entity.getImagen());
		icon.setId(entity.getId());
		return icon;
		
	}
	
	public IconoBasicDTO IconEntity2BasicDTO(IconEntity enity) {
		IconoBasicDTO icon = new IconoBasicDTO();
		icon.setDenominacion(enity.getDenominacion());
	    icon.setImagen(enity.getImagen());
		icon.setId(enity.getId());
		return icon;
	}
	
	public List<IconoBasicDTO> ListIconoEntity2BasicDTO(List<IconEntity> findAll) {
		List<IconoBasicDTO>lista=new ArrayList<>();
		for(IconEntity icono :findAll) {
			lista.add(this.IconEntity2BasicDTO(icono));
		}
		return lista;
	}
	
	private LocalDate String2LocalDate(String stringDate) {/// investigar
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date= LocalDate.parse(stringDate,formatter);
		return date;
	}

	public IconEntity update(IconEntity existente, IconoDTO dto) {
		IconEntity respuesta = existente;
		respuesta.setAltura(dto.getAltura());
		respuesta.setDenominacion(dto.getDenominacion());
		respuesta.setFechaCreacion(dto.getFechaCreacion());
		respuesta.setHistoria(dto.getHistoria());
		respuesta.setImagen(dto.getImagen());
		return respuesta;
	}
	

}
