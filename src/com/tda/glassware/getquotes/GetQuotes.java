
package com.tda.glassware.getquotes;

import java.util.List;

public class GetQuotes{
   	private List<Quotes> Quotes;
   	private Number Status;

 	public List<Quotes> getQuotes(){
		return this.Quotes;
	}
	public void setQuotes(List<Quotes> quotes){
		this.Quotes = quotes;
	}
 	public Number getStatus(){
		return this.Status;
	}
	public void setStatus(Number status){
		this.Status = status;
	}
}
