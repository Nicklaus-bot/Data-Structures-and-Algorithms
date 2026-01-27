import java.io.*;
import java.util.*;
public class NGERight {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] nge = nextgreaterelementright(arr);

        display(nge);
    }
    
    public static void display(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int val : arr){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static int [] nextgreaterelementright(int [] arr){
        int [] nge = new int [arr.length];

        Stack<Integer> st = new Stack<>();

        nge[arr.length - 1] = -1;
        st.push(arr.length - 1);

        for(int i=arr.length-2 ; i>=0 ; i--){
            while(st.size() > 0  && arr[i] >= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                nge[i] = -1;
            }
            else{
                nge[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return nge;
    }
    
}
