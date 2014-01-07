package com.tda.glassware.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tda.glassware.SessionUtils;



public class AuthFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException{
	// Pickup here from break
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (isRedirectable(request)
				&& !AuthUtils.hasAccessToken(SessionUtils.getUserId(request))){
			response.sendRedirect(AuthUtils.OAUTH2_PATH);
			return;
		}
		
		// Execute the rest of the filter chain 
		fc.doFilter(request, response);
		
	}
	
	private boolean isRedirectable(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return !request.getRequestURI().equals(AuthUtils.OAUTH2_PATH);
	}

	public void init( FilterConfig fc) throws ServletException {}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
