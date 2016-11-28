package com.example.jdo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogOut extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		resp.setContentType("text/html");

		resp.sendRedirect("index.jsp");

		// kill the session
		HttpSession session = req.getSession(false);
		String username = (String) session.getAttribute("username");
		if (!username.equals(null)) {
			session.invalidate();
		}

	}
}
