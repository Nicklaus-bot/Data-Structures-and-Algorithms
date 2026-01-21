import java.util.*;
public class FindElement{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<n ; i++){
            arr[i] = scn.nextInt();
        } 

        int data = scn.nextInt();

        int idx = -1;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == data){
                idx = i;
                break;
            }
            else{
                idx = -1;
            }
        }
        System.out.println(idx);
    }
}