import java.io.*;
import java.util.*;
public class MinimumStack2{
    public static class MinStack{
        Stack<Integer> data;
        int min;

        public MinStack(){
            data = new Stack<>();
        }
        void push(int val){
           if(data.isEmpty()){
            data.push(val);
            min = val;
           } 
           else if(val>=min){
            data.push(val);
           }
           else{
            data.push(2*val - min);
            min = val;
           }
        }
        int size(){
            return data.size();
        }
        int pop(){
            if(data.isEmpty()){
                System.out.println("StackUnderflow");
                return -1;
            }
            else if(data.peek()>=min){
                return data.pop();
            }
            else{
                int ov = min;
                int val = data.pop();
                min = 2*min - val; 
                return ov;
            }
            }
        int top(){
            if(data.isEmpty()){
                System.out.println("StackUnderflow");
                return -1;
            }
            else if(data.peek()>=min){
                return data.peek();
            }
            else{
                return min;
            }  
        }
        int min(){
            if(data.isEmpty()){
                System.out.println("StackUnderflow");
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
        MinStack st = new MinStack();

        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            }
            else if(str.startsWith("pop")){
                int val = st.pop();
                if(val!=-1){
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