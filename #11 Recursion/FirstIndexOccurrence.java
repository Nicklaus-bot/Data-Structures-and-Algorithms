import java.util.*;
public class FirstIndexOccurrence{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int idx = firstIndex(arr , 0 , data);
        System.out.println(idx);
    }

    public static int firstIndex(int [] arr , int idx , int data){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == data){
            return idx;
        }
        else{
            int idxr = firstIndex(arr , idx + 1 , data);
            return idxr;
        }
    }
}