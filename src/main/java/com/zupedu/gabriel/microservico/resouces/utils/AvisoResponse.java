package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class AvisoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	public String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public boolean isValid() {
		return resultado.equals("CRIADO");
	}
}
