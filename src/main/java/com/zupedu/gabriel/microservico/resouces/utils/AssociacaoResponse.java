package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class AssociacaoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String resultado;
	private String id;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isValid() {
		return resultado.equals("ASSOCIADA");
	}

}
