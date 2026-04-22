import java.io.*;
public class CountSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val : arr){
            if(min > val){
                min = val;
            }
            if(max < val){
                max = val;
            }
        }

        countSort(arr , min , max);   
        for(int val : arr){
            System.out.println(val);    
        } 


    }

    public static void countSort(int [] arr , int min , int max){
        int [] freq = new int [max - min + 1];  
        for(int val : arr){
            freq[val - min]++;
        }

        int [] psum = new int [freq.length];
        psum[0] = freq[0]; 
        psum[0]--;
        for(int i=1 ; i<psum.length ; i++){
            psum[i] = freq[i] + psum[i-1];
        }

        int [] sort = new int [arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            sort[psum[arr[i] - min]] = arr[i];
            psum[arr[i] - min]--;
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = sort[i];
        }
    }
}