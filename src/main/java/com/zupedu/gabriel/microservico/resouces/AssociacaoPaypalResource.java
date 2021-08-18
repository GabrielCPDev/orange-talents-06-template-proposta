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

import com.zupedu.gabriel.microservico.dtos.CarteiraNewDTO;
import com.zupedu.gabriel.microservico.repositories.CarteiraRepository;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.InternalErrorException;
import com.zupedu.gabriel.microservico.resouces.utils.CarteiraRequest;
import com.zupedu.gabriel.microservico.resouces.utils.SolicitaAssociacao;

@RestController
@RequestMapping("/carteira/paypal")
public class AssociacaoPaypalResource {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private CarteiraRepository carteiraRepository;
	@Autowired
	private SolicitaAssociacao solicitaAssociacao;

	@PostMapping("/{id}")
	public ResponseEntity<Void> save(@PathVariable Long id, @Valid @RequestBody CarteiraNewDTO dto) {
		var proposta = propostaRepository.findById(id);

		if (!proposta.isPresent()) {
			throw new InternalErrorException("Proposta não encontrada!");
		}
		var carteira = dto.toEntity(proposta.get());

		String idCartao = carteira.getIdCartao();
		String email = carteira.getEmail();
		String nomeCarteira = carteira.getCarteira();
		var carteiraParaEnviar = new CarteiraRequest(email, nomeCarteira);
		var associaResposta = solicitaAssociacao.getAssociaCarteira(idCartao, carteiraParaEnviar);

		if (!associaResposta.isValid() && !carteira.isValidId()) {
			throw new InternalErrorException("Processo não foi finalizado!");
		}
		var entitySaved = carteiraRepository.save(carteira);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/biometria/{id}")
				.buildAndExpand(entitySaved.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
}
