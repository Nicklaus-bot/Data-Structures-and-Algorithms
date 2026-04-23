import java.io.*;
import java.util.*;
public class GetCommonElements1{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        String [] val1 = br.readLine().split(" ");
        int [] arr1 = new int [n1];
        for(int i=0 ; i<arr1.length ; i++){
            arr1[i] = Integer.parseInt(val1[i]);
        }

        int n2 = Integer.parseInt(br.readLine());
        String [] val2 = br.readLine().split(" ");
        int [] arr2 = new int [n2];
        for(int i=0 ; i<arr2.length ; i++){
            arr2[i] = Integer.parseInt(val2[i]);
        }

        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int val : arr1){
            if(hm.containsKey(val)){
                int cf = hm.get(val);
                int nf = cf + 1;
                hm.put(val , nf);
            }
            else{
                hm.put(val , 1);
            }
        }

        for(int val : arr2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
        
    }
}