package com.example.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.entity.IconEntity;


@Component
public class IconoMapper {
@Autowired	
private	PaisMapper paisMapper;
	public IconEntity iconDTO2Entity(IconoDTO dto) {
		IconEntity icon = new IconEntity();
		icon.setAltura(dto.getAltura());
		icon.setDenominacion(dto.getDenominacion());
		icon.setFechaCreacion(dto.getFechaCreacion()); 
		icon.setHistoria(dto.getHistoria());
		icon.setImagen(dto.getImagen());
		return icon;
	}
	
	public IconoDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {
		IconoDTO icon = new IconoDTO();
		icon.setAltura(entity.getAltura());
		icon.setDenominacion(entity.getDenominacion());
		icon.setFechaCreacion(entity.getFechaCreacion()); 
		icon.setHistoria(entity.getHistoria());
		icon.setImagen(entity.getImagen());
		icon.setId(entity.getId());
		if(loadPaises) {
			List<PaisDTO>pais=this.paisMapper.paisEntityList2Dto(entity.getPaises(),false);/// 
			icon.setPaises(pais);
		}
		return icon;
		
	}
	
	public IconoBasicDTO iconEntity2BasicDTO(IconEntity enity) {
		IconoBasicDTO icon = new IconoBasicDTO();
		icon.setDenominacion(enity.getDenominacion());
	    icon.setImagen(enity.getImagen());
		icon.setId(enity.getId());
		return icon;
	}
	
	public List<IconoBasicDTO> listIconoEntity2BasicDTO(List<IconEntity> findAll) {
		List<IconoBasicDTO>lista=new ArrayList<>();
		for(IconEntity icono :findAll) {
			lista.add(this.iconEntity2BasicDTO(icono));
		}
		return lista;
	}
	
	private LocalDate string2LocalDate(String stringDate) {/// investigar
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date= LocalDate.parse(stringDate,formatter);
		return date;
	}

	public IconEntity update(IconEntity entity, IconoDTO dto) {
		entity.setAltura(dto.getAltura());
		entity.setDenominacion(dto.getDenominacion());
		entity.setFechaCreacion(dto.getFechaCreacion());
		entity.setHistoria(dto.getHistoria());
		entity.setImagen(dto.getImagen());
		return entity;
	}

	public List<IconoDTO> iconoEntitySet2DTOlist(Set<IconEntity> iconos, boolean loadPaises) {
		List<IconoDTO>dtos=new ArrayList<>();
		for(IconEntity entity:iconos) {
			dtos.add(this.iconEntity2DTO(entity, loadPaises));
		}
		return dtos;
	}
	
	public List<IconoDTO> iconoEntity2DTOlist(List<IconEntity> iconos, boolean loadPaises) {
		List<IconoDTO>dtos=new ArrayList<>();
		for(IconEntity entity:iconos) {
			dtos.add(this.iconEntity2DTO(entity, loadPaises));
		}
		return dtos;
	}
	

}
