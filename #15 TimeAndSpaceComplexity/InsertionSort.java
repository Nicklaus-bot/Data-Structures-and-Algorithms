import java.io.*;
public class InsertionSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        insertionSort(arr);
        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void insertionSort(int [] arr){
        for(int i=1 ; i<arr.length ; i++){
            for(int j=i-1 ; j>=0 ; j--){
                if(isGreater(arr , j , j+1)){
                    swap(arr , j , j+1);
                }
                else{
                    break;
                }
            }
        }
    }


    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isGreater(int [] arr , int i , int j){
        if(arr[i] > arr[j]){
            return true;
        }
        else{
            return false;
        }
    }
}