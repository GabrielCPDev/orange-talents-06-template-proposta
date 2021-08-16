package com.zupedu.gabriel.microservico.resouces;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zupedu.gabriel.microservico.dtos.PropostaDTO;
import com.zupedu.gabriel.microservico.entities.enums.Status;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.DataIntegrityException;
import com.zupedu.gabriel.microservico.resouces.utils.StatusClienteResponse;

import feign.FeignException;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaResource {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private SituacaoClienteResouce situacaoCliente;

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody PropostaDTO dto) {
		dto.setStatus(Status.EM_ANALISE);
		var entityToSave = dto.toEntity();

		try {
			StatusClienteResponse status = situacaoCliente.getStatus(new PropostaDTO(entityToSave));
			entityToSave.setStatus(Status.ELEGIVEL);
			var entitySaved = propostaRepository.save(entityToSave);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entitySaved.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		} catch (FeignException e) {
			entityToSave.setStatus(Status.NAO_ELEGIVEL);
			propostaRepository.save(entityToSave);
			throw new DataIntegrityException("Documento com restrição!");
		}

	}

}
