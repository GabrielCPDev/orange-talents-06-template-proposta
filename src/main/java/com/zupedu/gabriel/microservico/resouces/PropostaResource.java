package com.zupedu.gabriel.microservico.resouces;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zupedu.gabriel.microservico.dtos.PropostaDTO;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaResource {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@PostMapping
	public ResponseEntity<Void> save (@Valid @RequestBody PropostaDTO dto) {		
		var entitySaved = propostaRepository.save(dto.toEntity());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entitySaved.getId()).toUri();
		return ResponseEntity.created(uri).build();
			
	}

}
