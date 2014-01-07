/**
 * 
 */
package com.tda.glassware.auth;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tda.glassware.SessionUtils;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
/**
 * @author bill
 *
 */
public class OAuth2Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		if(!hasError( req, res)){
			res.sendRedirect( doAuth(req));
			
		}
	}

	private boolean hasError(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return false;
	}

	private String doAuth(HttpServletRequest req) throws IOException{
		// TODO Auto-generated method stub
		String authCode = req.getParameter("code");
		
		String callbackUri = AuthUtils.fullUrl(req, AuthUtils.OAUTH2_PATH);
		
		AuthorizationCodeFlow flow = AuthUtils.buildCodeFlow();
		
		if ( authCode == null){
			return flow.newAuthorizationUrl().setRedirectUri(callbackUri).build();
		}
		
		GoogleTokenResponse tokenRes = getTokenRes ( flow, authCode, callbackUri);
		
		String userId = getUserId( tokenRes );
		
		SessionUtils.setUserId( req, userId);
		flow.createAndStoreCredential(tokenRes, userId);
		
		return "/";
		
	}
	
	/**
	   * Makes a remote call to the Google Auth server to authorize the grant code,
	   * in order to issue a request token.
	   * @param flow
	   * @param code
	   * @param callbackUri
	   * @return
	   * @throws IOException
	   */
	private GoogleTokenResponse getTokenRes( AuthorizationCodeFlow flow, String code, String callbackUri ) 
		      throws IOException
		  {
		    AuthorizationCodeTokenRequest tokenReq = flow
		        .newTokenRequest( code )
		        .setRedirectUri( callbackUri );

		    TokenResponse tokenRes = tokenReq.execute();
		    
		    return (GoogleTokenResponse)tokenRes;
		  }
	
	  /**
	   * Extract the Google user ID from the ID token in the auth response
	   */
	  private String getUserId( GoogleTokenResponse tokenRes )
	      throws IOException
	  {
	    return tokenRes.parseIdToken().getPayload().getUserId();
	  }

}
