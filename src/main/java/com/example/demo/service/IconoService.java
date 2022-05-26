package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisBasicDTO;

public interface IconoService {

	IconoDTO save(IconoDTO dto);

public List<IconoBasicDTO> getAll();

public void delete(Long id);

void update(Long id, IconoDTO icono);

IconoDTO getOne(Long id);

void addPais(Long id, Long id2);

void removePais(Long id, Long id2);


List<IconoDTO> getDetailsByFilter(String name, String date, List<Long> cities, String order);







}
