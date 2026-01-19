import java.util.*;
public class ChangeElement{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int idx = scn.nextInt();
        int ndata = scn.nextInt();
        
        changeElement(arr , idx , ndata);

        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void changeElement(int [] arr , int idx , int ndata){
        arr[idx] = ndata;
    }
}