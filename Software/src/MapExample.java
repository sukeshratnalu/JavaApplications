import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String args[]){
        Map map = new HashMap();
        map.put("1","Sukesh");
        map.put("2","Santosh");
        map.put("3","Sukesh");
        map.put("4","Ramesh");
        System.out.println("Map Elements: " + map);
        System.out.println("Map Elements with 1: " + map.get("1"));
        System.out.println("values " + map.values());
    }
}
