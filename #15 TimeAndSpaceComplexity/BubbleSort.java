import java.io.*;
public class BubbleSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        bubbleSort(arr);
        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void bubbleSort(int [] arr){
        for(int i=1 ; i<arr.length - 1 ; i++){
            for(int j=0 ; j<arr.length-i ; j++){
                if(isSmaller(arr , j+1 , j)){
                    swap(arr , j+1 , j);
                }
            }
        }
    }


    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSmaller(int [] arr , int i , int j){
        if(arr[i] < arr[j]){
            return true;
        }
        else{
            return false;
        }
    }
}