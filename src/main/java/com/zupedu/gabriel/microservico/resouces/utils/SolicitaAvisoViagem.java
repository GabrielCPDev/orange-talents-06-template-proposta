package com.zupedu.gabriel.microservico.resouces.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-cartoes-aviso", url = "http://localhost:8888/api/cartoes/")
public interface SolicitaAvisoViagem {

    @PostMapping("{id}/avisos")
    AvisoResponse getAviso(@PathVariable("id") String idCartao, @RequestBody AvisoRequest request);
}
