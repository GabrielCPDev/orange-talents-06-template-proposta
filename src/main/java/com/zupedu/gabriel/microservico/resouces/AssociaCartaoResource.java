package com.zupedu.gabriel.microservico.resouces;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zupedu.gabriel.microservico.entities.Proposta;
import com.zupedu.gabriel.microservico.entities.enums.Status;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.utils.CartaoResponse;
import com.zupedu.gabriel.microservico.resouces.utils.PropostaEnviada;

@Component
public class AssociaCartaoResource {

	@Autowired
	private SolicitaCartaoResource resultadoCartao;
	@Autowired
	private PropostaRepository propostaRepository;

	@Scheduled(fixedDelayString = "PT10S")
	public void associa() {
		try {
			Optional<Proposta> optionalProposta = propostaRepository.findByStatus(Status.ELEGIVEL);
			if (optionalProposta.isPresent()) {
				Proposta proposta = optionalProposta.get();
				CartaoResponse cartao = resultadoCartao.getCartao(new PropostaEnviada(proposta));
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
