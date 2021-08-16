package com.zupedu.gabriel.microservico.resouces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zupedu.gabriel.microservico.dtos.PropostaDTO;
import com.zupedu.gabriel.microservico.resouces.utils.StatusClienteResponse;

@FeignClient(name = "analise-situacao-cliente", url = "http://localhost:8081/api/solicitacao")
public interface SituacaoClienteResouce {
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public StatusClienteResponse getStatus(PropostaDTO proposta);

}
