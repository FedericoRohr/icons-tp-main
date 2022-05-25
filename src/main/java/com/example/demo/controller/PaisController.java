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
import com.example.demo.dto.IconoDTO;
import com.example.demo.dto.PaisBasicDTO;
import com.example.demo.dto.PaisDTO;
import com.example.demo.service.PaisService;

@RestController
@RequestMapping("paises")
public class PaisController {

@Autowired
PaisService paisService;
@PostMapping
	public  ResponseEntity<PaisDTO> creat(@RequestBody PaisDTO dto) {
		PaisDTO pais=  paisService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pais);
	}

@GetMapping
public ResponseEntity<List<PaisBasicDTO>> getAll(){// works whith PaisBasicDTO
	List<PaisBasicDTO>lista=paisService.getAll();
	return ResponseEntity.ok().body(lista);
	
}

@GetMapping("/{id}")
public ResponseEntity<PaisDTO> getOne(@PathVariable Long id){
	PaisDTO returnable = paisService.getOne(id);
	return ResponseEntity.ok().body(returnable);
	
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delte(@PathVariable Long id){
	paisService.delete(id);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}

@PutMapping("/{id}")
public ResponseEntity<Void>update(@PathVariable Long id , @RequestBody PaisDTO pais){
paisService.update(id, pais);
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}

}
