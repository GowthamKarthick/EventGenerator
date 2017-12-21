import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
 import org.json.JSONObject;  
 import org.json.XML; 
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

class Events
{
    static Events myObj;
    private Events(){}
    public static Events getInstance()
    {
        if(myObj == null)
        {
            myObj = new Events();
        }
        return myObj;
    }
    static int index;
    HashMap<Integer, JSONObject> hm = new HashMap<Integer, JSONObject>();
     void add(JSONObject js)
    {
        hm.put(index++,js);
    }
    static void print()
    {
        System.out.println("Total "+ index);
    }
}