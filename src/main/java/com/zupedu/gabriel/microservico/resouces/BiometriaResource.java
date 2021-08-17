package com.zupedu.gabriel.microservico.resouces;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zupedu.gabriel.microservico.dtos.BiometriaNewDTO;
import com.zupedu.gabriel.microservico.repositories.BiometriaRepository;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.DataIntegrityException;

@RestController
@RequestMapping(value = "/propostas")
public class BiometriaResource {

	@Autowired
	private BiometriaRepository biometriaRepository;
	@Autowired
	private PropostaRepository propostaRepository;

	@PostMapping("/{id}")
	public ResponseEntity<Void> save(@PathVariable Long id, @RequestBody @Valid BiometriaNewDTO dto) {
		if(propostaRepository.existsById(id)) {
			throw new DataIntegrityException("Já existte uma proposta para esse cliente!");
		}
		var proposta = propostaRepository.findById(id);
		var biometria = dto.toEntity(proposta.get());
		var entitySaved = biometriaRepository.save(biometria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/biometria/{id}")
				.buildAndExpand(entitySaved.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
