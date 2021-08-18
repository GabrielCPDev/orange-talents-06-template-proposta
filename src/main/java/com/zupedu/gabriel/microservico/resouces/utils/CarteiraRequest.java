package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class CarteiraRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String carteira;

	public CarteiraRequest(String email, String carteira) {
	        this.email = email;
	        this.carteira = carteira;
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

}
