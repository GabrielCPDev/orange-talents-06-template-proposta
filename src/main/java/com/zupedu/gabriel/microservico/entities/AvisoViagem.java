package com.zupedu.gabriel.microservico.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aviso_viagem")
public class AvisoViagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idCartao;
	private String destino;
	private LocalDate dataTermino;
	private LocalDateTime dataCriacao;
	private String ipCliente;
	private String userAgente;

	@ManyToOne
	private Proposta proposta;

	public AvisoViagem(String destino, LocalDate dataTermino, String ipCliente, String userAgente, Proposta proposta) {
		this.destino = destino;
		this.dataTermino = dataTermino;
		this.ipCliente = ipCliente;
		this.userAgente = userAgente;
		this.dataCriacao = LocalDateTime.now();
		this.idCartao = proposta.getCartao();
	}

	public Long getId() {
		return id;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgente() {
		return userAgente;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public boolean isValidIdCartao() {
		if (idCartao != null) {
			return true;
		}
		return false;
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
		AvisoViagem other = (AvisoViagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
