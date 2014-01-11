package com.tda.glassware;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PageManager {
	
	static public void setLastPageId(String pageId, String userId){
		DatastoreService store = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey(PageManager.class.getSimpleName(), userId);
		
		Entity entity = new Entity( key );
		entity.setProperty("lastId", pageId);
		store.put(entity);
	}
	
	public static String getLastPageId(String userId){
		DatastoreService store = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey(PageManager.class.getSimpleName(), userId);
		try {
			Entity userData = store.get(key);
			return (String) userData.getProperty("lastId");
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

}
