import java.io.*;
import java.util.*;
public class LargestAreaHistogram {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] nsel = new int [arr.length];
        Stack<Integer> st1 = new Stack<>();
        st1.push(0);
        nsel[0] = -1;
        for(int i=1 ; i<arr.length ; i++){
            while(st1.size() > 0  && arr[st1.peek()] >= arr[i]){
                st1.pop();
            }
            if(st1.size() > 0){
               nsel[i] = st1.peek();
            }
            else{
                nsel[i] = -1;
                }
            st1.push(i);
        }

        int [] nser = new int [arr.length];
        Stack<Integer> st2 = new Stack<>();
        st2.push(arr.length - 1);
        nser[arr.length -1] = arr.length;
        for(int i=arr.length-2 ; i>=0 ; i--){
            while(st2.size()>0 && arr[st2.peek()] >= arr[i]){
                st2.pop();
            }
            if(st2.size()>0){
                nser[i] = st2.peek();
            }
            else{
                nser[i] = arr.length; 
               }
            st2.push(i);
        }

        int area = 0;
        for(int i=0 ; i<arr.length ; i++){
            int a = nsel[i];
            int b = nser[i];
            int m = arr[i]*(b - a - 1);
            if(m >= area){
                area = m;
            }
        }

        System.out.println(area);
    }
}
