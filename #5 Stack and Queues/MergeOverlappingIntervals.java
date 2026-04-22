import java.io.*;
import java.util.*;
public class MergeOverlappingIntervals{
    public static void main(String[]args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] [] arr = new int [n] [2];

        for(int j=0 ; j<n ; j++){
            String line = br.readLine();
            arr [j] [0] = Integer.parseInt(line.split(" ") [0]);
            arr [j] [1] = Integer.parseInt(line.split(" ") [0]);
        }
        mergeOverlappingIntervals(arr);    
    }

    public static void mergeOverlappingIntervals(int [] [] arr){

        





    }
}