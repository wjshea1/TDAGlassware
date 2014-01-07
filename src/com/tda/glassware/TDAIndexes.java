package com.tda.glassware;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TDAIndexes {
	public static void getIndexes(){
		// This function will return a simple array of indices
		String urlParameters = "";
		try {
			URL url = new URL ("http://");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e){
			
		}
	}
	
	public static String render(){
		
		// this method will return indexes render using free Marker
		
		return "";
	}

}
