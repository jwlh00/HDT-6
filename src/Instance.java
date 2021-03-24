import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Scanner;


public class Instance {

    public Map<String, String> getInstance(int type) {

        if(type == 1){
            return new HashMap<String, String>();

        }else if(type ==2){
            return new LinkedHashMap<String, String>();

        }else if(type ==3){
            return new TreeMap<String, String>();
        }
        else{
            return null;
        }
    }
}
