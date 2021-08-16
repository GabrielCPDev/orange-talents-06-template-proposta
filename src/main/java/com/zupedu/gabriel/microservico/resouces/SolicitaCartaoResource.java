package com.zupedu.gabriel.microservico.resouces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zupedu.gabriel.microservico.resouces.utils.CartaoResponse;
import com.zupedu.gabriel.microservico.resouces.utils.PropostaEnviada;

@FeignClient(name = "api-cartoes", url = "http://localhost:8888/api/cartoes")
public interface SolicitaCartaoResource {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    CartaoResponse getCartao(PropostaEnviada proposta);    
}
