import java.io.*;
public class SelectionSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        selectionSort(arr);
        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void selectionSort(int [] arr){
        for(int i=0 ; i<arr.length-1 ; i++){
            int min = i;
            for(int j=i+1 ; j<arr.length ; j++){
                if(isSmaller(arr , j , min)){
                    min = j;
                }
            }
            swap(arr , i , min);
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