package com.tda.glassware;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class CronServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// make sure the request is from the appEngine
		if( !"true".equals(req.getHeader("X-AppEngine-Cron")) ) {
			      res.setStatus(403);
			      res.getWriter().append("Only cron can deliver lunches");
			      return;
			    }
		
		ServletContext ctx = getServletContext();
		
		 List<Key> removeKeys = new LinkedList<Key>();
		 
		   DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		    Query q = new Query("User");
		    PreparedQuery pq = datastore.prepare(q);
		    for( Entity result : pq.asIterable() )
		    {
		      String userId = (String)result.getProperty("id");
		      try {
		    	  // Actually we probalby want to do an update here especially 
		    	  TDAIndexes.insertAndSaveSimpleTextTimelineItem(  req,  userId);
		      } catch (GoogleJsonResponseException e) {
		     // END:doget
		        // remove invalid user from the back end
		        removeKeys.add( result.getKey() );
		      }
		    }
		    
		    System.out.print( "Removing keys: " );
		    System.out.println( removeKeys );
		    datastore.delete( removeKeys );

		    res.getWriter().append("Delivered Data!");
		
	}

}
