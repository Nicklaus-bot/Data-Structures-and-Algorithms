import java.io.*;
public class RadixSort{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        radixSort(arr);
        for(int val : arr){
            System.out.println(val);
        }
    }

    public static void countSort(int [] arr , int exp){

        int [] fa = new int [10];
        for(int i=0 ; i<arr.length ; i++){
            fa[arr[i]/exp%10]++;
        }

        int [] ps = new int [fa.length];
        ps[0] = fa[0] - 1;
        for(int i=1 ; i<ps.length ; i++){
            ps[i] = fa[i] + ps[i - 1]; 
        }

        int [] res = new int [arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            int idx = ps[arr[i]/exp%10];
            res[idx] = arr[i];
            ps[arr[i]/exp%10]--;
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = res[i];
        }
    }

    public static void radixSort(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int val : arr){
            if(val > max){
                max = val;
            }
        }

        int exp = 1;
        while(exp <= max){
            countSort(arr , exp);
            exp *= 10;
        }
    }
}
