import java.util.*;
public class HashMapsBasic{
    public static void main(String[]args) throws Exception{
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India" , 135);
        hm.put("China" , 200);
        hm.put("Pakistan" , 40);
        hm.put("USA" , 20);
        hm.put("UK" , 15);

        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Nigeria"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Nigeria"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String key : hm.keySet()){
            int val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}