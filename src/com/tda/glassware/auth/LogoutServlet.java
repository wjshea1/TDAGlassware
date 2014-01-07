package com.tda.glassware.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tda.glassware.SessionUtils;



public class LogoutServlet extends HttpServlet {
	protected void doGet ( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		AuthUtils.deleteCredential( SessionUtils.getUserId(req));
		SessionUtils.removeUserId(req);
		res.getWriter().write("Goodbye!");
	}
}
