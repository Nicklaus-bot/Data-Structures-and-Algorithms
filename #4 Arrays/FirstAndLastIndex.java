import java.util.*;
public class FirstAndLastIndex {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        } 
        int data = scn.nextInt();

        int lo = 0;
        int hi = arr.length - 1;

        int first = -1;
        while(lo<=hi){
            int mid = (lo + hi) / 2;

            if(data < arr[mid]){
                hi = mid - 1;
            }
            else if(data > arr[mid]){
                lo = mid + 1;
            }
            else{
                first = mid;
                hi = mid-1;
            }
        }

        lo = 0;
        hi = arr.length - 1;

        int last = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(data < arr[mid]){
                hi = mid - 1;
            }
            else if(data > arr[mid]){
                lo = mid + 1;
            }
            else{
                last = mid;
                lo = mid + 1;
            }
        }

        System.out.println("First Index is " + first);
        System.out.println("Last Index is " + last);

    }    
}
