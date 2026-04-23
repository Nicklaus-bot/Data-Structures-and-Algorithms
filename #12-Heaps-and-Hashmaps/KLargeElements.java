import java.io.*;
import java.util.*;
public class KLargeElements{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<arr.length ; i++){
            if(i<k){
                pq.add(arr[i]);
            }
            else{
                if(arr[i] > pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }
}