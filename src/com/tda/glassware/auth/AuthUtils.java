package com.tda.glassware.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.extensions.appengine.datastore.AppEngineDataStoreFactory;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.store.DataStore;


public class AuthUtils {

	 public static final List<String> SCOPES = Arrays.asList(
			    "https://www.googleapis.com/auth/userinfo.profile",
			    "https://www.googleapis.com/auth/glass.timeline"
			  );
	 public static final String WEB_CLIENT_ID = "939135273404.apps.googleusercontent.com";
	
	 public static final String WEB_CLIENT_SECRET = "P6yKnJ4GeMRcA53s8-PeE_31";
	 public static final String OAUTH2_PATH = "/oauth2callback";

	
	 public static Credential getCredential(String userId) throws IOException {
		    return userId == null ? null : buildCodeFlow().loadCredential( userId );
		  }

		  public static void deleteCredential(String userId) throws IOException {
		    getDataStore().delete( userId );
		  }

		  public static boolean hasAccessToken(String userId) {
		    try {
		      Credential cred = getCredential(userId);
		      return (cred != null && cred.getAccessToken() != null);
		    } catch (IOException e) {
		      return false;
		    }
		  }

		  public static DataStore<StoredCredential> getDataStore()
		    throws IOException
		  {
		    AppEngineDataStoreFactory factory = AppEngineDataStoreFactory.getDefaultInstance();
		    return StoredCredential.getDefaultDataStore( factory );
		  }
		  
	
	public static AuthorizationCodeFlow buildCodeFlow() throws IOException 
	{
		return new GoogleAuthorizationCodeFlow.Builder(new UrlFetchTransport(), 
				new JacksonFactory(),
				WEB_CLIENT_ID,
				WEB_CLIENT_SECRET, 
				SCOPES)
		.setApprovalPrompt("force")
		.setAccessType("offline")
		.setCredentialDataStore(getDataStore()).build();
	}
	
	public static String fullUrl (HttpServletRequest req, String rawPath)
	{
		
		GenericUrl url = new GenericUrl( new String(req.getRequestURL()));
		url.setRawPath(rawPath);
		return url.build();
		
	}

}
