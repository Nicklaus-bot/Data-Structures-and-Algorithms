import java.io.*;
import java.util.*;
public class NGERightAlternative{
    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] nge = NGERight(arr);
        display(nge);
    }

    public static int [] NGERight(int [] arr){
        int [] nge = new int [arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1 ; i<arr.length ; i++){
            while(st.size()>0 && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                nge[idx] = arr[i];
            }
            st.push(i);
        }

        while(st.size() > 0){
            int idx = st.pop();
            nge[idx] = -1;
        }
        return nge;
    }
}