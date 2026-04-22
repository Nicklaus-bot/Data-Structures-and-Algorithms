import java.io.*;
import java.util.*;
public class LongestConsecutiveSequence{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length  ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        HashMap<Integer , Boolean> hm = new HashMap<>();
        for(int val : arr){
            hm.put(val , true);
        }

        for(int val : arr){
            if(hm.containsKey(val - 1)){
                hm.put(val , false);
            }
        }

        int max = 0;
        int maxstart = 0;
        for(int val : arr){
            if(hm.get(val) == true){
                int t = 1;
                int curr = val;
                while(hm.containsKey(t + curr)){
                    t++;
                }

                if(t > max){
                    max = t;
                    maxstart = curr;
                }
            }
        }

        for(int i=0 ; i<max ; i++){
            System.out.print(maxstart + i + "\t");
        }
        System.out.println();

    }
}