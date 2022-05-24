package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.entity.ContinenteEntity;
import com.example.demo.mapper.ContinenteMapper;
import com.example.demo.repository.ContinenteRepository;
import com.example.demo.service.ContinenteService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class ContinenteServiceImp implements ContinenteService {
	@Autowired
	private ContinenteMapper continenteMapper;
	@Autowired
	private ContinenteRepository contienteRepository;

	public ContinenteDTO save(ContinenteDTO dto) {
		ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
		ContinenteEntity contineteSave = contienteRepository.save(entity);/// aca se le asigna el id
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(contineteSave);
		return result;
	}

	@Override
	public List<ContinenteDTO> getAllContinentes() {
		List<ContinenteEntity> lista = contienteRepository.findAll();
		List<ContinenteDTO> resultado = continenteMapper.listarEntity2DTO(lista);
		return resultado;
	}

	public void delete(Long id) {
		contienteRepository.deleteById(id);
	}

	@Modifying
	public void update(Long id, ContinenteDTO dto) {
		Optional<ContinenteEntity> continente = contienteRepository.findById(id);
		if (continente != null) {
			ContinenteEntity existente = continente.get();
			existente = continenteMapper.update(existente, dto);
			contienteRepository.save(existente);
		} else {
			System.out.println("no existe");
		}
	}

}
