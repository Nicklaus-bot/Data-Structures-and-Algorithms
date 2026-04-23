import java.io.*;
import java.util.*;
public class SortNearlySorted{
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
        for(int i=0 ; i<=k ; i++){
            pq.add(arr[i]);
        }

        for(int i=k+1 ; i<arr.length ; i++){
            System.out.print(pq.remove() + "  ");
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()){
            System.out.print(pq.remove() + "  ");
        }

        System.out.println();
    }
}