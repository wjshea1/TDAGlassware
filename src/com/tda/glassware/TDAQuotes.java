package com.tda.glassware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.mirror.Mirror;
import com.google.api.services.mirror.Mirror.Timeline;
import com.google.api.services.mirror.model.MenuItem;
import com.google.api.services.mirror.model.TimelineItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tda.glassware.auth.AuthUtils;
import com.tda.glassware.getquotes.GetQuotes;
import com.tda.glassware.getquotes.Quotes;
import com.tda.glassware.jsonobjects.Research;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class TDAQuotes {
	
	public static TimelineItem getQuotes(List<String> symbols){
		StringBuffer liSymbol = new StringBuffer();
		for(String symb : symbols){
			liSymbol.append(symb).append("|");
		}
        try {
            
        	URL url = new URL ("https://mobileapi.tdameritrade.wallst.com/Quote/IndexPerformance?user_id=mobileapi&user_password=mobileapi&symbols="+URLEncoder.encode(liSymbol.toString(),"UTF-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int status = connection.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    System.out.println( sb.toString());
                    Gson gson = new GsonBuilder().create();
                    GetQuotes r = gson.fromJson(sb.toString() , GetQuotes.class);
                    return render(r);
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        }
        return null;
		
	}
	
	public static TimelineItem render(GetQuotes quotes) throws Exception{

       
        Configuration cfg = new Configuration();

        cfg.setClassForTemplateLoading(TDAQuotes.class, "templates");

        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        
        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "WatchList");
        input.put("data", quotes);
        
        StringBuffer readoutText = new StringBuffer();
        for(Quotes q: quotes.getQuotes()){
        	readoutText.append(q.getName()).append(" Last Price ").append(q.getLastPrice()).append(" Change ").append(q.getChangeAmt()).append(" Change Percent ").append(q.getChangePct()).append("  ");
        }

        freemarker.template.Template template = cfg.getTemplate("Watchlist.ftl");

       
        Writer strout = new StringWriter(); 
        template.process(input, strout);

        TimelineItem timelineItem = new TimelineItem().setHtml(strout.toString());
        List<MenuItem> menuItems = new ArrayList<>();
        MenuItem mi = new MenuItem();
        mi.setAction("READ_ALOUD");
        menuItems.add(mi);
		timelineItem.setMenuItems(menuItems);
        timelineItem.setSpeakableText(readoutText.toString());
        
        return timelineItem;
    }
	
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<String>();
		str.add("AAPL");
		str.add("AMTD");
		str.add("GOOG");
		System.out.println(getQuotes(str));

	}
	
	
	 public static String insertAndSaveSimpleTextTimelineItem( HttpServletRequest req) throws IOException{
	    	
	    	String userId = SessionUtils.getUserId(req);
	    	String pageId = PageManager.getLastPageId(userId);
	    	Credential credential = AuthUtils.getCredential(userId);
	    	Mirror mirror = MirrorUtils.getMirror(req);
	    	
	    	ArrayList<String> str = new ArrayList<String>();
			str.add("AAPL");
			str.add("AMTD");
			str.add("GOOG");
			
	    	Timeline timeline = mirror.timeline();
	    	TimelineItem timelineItem =getQuotes(str);
	    	
	    	
	    	if(pageId != null){
	    		timeline.patch(pageId, timelineItem).execute();
	    	}else{
	    		TimelineItem tiResp = timeline.insert(timelineItem).execute();
	        	PageManager.setLastPageId(tiResp.getId(), userId);
	    	}
	    	
	    	return timelineItem.getHtml();
	    	
	    }


}
