import java.util.*;
public class Rotate {
    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int [] arr , int lo , int hi){
        while(lo<hi){
            int temp  = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

    public static void rotate(int [] arr , int k){
        k = k%arr.length;
        if(k<0){
            k=k+arr.length;
        }
        
        reverse(arr , 0 , arr.length - k - 1);
        reverse(arr , arr.length-k , arr.length - 1);
        reverse(arr , 0 , arr.length - 1);
    }



    public static void main(String[]args)throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [] arr = new int [n];

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        rotate(arr , k);
        display(arr);
    }    
}
