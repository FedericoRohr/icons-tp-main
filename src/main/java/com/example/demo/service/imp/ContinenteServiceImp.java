package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.entity.ContinenteEntity;
import com.example.demo.exeption.ParamNotFound;
import com.example.demo.mapper.ContinenteMapper;
import com.example.demo.repository.ContinenteRepository;
import com.example.demo.service.ContinenteService;
import com.example.demo.service.PaisService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class ContinenteServiceImp implements ContinenteService {
	@Autowired
	private PaisService paisService;
	@Autowired
	private ContinenteMapper continenteMapper;
	@Autowired
	private ContinenteRepository contienteRepository;

	@Override
	@Transactional
	public ContinenteDTO save(ContinenteDTO dto) {
		ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
		ContinenteEntity contineteSave = contienteRepository.save(entity);/// aca se le asigna el id
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(contineteSave);
		return result;
	}

	@Override
	@Transactional
	public List<ContinenteDTO> getAllContinentes() {
		List<ContinenteEntity> lista = contienteRepository.findAll();
		List<ContinenteDTO> resultado = continenteMapper.listarEntity2DTO(lista);
		return resultado;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		contienteRepository.deleteById(id);
		paisService.deleteByContinente(id);
		}

	@Override
	@Modifying
	@Transactional
	public void update(Long id, ContinenteDTO dto) {
		Optional<ContinenteEntity> continente = contienteRepository.findById(id);
		if(!continente.isPresent()) {
			throw new ParamNotFound("id no valido");
		}
			ContinenteEntity existente = continente.get();
			existente = continenteMapper.update(existente, dto);
			contienteRepository.save(existente);
		
	}

}
