package com.zupedu.gabriel.microservico.resouces.utils;

public class BloqueioResponse {

	private String resultado;

	public BloqueioResponse() {
	}

	public String getResultado() {
		return resultado;
	}

	public boolean isValid() {
		if (resultado.equals("BLOQUEADO")) {
			System.out.println("Resultado request: " + resultado);
			return true;
		}
		return false;
	}

}
