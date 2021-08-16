package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

import com.zupedu.gabriel.microservico.entities.Proposta;

public class PropostaEnviada implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProposta;
	private String documento;
	private String nome;
	
	public PropostaEnviada() {
		
	}

	public PropostaEnviada(Proposta proposta) {
		super();
		this.idProposta = proposta.getId();
		this.documento = proposta.getCpfOuCnpj();
		this.nome = proposta.getNome();
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProposta == null) ? 0 : idProposta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropostaEnviada other = (PropostaEnviada) obj;
		if (idProposta == null) {
			if (other.idProposta != null)
				return false;
		} else if (!idProposta.equals(other.idProposta))
			return false;
		return true;
	}
	
	
	
}
