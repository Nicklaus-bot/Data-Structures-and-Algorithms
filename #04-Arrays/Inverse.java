import java.util.*;
public class Inverse {

    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int [] inv = new int [arr.length];
        for(int i=0 ; i<inv.length ; i++){
            int v = arr[i];
            inv[v] = i;
        }

        display(inv);

    }    
}
