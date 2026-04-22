import java.io.*;
import java.util.*;
public class LargestAreaHistogram{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int [n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] sl = new int [arr.length];
        Stack<Integer> st1 = new Stack <>();
        sl[0] = -1;
        st1.push(0);
        for(int i=1 ; i<arr.length ; i++){
            while(st1.size()>0 && arr[st1.peek()]>=arr[i]){
                st1.pop();
            }
            if(st1.size() == 0){
                sl[i] = -1;
            }
            else{
                sl[i] = st1.peek();
            }
            st1.push(i);

        }

        int [] sr = new int [arr.length];
        Stack<Integer> st2 = new Stack<> ();
        sr[arr.length - 1] = arr.length;
        st2.push(arr.length-1);

        for(int i = arr.length - 2 ; i>=0 ; i--){
            while(st2.size()>0 && arr[st2.peek()] >= arr[i]){
                st2.pop();
            }
            if(st2.size() == 0){
                sr[i] = arr.length;
            }
            else{
                sr[i] = st2.peek();
            }
            st2.push(i);
        }

        int max = 0;
        for(int i=0 ; i<arr.length ; i++){
            int w = sr[i] - sl[i] - 1;
            int area = arr[i] * w;
            if(area >= max ){
                max = area;
            }
        }

        System.out.println(max);


    }
}