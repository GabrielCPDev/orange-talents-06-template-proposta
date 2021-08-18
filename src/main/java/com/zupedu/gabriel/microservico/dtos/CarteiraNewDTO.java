package com.zupedu.gabriel.microservico.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.zupedu.gabriel.microservico.entities.Carteira;
import com.zupedu.gabriel.microservico.entities.Proposta;

public class CarteiraNewDTO {
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String carteira;
	
	public CarteiraNewDTO() {
		
	}

	public CarteiraNewDTO(@NotBlank @Email String email, @NotBlank String carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}
	public CarteiraNewDTO(Carteira entity) {
		email = entity.getEmail();
		carteira = entity.getCarteira();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	
	public Carteira toEntity(Proposta proposta) {
        return new Carteira(email, carteira, proposta);
    }

}
