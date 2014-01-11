package com.tda.glassware;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TDAGlassware2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String html = TDAIndexes.getIndexes();
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().append(html);
		
		// Insert Page into user timeline
		TDAIndexes.insertAndSaveSimpleTextTimelineItem(req);
	}
	
	
}
