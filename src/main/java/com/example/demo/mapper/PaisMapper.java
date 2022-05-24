package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.entity.PaisEntity;
@Component
public class PaisMapper {


public PaisEntity PaisDTO2Entity(PaisDTO dto) {
		 PaisEntity pais= new  PaisEntity();
		 pais.setCantidadHabitantes(dto.getCantidadHabitantes());
		 pais.setContinenteId(dto.getContinenteId());
		 pais.setDenominacion(dto.getDenominacion());
	     pais.setSuperficie(dto.getSuperficie());
	    return pais;
	}

public PaisDTO PaisEntity2DTO(PaisEntity entity) {
	PaisDTO pais= new PaisDTO();
	pais.setCantidadHabitantes(entity.getCantidadHabitantes());
	pais.setContinenteId(entity.getContinenteId());
	pais.setDenominacion(entity.getDenominacion());
	pais.setId(entity.getId());
	pais.setSuperficie(entity.getSuperficie());
	return	pais;
	}

public PaisBasicDTO PaisEntity2BasicDTO(PaisEntity entity) {
	PaisBasicDTO pais= new PaisBasicDTO();
	pais.setCantidadHabitantes(entity.getCantidadHabitantes());
	pais.setDenominacion(entity.getDenominacion());
	pais.setId(entity.getId());
	///pais.setImagen(entity.getImagen); ////debo agregar imagen en entity , dto y dtoBasic 
	return	pais;
	}

public List<PaisBasicDTO> PaisEntity2BasicDTO(List<PaisEntity> findAll) {
	List<PaisBasicDTO>lista=new ArrayList<>();
	for(PaisEntity pais :findAll) {
		lista.add(this.PaisEntity2BasicDTO(pais));
	}
	return lista;
}

public List<PaisDTO> ListPaisEntity2DTO(List<PaisEntity> findAll) {
	List<PaisDTO>lista=new ArrayList<>();
	for(PaisEntity pais :findAll) {
		
		lista.add(this.PaisEntity2DTO(pais));
	}
	return lista;
}

public PaisEntity update(PaisEntity existente, PaisDTO dto) {
	PaisEntity updater =existente;
	existente.setCantidadHabitantes(dto.getCantidadHabitantes());
	existente.setContinenteId(dto.getContinenteId());
	existente.setDenominacion(dto.getDenominacion());
	existente.setSuperficie(dto.getSuperficie());
	return existente;
	
}
	
	

}
