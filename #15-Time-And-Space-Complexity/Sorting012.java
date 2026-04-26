import java.io.*;
public class Sorting012{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        sort(arr);
    }

    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int [] arr){
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while(i<=k){
            if(arr[i] == 0){
                swap(arr , i , j);
                i++;
                j++;
            }
            else if(arr[i] == 1){
                i++;
            }
            else if(arr[i] == 2){
                swap(arr , i , k);
                k--;
            }
        }

        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}