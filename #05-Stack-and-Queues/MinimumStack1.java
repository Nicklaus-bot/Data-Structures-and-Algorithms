import java.io.*;
import java.util.*;
public class MinimumStack1{
    public static class MinStack{
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack(){
            allData = new Stack<>();
            minData = new Stack<>();
        }
        void push(int val){
            allData.push(val);
            if(minData.isEmpty() || val<=minData.peek() ){
                minData.push(val);
            }    
        }
        int size(){
            return allData.size();
        }
        int pop(){
            if(size() == 0){
                System.out.println("StackUnderflow");
                return -1;
            }
            else{
            int val = allData.peek();
            if(val == minData.peek()){
                minData.pop();
            }
            return val;
        }
        }
        int top(){
            if(size()==0){
                System.out.println("StackUnderflow");
                return -1;
            }
            else{
           return allData.peek();
            }
        }
        int min(){
            if(size() == 0){
                System.out.println("StackUnderflow");
                return -1;
            }
            else{
              return minData.peek();
            }
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        MinStack st = new MinStack();

        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split( " ")[1]);
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
                if(val!=-1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            else if(str.startsWith("min")){
                int val = st.min();
                System.out.println(val);
            }
            str = br.readLine();
        }
    }
}