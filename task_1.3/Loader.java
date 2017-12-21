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
    private JSONObject js;
    private  Statement stmt;
    Blob img= null;
    public Loader(JSONObject js,Statement stmt){
        this.js = js;
        this.stmt = stmt;
    }
 
    public void run() {
        try
    {    for (int j=0;  ; j++) {             
                js.put("source",new Integer(i));
                js.put("message",new Integer(i));
                js.put("alert",new Integer(i));
                js.put("location",new String("TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="));
                try{
                    //stmt.executeUpdate("insert into temp(id) values("+i+")");
                 //    System.out.println(Thread.currentThread().getName()+" (Start) events = "+js);
                 // System.out.println(Thread.currentThread().getName()+" (Start) events = "+js);
                 //       System.out.println(Thread.currentThread().getName()+" (Start) events = "+js);
                    
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