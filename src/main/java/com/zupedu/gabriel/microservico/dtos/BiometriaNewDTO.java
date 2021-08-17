package com.zupedu.gabriel.microservico.dtos;

import javax.validation.constraints.NotBlank;

import com.zupedu.gabriel.microservico.entities.Biometria;
import com.zupedu.gabriel.microservico.entities.Proposta;

public class BiometriaNewDTO {
	@NotBlank
	private String fingerPrint;

	public BiometriaNewDTO() {

	}

	public BiometriaNewDTO(@NotBlank String fingerPrint) {
		super();
		this.fingerPrint = fingerPrint;
	}

	public BiometriaNewDTO(Biometria entity) {
		fingerPrint = entity.getFingerPrint();
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Biometria toEntity(Proposta proposta) {
		var bio = new Biometria();
		bio.setFingerPrint(fingerPrint);
		bio.setProposta(proposta);
		return bio;
	}

}
