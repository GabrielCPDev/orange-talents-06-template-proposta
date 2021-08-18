package com.zupedu.gabriel.microservico.resouces;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zupedu.gabriel.microservico.dtos.AvisoViagemDTO;
import com.zupedu.gabriel.microservico.repositories.AvisoViagemRepository;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.InternalErrorException;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.ObjectNotFoundException;
import com.zupedu.gabriel.microservico.resouces.utils.AvisoRequest;
import com.zupedu.gabriel.microservico.resouces.utils.SolicitaAvisoViagem;

@RestController
@RequestMapping(value = "/viagem")
public class AvisoViagemResource {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private AvisoViagemRepository avisoViagemRepository;
	@Autowired
	private SolicitaAvisoViagem solicitaAvisoViagem;

	@PostMapping("/{id}")
	public ResponseEntity<Void> save(@PathVariable Long id, @Valid @RequestBody AvisoViagemDTO dto,
			@RequestHeader("User-Agent") String funcionario, HttpServletRequest cliente) {

		if (!propostaRepository.existsById(id)) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		var proposta = propostaRepository.findById(id);
		var avisoViagem = dto.toEntity(funcionario, cliente.getHeader("X-Forward-For"), proposta.get());
		var avisoEnviado = new AvisoRequest(dto.getDestino(), dto.getDataTerminoToString());
		var avisoResponse = solicitaAvisoViagem.getAviso(avisoViagem.getIdCartao(), avisoEnviado);
		
		if (!avisoViagem.isValidIdCartao() && !avisoResponse.isValid()) {
			throw new InternalErrorException("Cartão Inválido!");
		}
		var entitySaved = avisoViagemRepository.save(avisoViagem);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/biometria/{id}")
				.buildAndExpand(entitySaved.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
