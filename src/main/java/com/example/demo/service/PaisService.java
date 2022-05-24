package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;

public interface PaisService {

	public PaisDTO save(PaisDTO dto);

	public List<PaisBasicDTO>  getAll();

	public void delete(Long id);

	public void update(Long id, PaisDTO pais);
 
}
