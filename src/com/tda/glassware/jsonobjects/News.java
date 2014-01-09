
package com.tda.glassware.jsonobjects;

public class News{
   	private Number DocumentDate;
   	private String DocumentKey;
   	private String Headline;
   	private String Source;
   	private String Teaser;

 	public Number getDocumentDate(){
		return this.DocumentDate;
	}
	public void setDocumentDate(Number documentDate){
		this.DocumentDate = documentDate;
	}
 	public String getDocumentKey(){
		return this.DocumentKey;
	}
	public void setDocumentKey(String documentKey){
		this.DocumentKey = documentKey;
	}
 	public String getHeadline(){
		return this.Headline;
	}
	public void setHeadline(String headline){
		this.Headline = headline;
	}
 	public String getSource(){
		return this.Source;
	}
	public void setSource(String source){
		this.Source = source;
	}
 	public String getTeaser(){
		return this.Teaser;
	}
	public void setTeaser(String teaser){
		this.Teaser = teaser;
	}
}
