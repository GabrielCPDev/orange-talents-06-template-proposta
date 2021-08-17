package com.zupedu.gabriel.microservico.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bloqueia_cartao")
public class BloqueiaCartao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cliente;
	private String funcionario;
	private LocalDateTime dataCriacao;
	private String idCartao;
	@ManyToOne
	private Proposta proposta;

	public BloqueiaCartao() {

	}

	public BloqueiaCartao(Long id, String cliente, String funcionario, LocalDateTime dataCriacao, String idCartao,
			Proposta proposta) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.dataCriacao = dataCriacao;
		this.idCartao = idCartao;
		this.proposta = proposta;
	}

	public BloqueiaCartao(String cliente, String funcionario, Proposta proposta) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.dataCriacao = LocalDateTime.now();
		this.idCartao = proposta.getCartao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BloqueiaCartao other = (BloqueiaCartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
