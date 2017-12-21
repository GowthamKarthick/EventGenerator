
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue; 

public class GenerateJson {

   public JSONObject getJson() {
   JSONObject js = new JSONObject();
      try {
        File inputFile = new File("employees.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element " + doc.getDocumentElement().getNodeName());
        int len = 0;
        String str="";

        NodeList nodeList=doc.getElementsByTagName("*");
        Element element = (Element)nodeList.item(1);
        str = element.getNodeName();
        for (int i=2; i<nodeList.getLength(); i++) 
        {

          element = (Element)nodeList.item(i);
          if (str.equals(element.getNodeName())) {
            break; 
          }
          else
          {
           // System.out.println(element.getNodeName()+"is it type"+len);
            js.put(element.getNodeName(),"temp");
          }

        }
        // System.out.println("_______________________");
        // System.out.println(js);
        // System.out.println(len+" Is the number of attributes "+str);

      }catch (Exception e) {
             e.printStackTrace();
        }
        return js;
   }
}

//export CLASSPATH=json-simple-1.1.1.jar:$CLASSPATH
