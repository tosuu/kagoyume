/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
public class Api {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public static ArrayList<SearchDataBeans> getResult(String searchWord){
        ArrayList<SearchDataBeans> al = new ArrayList(); 
        String result = "";
        JsonNode head = null;
        final String yahooShoppingUrl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
        final String applyID = "dj0zaiZpPXBvRGlmcThadHJoUCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-";
        try{
            String urlString = URLEncoder.encode(searchWord, "utf-8");
            URL url = new URL(yahooShoppingUrl + "?appid=" + applyID + "&query=" + urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }
            
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            ObjectMapper mapper = new ObjectMapper();
            
            head = mapper.readTree(parser);
            
            search:
            for (int i = 0; i < 20; i++) {
                SearchDataBeans srb = new SearchDataBeans();
                String num = String.valueOf(i);
                srb.setName(head.get("ResultSet").get("0").get("Result").get(num).get("Name").textValue());
                srb.setPrice(head.get("ResultSet").get("0").get("Result").get(num).get("Price").get("_value").textValue());
                srb.setImage(head.get("ResultSet").get("0").get("Result").get(num).get("Image").get("Medium").textValue());
                srb.setCode(head.get("ResultSet").get("0").get("Result").get(num).get("Code").textValue());
                al.add(srb);
            }
            in.close();
            con.disconnect();
            }catch(Exception e){
                e.printStackTrace();
            }
        return al;
    }
    
    public static SearchDataBeans getDetail(String id){
        SearchDataBeans sdb = new SearchDataBeans();
        String result = "";
        JsonNode head = null;
        final String yahooShoppingUrl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
        final String applyID = "dj0zaiZpPXBvRGlmcThadHJoUCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-";
        try{
            String parsedID = URLEncoder.encode(id, "utf-8");
            URL url = new URL(yahooShoppingUrl + "?appid=" + applyID + "&itemcode=" + parsedID + "&responsegroup=large");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }
            
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            ObjectMapper mapper = new ObjectMapper();
            
            head = mapper.readTree(parser);
            
            sdb.setName(head.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
            sdb.setPrice(head.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue());
            sdb.setImage(head.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Medium").textValue());
            sdb.setCode(head.get("ResultSet").get("0").get("Result").get("0").get("Code").textValue());
            sdb.setDescription(head.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
            sdb.setRate(head.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").textValue());
            
            
            in.close();
            con.disconnect();
            }catch(Exception e){
                e.printStackTrace();
            }
        return sdb;
    }
    
    
   
    
//    public JsonNode connectApi(String searchWord){
//        final String yahooShoppingUrl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
//        final String applyID = "dj0zaiZpPXBvRGlmcThadHJoUCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-";
//        
//        JsonNode json = getResult(yahooShoppingUrl + "?appid=" + applyID + "&query=" + searchWord);
//        return json;
//    }
    
    //    public static ArrayList<SearchDataBeans> getPartOfJson(JsonNode node){
    //        SearchDataBeans sdb = new SearchDataBeans();
    //        ArrayList<SearchDataBeans> al = new ArrayList(); 
    //        for(int i=0;i<20;i++){
    //            sdb.setName(node.get("Resultset").get("0").get("Result").get(String.valueOf(i)).get("Name").textValue());
    //            sdb.setPrice(node.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Price").get("_value").textValue());
    //            sdb.setImage(node.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Medium").textValue());
    //            sdb.setCode(node.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Code").textValue());
    //            al.add(sdb);
    //        }
    //        return al;
    //    }
    
    public static int getAmount(JsonNode node){
        return node.get("Resultset").get("totalResultsReturned").intValue();
    }
}
