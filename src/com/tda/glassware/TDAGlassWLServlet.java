package com.tda.glassware;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TDAGlassWLServlet  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		ArrayList<String> str = new ArrayList<String>();
		str.add("AAPL");
		str.add("AMTD");
		str.add("GOOG");
		
		// Insert Page into user timeline
		String html =TDAQuotes.insertAndSaveSimpleTextTimelineItem(req);
		
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().append(html);
		
	}
	
	
}