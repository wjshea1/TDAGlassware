package com.tda.glassware;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TDAGlassware2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Welcome to TDA Glassware - Coming Soon   ");
	}
}
