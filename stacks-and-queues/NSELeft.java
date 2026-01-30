import java.io.*;
import java.util.*;
public class NSELeft{
    public static void display(int []arr){
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
        int [] nse = nseLeft(arr);
        display(nse);
    }

    public static int [] nseLeft(int [] arr){
        int [] nse = new int [arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        nse[0] = -1;

        for(int i=1 ; i<arr.length ; i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size() != 0){
                nse[i] = arr[st.peek()];
            }
            else{
                nse[i] = -1;
            }
            st.push(i);
        }
        return nse;
    }
}