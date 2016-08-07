package com.neiloRV;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServletName extends HttpServlet {

	String name;
	ArrayList<String> names = new ArrayList();

	private String getAllNames() {
		String responseCode = "";

		for (int i = 0; i < names.size(); i++) {
			responseCode = responseCode + names.get(i) + "<br>";
		}
		return responseCode;
	}

	private boolean findNameInList(String newName) {
		for (int i = 0; i < names.size(); i++) {
			if (newName.equals(names.get(i))) {
				return true;
			}
		}
		return false;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name");

		if (findNameInList(name)) {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<h1>This name '" + name + "' is already contained in list. " + "<br>"
					+ "Full list: " + getAllNames() + "</h1>");

		} else {
			names.add(names.size(), name);
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println(
					"<h1>New name in list is: " + name + "<br>" + "All names in list: " + getAllNames() + "</h1>");
		}
	}
}
