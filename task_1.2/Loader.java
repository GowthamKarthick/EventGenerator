import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
 import org.json.JSONObject;  
 import org.json.XML;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
class Loader extends Thread {

    private static int i;
    private int n;
    private JSONObject js;
    private  Statement stmt;
    public Loader(JSONObject js,Statement stmt){
        this.js = js;
        this.n = n;
        this.stmt = stmt;
    }
 
    public void run() {
        try
    {    for (int j=0;  ; j++) {             
                js.put("source",new String(i+" -1"));
                js.put("message",new String(i+" -1"));
                js.put("alert",new String(i+" -1"));
                js.put("location",new Integer(i));
                try{
                    //stmt.executeUpdate("insert into temp(id) values("+i+")");
                    //System.out.println(Thread.currentThread().getName()+" (Start) events = "+js);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
    
                Events e=Events.getInstance();
                e.add(js);                
                i++;   
            }
    }
    catch (Exception e) {
        
    }
    }
}
