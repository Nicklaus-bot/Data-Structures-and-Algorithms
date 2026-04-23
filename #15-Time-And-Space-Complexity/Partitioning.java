import java.io.*;
public class Partitioning{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int p = Integer.parseInt(br.readLine());

        int i=0;
        int j=0;

        while(i<arr.length){
            if(arr[i] > p){
                i++;
            }
            else{
                swap(arr , i , j);
                i++;
                j++;
            }
        }

        for(int val : arr){
            System.out.print(val + " ");
        }

        System.out.println();
    }

    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}