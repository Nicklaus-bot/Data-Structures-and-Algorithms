import java.util.*;
public class SwappingInArray{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        } 

        int idx1 = scn.nextInt();
        int idx2 = scn.nextInt();

        swap(arr , idx1 , idx2);

        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    public static void swap(int [] arr , int idx1 , int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}