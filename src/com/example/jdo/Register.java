package com.example.jdo;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/plain");

		PrintWriter out = resp.getWriter();

		String username = (String) req.getParameter("username");
		
		String firstname = (String) req.getParameter("firstname");
		String lastname = (String) req.getParameter("lastname");
		String password = (String) req.getParameter("password");
		String phonenumber = (String) req.getParameter("ph_no");
		String email = (String) req.getParameter("email");

		
		boolean flag = false;

		flag = UserDataBase.create(username, firstname, lastname, password,
				phonenumber, email);

		System.out.println("returned flag" + flag);
		// only if authenticated user
		if (flag) {

			HttpSession session = req.getSession();

			session.setAttribute("username", username);

			resp.sendRedirect("LastPage.jsp");

		}

		else {
			out.println("You are fAILED created ");
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("signUp.jsp");
			dispatcher.forward(req, resp);

		}

	}
}
