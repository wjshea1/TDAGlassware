
package com.tda.glassware.getquotes;

import java.util.List;

public class Quotes{
   	private Number ChangeAmt;
   	private Number ChangePct;
   	private Number LastPrice;
   	private String Name;
   	private List quotesLast5Days;
   	private String Symbol;
   	private Number Volume;
   	private Number YearHigh;
   	private Number YearLow;

 	public Number getChangeAmt(){
		return this.ChangeAmt;
	}
	public void setChangeAmt(Number changeAmt){
		this.ChangeAmt = changeAmt;
	}
 	public Number getChangePct(){
		return new Float(this.ChangePct.floatValue());
	}
	public void setChangePct(Number changePct){
		this.ChangePct = changePct;
	}
 	public Number getLastPrice(){
		return this.LastPrice;
	}
	public void setLastPrice(Number lastPrice){
		this.LastPrice = lastPrice;
	}
 	public String getName(){
		return this.Name;
	}
	public void setName(String name){
		this.Name = name;
	}
 	public List getQuotesLast5Days(){
		return this.quotesLast5Days;
	}
	public void setQuotesLast5Days(List quotesLast5Days){
		this.quotesLast5Days = quotesLast5Days;
	}
 	public String getSymbol(){
		return this.Symbol;
	}
	public void setSymbol(String symbol){
		this.Symbol = symbol;
	}
 	public Number getVolume(){
		return this.Volume;
	}
	public void setVolume(Number volume){
		this.Volume = volume;
	}
 	public Number getYearHigh(){
		return this.YearHigh;
	}
	public void setYearHigh(Number yearHigh){
		this.YearHigh = yearHigh;
	}
 	public Number getYearLow(){
		return this.YearLow;
	}
	public void setYearLow(Number yearLow){
		this.YearLow = yearLow;
	}
}
