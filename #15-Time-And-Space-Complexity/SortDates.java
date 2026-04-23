import java.io.*;
public class SortDates{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String [] arr = new String [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = vals[i];
        } 

        sortDates(arr);
        for(String val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void countSort(String [] arr , int exp , int div , int size){
        int [] freq = new int [size];
        for(int i=0 ; i<arr.length ; i++){
            freq[Integer.parseInt(arr[i] , 10)/exp%div]++;
        }

        int [] prefixSum = new int [freq.length];
        prefixSum[0] = freq[0] - 1;
        for(int i=1 ; i<prefixSum.length ; i++){
            prefixSum[i] = freq[i] + prefixSum[i-1];
        } 

        String [] res = new String [arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            int idx = prefixSum[Integer.parseInt(arr[i] , 10)/exp%div];
            res[idx] = arr[i];
            prefixSum[Integer.parseInt(arr[i])/exp%div]--;
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = res[i];
        }
    } 

    public static void sortDates(String [] arr){
        countSort(arr , 1000000 , 100 , 32);
        countSort(arr , 10000 , 100 , 13);
        countSort(arr , 1 , 10000 , 25000);
    }
}