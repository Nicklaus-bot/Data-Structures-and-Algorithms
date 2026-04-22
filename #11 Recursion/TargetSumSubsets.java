import java.util.*;
public class TargetSumSubsets{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        target(arr , 0 , "" , 0 , tar);

    }

    public static void target(int [] arr , int idx , String set , int sos , int tar){
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }

        target(arr , idx + 1 , set , sos , tar);
        target(arr , idx + 1 , set + arr[idx] + " " , sos + arr[idx] , tar);
    }
}