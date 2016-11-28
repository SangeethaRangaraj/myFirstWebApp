package com.example.jdo;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		String uname = (String) session.getAttribute("userrname");
		String username = req.getParameter("user");
		
		if (username.equals(null) || username.equals("")|| username.equals(" ")) {
			resp.getWriter().write("false");
		}
		
		else if (!username.equals(null)) {

			PersistenceManager obj = PMF.get().getPersistenceManager();

			try {

				User u = obj.getObjectById(User.class, username);
				obj.deletePersistent(u);
				resp.getWriter().write("true");
			   }
			
			catch (Exception e) {
				System.out.println("inside excp in del");
				e.printStackTrace();
				resp.getWriter().write("false");
			}
		}
	}
}
