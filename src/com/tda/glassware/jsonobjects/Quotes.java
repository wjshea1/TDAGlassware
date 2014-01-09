
package com.tda.glassware.jsonobjects;

import java.util.List;

public class Quotes{
   	private List Futures;
   	private List Global;
   	private List Indices;

 	public List getFutures(){
		return this.Futures;
	}
	public void setFutures(List futures){
		this.Futures = futures;
	}
 	public List getGlobal(){
		return this.Global;
	}
	public void setGlobal(List global){
		this.Global = global;
	}
 	public List getIndices(){
		return this.Indices;
	}
	public void setIndices(List indices){
		this.Indices = indices;
	}
}
