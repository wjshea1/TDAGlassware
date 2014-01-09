
package com.tda.glassware.jsonobjects;

import java.util.List;

public class Global{
    private Number Change;
    private Number ChangePct;
    private Number Last;
    private String Name;
    private String Symbol;

    public Number getChange(){
        return this.Change;
    }
    public void setChange(Number change){
        this.Change = change;
    }
    public Number getChangePct(){
        return this.ChangePct;
    }
    public void setChangePct(Number changePct){
        this.ChangePct = changePct;
    }
    public Number getLast(){
        return this.Last;
    }
    public void setLast(Number last){
        this.Last = last;
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }
    public String getSymbol(){
        return this.Symbol;
    }
    public void setSymbol(String symbol){
        this.Symbol = symbol;
    }
}
