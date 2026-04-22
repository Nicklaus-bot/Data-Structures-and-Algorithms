import java.io.*;
import java.util.*;
public class GetCommonElements2{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int [] arr1 = new int [n1];
        String [] val1 = br.readLine().split(" ");
        for(int i=0 ; i<arr1.length ; i++){
            arr1[i] = Integer.parseInt(val1[i]);
        }

        int n2 = Integer.parseInt(br.readLine());
        int [] arr2 = new int [n2];
        String [] val2 = br.readLine().split(" ");
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
            if(hm.containsKey(val) && hm.get(val) > 0){
                System.out.println(val);
                int nf = hm.get(val) - 1;
                hm.put(val , nf);
            }
        }

    }
}
