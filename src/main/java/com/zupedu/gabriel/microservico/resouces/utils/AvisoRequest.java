package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class AvisoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String destino;
	private String validoAte;

	public AvisoRequest(String destino, String validoAte) {
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getValidoAte() {
		return validoAte;
	}

	public void setValidoAte(String validoAte) {
		this.validoAte = validoAte;
	}

}
