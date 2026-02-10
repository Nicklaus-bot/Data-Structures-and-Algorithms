import java.io.*;
import java.util.*;
public class MinStack2{
    public static class MS{
        Stack<Integer> ms = new Stack<>();
        int min;

        void push(int val){
            if(ms.size()==0){
                ms.push(val);
                min = val;
            }
            else if(val>=min){
                ms.push(val);
            }
            else{
                ms.push(2*val - min);
                min = val;
            }
        }

        int pop(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else if(ms.peek() >= min){
                return ms.pop();
            }
            else{
                int ov = min;
                int val = ms.pop();
                min = 2*min - val;
                return ov;
            }
        }

        int top(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else if(ms.peek() >= min){
                return ms.peek();
            }
            else{
                return min;
            }
        }

        int size(){
            return ms.size();
        }

        int min(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return min;
            }
        }
        
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        MS st = new MS();

        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            }
            else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            }   
            else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            else if(str.startsWith("min")){
                int val = st.min();
                if(val != -1){
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}