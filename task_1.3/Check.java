import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.time.format.DateTimeFormatter;  
//import java.time.LocalDateTime;    
 import org.json.JSONObject;  
 import org.json.XML; 
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
public class Check 
{
    public static void main(String[] args) 
    {    
        try 
        { 
            int i;
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");  
            Statement stmt=con.createStatement();    ;
            Xml2json g = new Xml2json();
            JSONObject js = g.getJson();
            int core = Integer.parseInt(args[0]);  
            ExecutorService executor = Executors.newFixedThreadPool(core);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new ThreadTimer(), 500, 500);  
            for ( i = 0; i < core; i++) 
            {                
                executor.execute(new Loader(js, stmt));
            }
            executor.shutdown();
            while (!executor.isTerminated()) 
            {
            }
            System.out.println("Finished all "+i+" threads");
        }
        catch(Exception e)
        {
         System.out.println(e);
        } 
    } 
}
// export CLASSPATH=java-json.jar:$CLASSPATH
// export CLASSPATH=mysql-connector.jar:$CLASSPATH