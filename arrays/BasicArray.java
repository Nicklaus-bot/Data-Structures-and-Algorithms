import java.util.*;
public class BasicArray{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<n ; i++){
            arr[i] = scn.nextInt();
        }

        for(int val : arr){
            System.out.print(val + " ");
        }

    }
}