package com.zupedu.gabriel.microservico.resouces.exceptions.utils;

public class InternalErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InternalErrorException(String msg) {
		super(msg);
	}

	public InternalErrorException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
