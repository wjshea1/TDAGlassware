
package com.tda.glassware.jsonobjects;

import java.util.List;

public class EventCounts{
   	private Number ConferenceCalls;
   	private Number Date;
   	private Number Dividends;
   	private Number Earnings;
   	private Number IPOs;
   	private Number Splits;

 	public Number getConferenceCalls(){
		return this.ConferenceCalls;
	}
	public void setConferenceCalls(Number conferenceCalls){
		this.ConferenceCalls = conferenceCalls;
	}
 	public Number getDate(){
		return this.Date;
	}
	public void setDate(Number date){
		this.Date = date;
	}
 	public Number getDividends(){
		return this.Dividends;
	}
	public void setDividends(Number dividends){
		this.Dividends = dividends;
	}
 	public Number getEarnings(){
		return this.Earnings;
	}
	public void setEarnings(Number earnings){
		this.Earnings = earnings;
	}
 	public Number getIPOs(){
		return this.IPOs;
	}
	public void setIPOs(Number iPOs){
		this.IPOs = iPOs;
	}
 	public Number getSplits(){
		return this.Splits;
	}
	public void setSplits(Number splits){
		this.Splits = splits;
	}
}
