package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContinenteDTO;

public interface ContinenteService {
	public ContinenteDTO save(ContinenteDTO dto);
	
	public List<ContinenteDTO> getAllContinentes();

	public void delete(Long id);

	public void update(Long id, ContinenteDTO continente);
	
}
