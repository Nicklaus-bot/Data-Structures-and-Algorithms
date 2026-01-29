import java.io.*;
import java.util.*;
public class NSERight{
    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int [] nse = nseRight(arr);
        display(nse);
    }

    public static int [] nseRight(int [] arr){
        int [] nse = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nse[arr.length - 1] = -1;
        for(int i=arr.length - 2 ; i>=0 ; i--){
            while(st.size() > 0  &&  arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                nse[i] = -1;
            }
            else{
                nse[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return nse;
    }
}
