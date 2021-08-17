package com.zupedu.gabriel.microservico.resouces.utils;

import javax.servlet.http.HttpServletRequest;

public class GetClientHeader {
	public static String getIpClientRequest(HttpServletRequest request) {
		String ip = request.getHeader("X-Forward-For");
		if (ip == null) {
			return ip = request.getRemoteAddr();
		}
		return ip;
	}
}
