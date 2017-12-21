import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue; 
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
public class SimpleThreadPool {
    public static void main(String[] args) {    
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sample","root","");              
            Statement stmt=con.createStatement();    
            MemoryAllocation.setMemory();
            GenerateJson g = new GenerateJson();
            JSONObject js = g.getJson();
            int core = Runtime.getRuntime().availableProcessors();          
            int split = 5000 / core;
            for (int i = 1; i < core; i++) {
                 new Loader(js, stmt, split).start();
            } 
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new ThreadTimer(), 500, 500);
        }
        catch(Exception e)
        {
         System.out.println(e);
        } 
    } 
}
// export CLASSPATH=json-simple-1.1.1.jar:$CLASSPATH
// export CLASSPATH=mysql-connector.jar:$CLASSPATH 
//"id": "message", "type": "String", "length": "254"