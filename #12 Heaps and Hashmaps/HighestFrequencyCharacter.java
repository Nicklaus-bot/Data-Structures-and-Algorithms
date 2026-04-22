import java.io.*;
import java.util.*;
public class HighestFrequencyCharacter{
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character , Integer> hm = new HashMap<>();

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);

            if(hm.containsKey(ch)){
                int cf = hm.get(ch);
                int nf = cf + 1;
                hm.put(ch , nf);
            }
            else{
                hm.put(ch , 1);
            }
        }

        int mf = hm.get(str.charAt(0));
        char mfc = str.charAt(0);

        for(Character key : hm.keySet()){
            if(hm.get(key) > mf){
                mf = hm.get(key);
                mfc = key;
            }
        }

        System.out.println(mfc);
    }
}