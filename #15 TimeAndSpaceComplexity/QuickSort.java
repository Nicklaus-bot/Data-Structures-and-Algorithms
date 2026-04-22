import java.io.*;
public class QuickSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        quickSort(arr , 0 , arr.length-1);
        

    }

    public static void quickSort(int [] arr , int lo , int hi){
        if(lo>=hi){
            return;
        }

        int pivot = arr[hi];
        int pi = partition(arr , 0 , arr.length - 1 , pivot);
        quickSort(arr , lo , pi -1);
        quickSort(arr , hi , pi + 1);

    }

    public static int  partition(int [] arr , int lo , int hi , int pivot){
        int i=lo;
        int j=lo;

        while(i <= hi){
            if(arr[i] > pivot){
                i++;
            }
            else{
                swap(arr , i , j);
                i++;
                j++;
            }
        }

        return j-1;
    }

    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}