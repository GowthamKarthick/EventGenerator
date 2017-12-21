 import java.io.*;
 import org.json.JSONObject;  
 import org.json.XML;
  public class Xml2json {
    static String line="",str="";
   public JSONObject getJson() {
    JSONObject jsondata=null;
        try{
        String link = "xml/events.xml";
        BufferedReader br = new BufferedReader(new FileReader(link));
        while ((line = br.readLine()) != null) 
        {   
            str+=line;  
        }
         jsondata = XML.toJSONObject(str);
         
    }
    catch (Exception e) {
        
    }
              return jsondata;
    }
}

// Reference : https://www.thejavaprogrammer.com/convert-json-to-xml-or-xml-to-json-in-java/

