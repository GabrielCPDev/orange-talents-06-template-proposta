package com.zupedu.gabriel.microservico.dtos;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import com.zupedu.gabriel.microservico.entities.BloqueiaCartao;
import com.zupedu.gabriel.microservico.entities.Proposta;

public class BloqueiaCartaoDTO {
	
	@NotBlank
    private String cliente;
    @NotBlank
    private String funcionario;

    public BloqueiaCartaoDTO() {
    	
    }
    
    public BloqueiaCartaoDTO(String userAgent, HttpServletRequest ipClient) {
        this.funcionario = userAgent;
        getIpClientRequest(ipClient);
    }

    public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	private void getIpClientRequest(HttpServletRequest request) {
        String ip = request.getHeader("X-Forward-For");
        if (ip.equals(null)) {
            ip = request.getRemoteAddr();
        }
        this.cliente = ip;
    }
	
	  public BloqueiaCartao toEntity(Proposta proposta) {
	        return new BloqueiaCartao(cliente, funcionario, proposta);
	    }

}
