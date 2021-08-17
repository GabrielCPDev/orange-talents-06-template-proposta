package com.zupedu.gabriel.microservico.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.gabriel.microservico.entities.AvisoViagem;
import com.zupedu.gabriel.microservico.entities.Proposta;

public class AvisoViagemDTO {

	@NotBlank
	private String destino;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataTermino;

	public AvisoViagemDTO() {
	}
	

	public AvisoViagemDTO(@NotBlank String destino, @Future @NotNull LocalDate dataTermino) {
		super();
		this.destino = destino;
		this.dataTermino = dataTermino;
	}
	public AvisoViagemDTO(AvisoViagem entity) {
		this.dataTermino = entity.getDataTermino();
		this.destino = entity.getDestino();
	}


	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public AvisoViagem toEntity(String userAgente, String ipCliente, Proposta proposta) {
		return new AvisoViagem(destino, dataTermino, ipCliente, userAgente, proposta);
	}
}
