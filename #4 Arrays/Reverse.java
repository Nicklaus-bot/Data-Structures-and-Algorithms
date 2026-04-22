import java.util.*;
public class Reverse{

    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int [] arr){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo<hi){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [] arr = new int [n];

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        reverse(arr);
        display(arr);
    }
}