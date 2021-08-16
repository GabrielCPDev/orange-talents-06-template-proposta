package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class CartaoResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String emitidoEm;
	private String titular;
	
	public CartaoResponse() {
		
	}

    public CartaoResponse(String id, String emitidoEm, String titular) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmitidoEm() {
		return emitidoEm;
	}

	public void setEmitidoEm(String emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
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
		CartaoResponse other = (CartaoResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
