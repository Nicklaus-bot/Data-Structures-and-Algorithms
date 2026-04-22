import java.util.*;
public class CeilAndFloor {
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int lo = 0;
        int hi = arr.length - 1;

        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(data < arr[mid]){
                ceil = arr[mid];
                hi = mid - 1;                    
                }
            else if(data > arr[mid]){
                floor = arr[mid];
                lo = mid + 1;
            }
            else{
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}    

