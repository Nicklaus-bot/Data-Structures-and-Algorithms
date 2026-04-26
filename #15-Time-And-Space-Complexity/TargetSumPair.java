import java.io.*;
import java.util.*;
public class TargetSumPair{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int sum = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int li = 0;
        int ri = arr.length - 1;

        while(li < ri){
            if(arr[li] + arr[ri] > sum){
                ri--;
            }
            else if(arr[li] + arr[ri] < sum){
                li++;
            }
            else{
                System.out.print("[" + arr[li] + "," + arr[ri] + "]" + " , " );
                li++;
                ri--;
            }
            
        }
        System.out.println();


    }
}