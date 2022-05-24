package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.entity.ContinenteEntity;

@Component
public class ContinenteMapper {

	public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
		ContinenteEntity continente = new ContinenteEntity();
		continente.setDenominacion(dto.getDenominacion());
		continente.setImagen(dto.getImagen());
		return continente;

	}

	public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
		ContinenteDTO continente = new ContinenteDTO();
		continente.setId(entity.getId());
		continente.setDenominacion(entity.getDenominacion());
		continente.setImagen(entity.getImagen());
		return continente;

	}

	public List<ContinenteDTO> listarEntity2DTO(List<ContinenteEntity> lista) {
		List<ContinenteDTO> respuesta = new ArrayList<>();
		for (ContinenteEntity c : lista) {
			respuesta.add(continenteEntity2DTO(c));
		}
		return respuesta;
	}

	public ContinenteEntity update(ContinenteEntity continente1, ContinenteDTO continente) {
		ContinenteEntity entity = continente1;
		entity.setDenominacion(continente.getDenominacion());
		entity.setImagen(continente.getImagen());
		return entity;
	}

}
