package com.tda.glassware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tda.glassware.jsonobjects.High;
import com.tda.glassware.jsonobjects.Research;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class TDAIndexes {
    public static String getIndexes(){
        // This function will return a simple array of indices
        String urlParameters = "";
        try {
            URL url = new URL ("https://mobileapi.tdameritrade.wallst.com/Quote/ResearchOverview?user_id=mobileapi&user_password=mobileapi");
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
                    Research r = gson.fromJson(sb.toString() , Research.class);
                       render(r);
                    return "";
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String render(Research research) throws Exception{

        // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(TDAIndexes.class, "templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        //
        // You will do this for several times in typical applications.

        // 2.1. Prepare the template input:

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Market Summary");
        input.put("research", research);

        // 2.2. Get the template
        freemarker.template.Template template = cfg.getTemplate("MarketSummary.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
//        Writer fileWriter = new FileWriter(new File("output.html"));
//        try {
//            template.process(input, fileWriter);
//        } finally {
//            fileWriter.close();
//        }

        return "";
    }


}
