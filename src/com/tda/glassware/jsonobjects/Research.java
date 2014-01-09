
package com.tda.glassware.jsonobjects;

public class Research{
   	private EventCounts EventCounts;
   	private News News;
   	private Portfolio Portfolio;
   	private Quotes Quotes;
   	private Sectors Sectors;
   	private Summary Summary;

 	public EventCounts getEventCounts(){
		return this.EventCounts;
	}
	public void setEventCounts(EventCounts eventCounts){
		this.EventCounts = eventCounts;
	}
 	public News getNews(){
		return this.News;
	}
	public void setNews(News news){
		this.News = news;
	}
 	public Portfolio getPortfolio(){
		return this.Portfolio;
	}
	public void setPortfolio(Portfolio portfolio){
		this.Portfolio = portfolio;
	}
 	public Quotes getQuotes(){
		return this.Quotes;
	}
	public void setQuotes(Quotes quotes){
		this.Quotes = quotes;
	}
 	public Sectors getSectors(){
		return this.Sectors;
	}
	public void setSectors(Sectors sectors){
		this.Sectors = sectors;
	}
 	public Summary getSummary(){
		return this.Summary;
	}
	public void setSummary(Summary summary){
		this.Summary = summary;
	}
}
