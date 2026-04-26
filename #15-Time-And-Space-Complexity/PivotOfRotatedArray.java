import java.io.*;
public class PivotOfRotatedArray{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }
        
        int p = pivot(arr);
        System.out.println(p);

    }

    public static int pivot(int [] arr){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(arr[mid] < arr[hi]){
                hi = mid;
            }
            else if(arr[mid] > arr[hi]){
                lo = mid + 1;
            }
        }

        return arr[hi];
    }
}