import java.io.*;
public class QuickSelect{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int s = quickSelect(arr , 0 , arr.length - 1 , k - 1);
        System.out.println(s);
    }

    public static int quickSelect(int [] arr , int lo , int hi , int k){
        int pivot = arr[hi];
        int pi = partition(arr , lo , hi , pivot);
        if(pi > k){
            return quickSelect(arr , lo , pi - 1 , k);
        }
        else if(pi<k){
            return quickSelect(arr , pi + 1 , hi , k);
        }
        else{
            return arr[pi];
        }
    }

    public static int partition(int [] arr , int lo , int hi , int pivot){
        int i=0;
        int j=0;
        while(i<arr.length){
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