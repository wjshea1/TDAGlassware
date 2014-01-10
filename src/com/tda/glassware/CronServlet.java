package com.tda.glassware;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CronServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		// Get MirrorUtils
		MirrorUtils.getMirror(req);
		
		
		// Create Pages
		
		
	}

}
