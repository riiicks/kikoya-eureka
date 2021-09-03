package com.mx.kikoya.services.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class Utils {

	public static void sendMessageJSON(HttpServletResponse response, String mensaje, int codigo, String estatus) throws IOException {

		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

		response.setContentType("application/json");

		response.setCharacterEncoding("UTF-8");

		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);

		Writer out = responseWrapper.getWriter();

		out.write("{ \"codigo\": "+" \""+codigo+"\", \"mensaje\": \"" + mensaje + "\" , \"estatus\": \"" + estatus + "\"}");

		out.flush();

		out.close();

	}

}
