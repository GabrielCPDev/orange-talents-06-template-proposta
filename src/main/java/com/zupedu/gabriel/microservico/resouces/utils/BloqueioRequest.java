package com.zupedu.gabriel.microservico.resouces.utils;

import java.io.Serializable;

public class BloqueioRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sistemaResponsavel;

    public BloqueioRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
