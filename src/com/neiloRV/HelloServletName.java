package com.neiloRV;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServletName extends HttpServlet {

	private ArrayList<String> names = new ArrayList<String>();

	private String getAllNames() {
		String responseCode = "";
		for (int i = 0; i < names.size(); i++) {
			responseCode = responseCode + names.get(i) + "<br>";
		}
		return responseCode;
	}

	private boolean findNameInList(String newName) {
		for (int i = 0; i < names.size(); i++) {
			if (newName.equalsIgnoreCase(names.get(i))) {
				return true;
			}
		}
		return false;
	}

	private String makeCorrectSpelling(String name) {
		String firstletter = (name.substring(0, 1)).toUpperCase();
		String otherLetter = (name.substring(1, name.length() - 1)).toLowerCase();
		String correctNameSpelling = firstletter + otherLetter;
		return correctNameSpelling;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");

		if (findNameInList(name)) {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<h1>This name '" + name + "' is already contained in list. " + "<br>"
					+ "Full list: " + getAllNames() + "</h1>");

		} else {
			String correctNameSpelling = makeCorrectSpelling(name);
			names.add(names.size(), correctNameSpelling);
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println(
					"<h1>New name in list is: " + name + "<br>" + "All names in list: " + getAllNames() + "</h1>");
		}
	}
}
