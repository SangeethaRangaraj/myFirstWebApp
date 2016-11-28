package com.example.jdo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {

			HttpSession session = request.getSession(false);
			String username = "";

			if (!session.equals(null) && !username.equals(null)) {

				username = (String) session.getAttribute("username");
				System.out.println(username);

				// Http1.1
				response.setHeader("Cache-Control",
						"no-store, no-cache, must-revalidate");

				// Http1.0
				response.setHeader("Pragma", "no-cache");

				// proxy
				response.setDateHeader("Expires", 0);

			}

			else {

				response.sendRedirect("index.jsp");
			}

			// to fetch the next resource in the chain
			chain.doFilter(req, resp);

		} catch (Exception e) {

			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		}

	}

	@Override
	public void destroy() {
		
	}
}