package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ContinenteDTO;
import com.example.demo.dto.IconoBasicDTO;
import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.service.IconoService;

@Controller
@RequestMapping("icons")
public class IconoController {
@Autowired
private IconoService iconoService;
@PostMapping
public ResponseEntity<IconoDTO>creat(@RequestBody IconoDTO dto){
	IconoDTO icono=iconoService.save(dto);
	return ResponseEntity.status(HttpStatus.CREATED).body(icono);
}

@GetMapping
public ResponseEntity<List<IconoBasicDTO>> getAll(){
	List<IconoBasicDTO> lista =iconoService.getAll();
	return ResponseEntity.ok().body(lista);
	
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delte(@PathVariable Long id){
	iconoService.delete(id);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}


@PutMapping("/{id}")
public ResponseEntity<Void>update(@PathVariable Long id , @RequestBody IconoDTO icono){
iconoService.update(id, icono);
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}


}
