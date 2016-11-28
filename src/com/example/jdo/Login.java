package com.example.jdo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String username = (String) req.getParameter("username");

		String password = (String) req.getParameter("password");

		boolean flag = false;

		flag = UserDataBase.loginUser(username, password);

		System.out.println("returned flag" + flag);
		
		// after authentication

		if (flag) {

			if (username.equals("san") && password.equals("san")) {

				System.out.println("inside main part of login");
				HttpSession session = req.getSession();

				session.setAttribute("username", username);
				resp.getWriter().write("true");

				
			} else {

				HttpSession session = req.getSession();

				session.setAttribute("username", username);
				System.out.println("inside else part of login");

				
			}

		} else {
			out.println("Sorry Please Enter the correct User Details");

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);

		}

	}
}
