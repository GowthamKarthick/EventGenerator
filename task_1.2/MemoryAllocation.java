import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue; 
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
class MemoryAllocation{
    static void setMemory(){
        long heapSize = Runtime.getRuntime().totalMemory();
        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        memorySize /= (1024*1024*1024);  
        try {
            Process proc;
            proc = Runtime.getRuntime().exec("java -d64 -Xms512m -Xmx"+memorySize/3+"g Check/n");
        }
        catch(Exception e) {
          System.out.println("something went wrong"); 
        }
    }
}
