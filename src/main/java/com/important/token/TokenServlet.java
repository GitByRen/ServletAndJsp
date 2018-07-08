package com.important.token;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		Object token = session.getAttribute("token");
		String tokenValue = request.getParameter("token");
		if (token != null && tokenValue.equals(token)) {
			session.removeAttribute("token");
		} else {
			response.sendRedirect(request.getContextPath() + "/Session/success.jsp");
			return ;
		}*/
		
		boolean valid = TokenProcessor.getInstance().isTokenValid(request);
		if (valid) {
			TokenProcessor.getInstance().resetToken(request);
		} else {
			response.sendRedirect(request.getContextPath() + "/Session/success.jsp");
			return;
		}
	}

}
