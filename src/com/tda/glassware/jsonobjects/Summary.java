
package com.tda.glassware.jsonobjects;

public class Summary {
   	private String NASDAQ;
   	private String DJIA;
    private String SPX;

 	public String getNASDAQ(){
		return this.NASDAQ;
	}
	public void setNASDAQ(String NASDAQ){
		this.NASDAQ = NASDAQ;
	}


    public String getSPX() {
        return SPX;
    }

    public void setSPX(String SPX) {
        this.SPX = SPX;
    }

    public String getDJIA() {
        return DJIA;
    }

    public void setDJIA(String DJIA) {
        this.DJIA = DJIA;
    }
}
