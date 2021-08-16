package com.zupedu.gabriel.microservico.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.zupedu.gabriel.microservico.entities.Proposta;
import com.zupedu.gabriel.microservico.entities.enums.Status;
import com.zupedu.gabriel.microservico.validations.PropostaInsert;

@PropostaInsert
public class PropostaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo obrigatório")
	private String nome;
	@Email(message = "Formato de email inválido")
	private String email;
	@NotBlank(message = "Campo obrigatório")
	private String endereco;
	private Double salario;
	@NotBlank(message = "Campo obrigatório")
	private String cpfOuCnpj;
	private Status status;

	public PropostaDTO() {

	}

	public PropostaDTO(String nome, String email, String endereco, Double salario, String cpfOuCnpj, Status status) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
		this.cpfOuCnpj = cpfOuCnpj;
		this.status = status;
	}
	
	public PropostaDTO(Proposta entity) {
		nome = entity.getNome();
		email = entity.getEmail();
		endereco = entity.getEndereco();
		salario = entity.getSalario();
		cpfOuCnpj = entity.getCpfOuCnpj();
		status = entity.getStatus();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Proposta toEntity () {
		return new Proposta(null, nome, email, endereco, salario, cpfOuCnpj, status);
	}

}
