package com.tda.glassware;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TDAGlassware2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		// Insert Page into user timeline
		String html = TDAIndexes.insertAndSaveSimpleTextTimelineItem(req);
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().append(html);
	}
	
	
}
