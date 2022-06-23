package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.IconFilterDTO;
import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.entity.IconEntity;
import com.example.demo.entity.PaisEntity;
import com.example.demo.exeption.ParamNotFound;
import com.example.demo.mapper.IconoMapper;
import com.example.demo.repository.IconoRepository;
import com.example.demo.repository.PaisRepository;
import com.example.demo.repository.specification.IconSpecification;
import com.example.demo.service.IconoService;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class IconoServiceImp implements IconoService {
	@Autowired
	private IconoMapper iconoMapper;
	@Autowired
	private IconoRepository iconoRepository;
	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private IconSpecification iconSpecification;

	@Override
	@Transactional
	public IconoDTO save(IconoDTO dto) {
		IconEntity entity = iconoMapper.iconDTO2Entity(dto);
		IconEntity entitySave = iconoRepository.save(entity);
		IconoDTO resultado = iconoMapper.iconEntity2DTO(entitySave, false);
		return resultado;
	}

	@Override
	@Transactional
	public List<IconoBasicDTO> getAll() {
		List<IconEntity> lista = iconoRepository.findAll();
		List<IconoBasicDTO> resultado = iconoMapper.listIconoEntity2BasicDTO(lista);
		return resultado;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iconoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void update(Long id, IconoDTO dto) {
		Optional<IconEntity> icono = iconoRepository.findById(id);
		if(!icono.isPresent()) {
			throw new ParamNotFound("id no valido");
		}
			IconEntity existente = icono.get();
			existente = iconoMapper.update(existente, dto);
			iconoRepository.save(existente);
		

	}
	@Override
	@Transactional
	public IconoDTO getOne(Long id) {
		return iconoMapper.iconEntity2DTO(iconoRepository.getById(id), true);
	}
	@Override
	@Transactional 
	@Modifying
	public void addPais(Long id, Long id2) {
		IconEntity icono = iconoRepository.getById(id);
		PaisEntity pais = paisRepository.getById(id2);
		pais.addIcon(icono);
		paisRepository.save(pais);
	}
	@Override
	@Transactional
	@Modifying
	public void removePais(Long id, Long id2) {
		IconEntity icono = iconoRepository.getById(id);
		PaisEntity pais = paisRepository.getById(id2);
		pais.removeicon(icono);
		paisRepository.save(pais);
	}

	@Override
	@Transactional
	public List<IconoDTO> getDetailsByFilter(String name, String date, List<Long> cities, String order) {
		IconFilterDTO filter = new IconFilterDTO(name, date, cities, order);
		List<IconEntity> iconos = iconoRepository.findAll(iconSpecification.getByFilters(filter));
		List<IconoDTO> resultado = iconoMapper.iconoEntity2DTOlist(iconos, true);
		return resultado;
	}

}
