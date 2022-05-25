package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.entity.ContinenteEntity;
import com.example.demo.entity.PaisEntity;
import com.example.demo.mapper.PaisMapper;
import com.example.demo.repository.PaisRepository;
import com.example.demo.service.PaisService;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter 
@Service
public class PaisServiceImp implements PaisService {
@Autowired
PaisMapper paisMapper;
@Autowired
PaisRepository paisRepository;

	public PaisDTO save(PaisDTO dto) {
		PaisEntity pais= paisMapper.paisDTO2Entity(dto);
		PaisEntity paisSave=paisRepository.save(pais);
		PaisDTO resultado = paisMapper.paisEntity2DTO(paisSave,false);
		return resultado;
	}

	
	public List<PaisBasicDTO> getAll() {
		List<PaisBasicDTO>resultado=paisMapper.paisEntity2BasicDTO(paisRepository.findAll());
		return resultado;
	}

	
	public void delete(Long id) {
		paisRepository.deleteById(id);
		
	}
	
	@Modifying
	public void update(Long id, PaisDTO dto) {
		Optional<PaisEntity> pais = paisRepository.findById(id);
		if (pais != null) {
			PaisEntity existente = pais.get();
			existente = paisMapper.update(existente, dto);
			paisRepository.save(existente);
		} else {
			System.out.println("no existe");
		}
	}


	
	public PaisDTO getOne(Long id) {
	 return paisMapper.paisEntity2DTO(paisRepository.getById(id), true);
	}


	




}
