package com.neiloRV;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class MinimalServlets {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);

		handler.addServletWithMapping((Class<? extends Servlet>) HelloServletBasic.class, "/1");
		handler.addServletWithMapping((Class<? extends Servlet>) HelloServletNeilo.class, "/2");
		handler.addServletWithMapping((Class<? extends Servlet>) HelloServletName.class, "/3");

		server.start();

		server.join();
	}
}
