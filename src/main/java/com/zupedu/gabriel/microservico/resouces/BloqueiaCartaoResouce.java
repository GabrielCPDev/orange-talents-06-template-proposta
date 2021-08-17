package com.zupedu.gabriel.microservico.resouces;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zupedu.gabriel.microservico.dtos.BloqueiaCartaoDTO;
import com.zupedu.gabriel.microservico.repositories.BloqueioCartaoRepository;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/bloqueio")
public class BloqueiaCartaoResouce {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private BloqueioCartaoRepository bloqueioCartaoRepository;

	@PostMapping("/{id}")
	private ResponseEntity<Void> bloqueiaCartao(@PathVariable Long id,
			@RequestHeader("User-Agent") @Valid String funcionario, @Valid HttpServletRequest cliente) {

		if (!propostaRepository.existsById(id)) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		var dto = new BloqueiaCartaoDTO(funcionario, cliente);
		var proposta = propostaRepository.findById(id);
		var bloqueio = dto.toEntity(proposta.get());

		var entitySaved = bloqueioCartaoRepository.save(bloqueio);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/bloqueio/{id}")
				.buildAndExpand(entitySaved.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
