package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.entity.IconEntity;
import com.example.demo.entity.PaisEntity;
@Component
public class PaisMapper {

@Autowired
 private IconoMapper iconoMapper;

public PaisEntity paisDTO2Entity(PaisDTO dto) {
		 PaisEntity pais= new  PaisEntity();
		 pais.setCantidadHabitantes(dto.getCantidadHabitantes());
		 pais.setContinenteId(dto.getContinenteId());
		 pais.setDenominacion(dto.getDenominacion());
	     pais.setSuperficie(dto.getSuperficie());
	     pais.setImagen(dto.getImagen());
	    return pais;
	}

public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
	PaisDTO pais= new PaisDTO();
	pais.setCantidadHabitantes(entity.getCantidadHabitantes());
	pais.setContinenteId(entity.getContinenteId());
	pais.setDenominacion(entity.getDenominacion());
	pais.setId(entity.getId());
	pais.setSuperficie(entity.getSuperficie());
	pais.setImagen(entity.getImagen());
	if(loadIcons) {
	List<IconoDTO>icons=iconoMapper.iconoEntitySet2DTOlist(entity.getIcons(),false);
	pais.setIcons(icons);
	}
	return	pais;
	}

public PaisBasicDTO paisEntity2BasicDTO(PaisEntity entity) {
	PaisBasicDTO pais= new PaisBasicDTO();
	pais.setCantidadHabitantes(entity.getCantidadHabitantes());
	pais.setDenominacion(entity.getDenominacion());
	pais.setId(entity.getId());
	pais.setImagen(entity.getImagen()); 
	return	pais;
	}

public List<PaisBasicDTO> paisEntity2BasicDTO(List<PaisEntity> findAll) {
	List<PaisBasicDTO>lista=new ArrayList<>();
	for(PaisEntity pais :findAll) {
		lista.add(this.paisEntity2BasicDTO(pais));
	}
	return lista;
}

public List<PaisDTO> listPaisEntity2DTO(List<PaisEntity> findAll) {
	List<PaisDTO>lista=new ArrayList<>();
	for(PaisEntity pais :findAll) {
		
		lista.add(this.paisEntity2DTO(pais,true));
	}
	return lista;
}

public PaisEntity update(PaisEntity entity, PaisDTO dto) {
	entity.setCantidadHabitantes(dto.getCantidadHabitantes());
	entity.setContinenteId(dto.getContinenteId());
	entity.setDenominacion(dto.getDenominacion());
	entity.setSuperficie(dto.getSuperficie());
	return entity;
	
}

public List<PaisDTO> paisEntityList2Dto(List<PaisEntity> paises, boolean loadIcons) {
	List<PaisDTO>dtos=new ArrayList<>();
	for(PaisEntity pais : paises) {
		dtos.add(paisEntity2DTO(pais,loadIcons));
	}
	return dtos;
}
	
	

}
