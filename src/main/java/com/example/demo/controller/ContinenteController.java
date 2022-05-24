package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.service.ContinenteService;



@RestController
@RequestMapping("continentes")
public class ContinenteController {
@Autowired
private ContinenteService continenteService;

@GetMapping
public ResponseEntity<List<ContinenteDTO>>getAll(){
	List<ContinenteDTO>continentes=continenteService.getAllContinentes();
	return ResponseEntity.ok().body(continentes);
}
@PostMapping
	public ResponseEntity<ContinenteDTO>save(@RequestBody ContinenteDTO continente){
        ContinenteDTO continenteGuardado = continenteService.save(continente);
		return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
		}
	
@DeleteMapping("/{id}")
public ResponseEntity<Void> delte(@PathVariable Long id){
	continenteService.delete(id);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
	
@PutMapping("/{id}")
public ResponseEntity<Void>update(@PathVariable Long id , @RequestBody ContinenteDTO continente){
continenteService.update(id, continente);
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
	
	
}
