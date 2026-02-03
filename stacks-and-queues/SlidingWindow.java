import java.io.*;
import java.util.*;
public class SlidingWindow{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;
        for(int i=arr.length-2 ; i>=0 ; i--){
            while(st.size()>0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = arr.length;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(i);
        }

        int j=0;
        for(int i=0 ; i<arr.length-k+1 ; i++){
            if(j<i){
                j=i;
            }
            while(nge[j]<i+k){
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }
}