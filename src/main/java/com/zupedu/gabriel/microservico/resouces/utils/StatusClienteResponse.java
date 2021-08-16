package com.zupedu.gabriel.microservico.resouces.utils;

import com.zupedu.gabriel.microservico.entities.enums.StatusCliente;

public class StatusClienteResponse {

	private String documento;
	private String nome;
	private String resultadoSolicitacao;
	private String idProposta;

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public StatusCliente getResultadoSolicitacao() {
		if (resultadoSolicitacao.equals("SEM_RESTRICAO")) {
			return StatusCliente.SEM_RESTRICAO;
		}
		return StatusCliente.COM_RESTRICAO;
	}

	public String getIdProposta() {
		return idProposta;
	}
}
