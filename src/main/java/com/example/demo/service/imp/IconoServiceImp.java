package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.entity.IconEntity;
import com.example.demo.entity.PaisEntity;
import com.example.demo.mapper.IconoMapper;
import com.example.demo.repository.IconoRepository;
import com.example.demo.service.IconoService;

import lombok.Getter;
import lombok.Setter;
@Service
@Getter @Setter 	
public class IconoServiceImp implements IconoService {
@Autowired
private IconoMapper iconoMapper;
@Autowired
private IconoRepository iconoRepository;

public IconoDTO save(IconoDTO dto) {
IconEntity entity = iconoMapper.IconDTO2Entity(dto);
IconEntity entitySave =iconoRepository.save(entity);
IconoDTO resultado = iconoMapper.IconEntity2DTO(entitySave);
return resultado;
	}

@Override
public List<IconoBasicDTO> getAll() {
	List<IconEntity>lista=iconoRepository.findAll();
	List<IconoBasicDTO>resultado=iconoMapper.ListIconoEntity2BasicDTO(lista);
	return resultado;
}

@Override
public void delete(Long id) {
iconoRepository.deleteById(id);
	}

@Override
public void update(Long id, IconoDTO dto) {
	Optional<IconEntity> icono = iconoRepository.findById(id);
	if (icono != null) {
		IconEntity existente = icono.get();
		existente = iconoMapper.update(existente, dto);
		iconoRepository.save(existente);
	} else {
		System.out.println("no existe");
	}
	
}




	

}
