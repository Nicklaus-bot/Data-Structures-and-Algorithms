import java.util.*;
public class SpanOfArray{
    public static void main(String[]args) throws Exception{

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];

        for(int i = 0; i<n ; i++){
            arr[i] = scn.nextInt();
        }

        int max = arr[0];
        int min = arr[0];
        for(int j = 1 ; j< arr.length ; j++){
            if(arr[j]> arr[0]){
                max = arr[j];
            }
            if(arr[j]< arr[0]) {
                min = arr[j];
            }

        }

        int span = max - min;
        System.out.println(span);


    }
}