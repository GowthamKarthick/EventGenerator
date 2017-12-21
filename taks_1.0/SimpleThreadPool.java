import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue; 
class MyThread extends Thread {

    static int i;
    int n;
    JSONObject js;
    public MyThread(int n, JSONObject js){
        this.js = js;
        this.n = n;
    }
 
    public void run() {

        for (int j=0; j < n ; j++) {             
            System.out.println(Thread.currentThread().getName()+" (Start) message = "+i);
            i++;   
        }
    }
 
}


public class SimpleThreadPool {
    public static void main(String[] args) {
        GenerateJson g = new GenerateJson();
        JSONObject js = g.getJson();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));  
        int core = Runtime.getRuntime().availableProcessors();    
        int split = 5000 / core;
        for (int i = 0; i < core; i++) {
            new MyThread(split,js).start();
        } 
        System.out.println(dtf.format(now));  
        System.out.println("-----------");  
          
    }
 
}
