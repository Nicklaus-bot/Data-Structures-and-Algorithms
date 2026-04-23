import java.io.*;
public class AllIndexOccurrence{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int data = Integer.parseInt(br.readLine());
        int [] iarr = allIndices(arr , 0 , data , 0);

        if(iarr.length == 0){
            System.out.println("Zero Indices");
            return;
        }

        for(int val : iarr){
            System.out.print(val + "\t");
        }
    }

    public static int [] allIndices(int [] arr , int idx , int data , int f){
        if(idx == arr.length){
            return new int [f];
        }

        if(arr[idx] == data){
            int [] iarr = allIndices(arr , idx + 1 , data , f + 1);
            iarr[f] = idx;
            return iarr;
        }
        else{
            int [] iarr = allIndices(arr , idx + 1 , data , f);
            return iarr;
        }

    }
}