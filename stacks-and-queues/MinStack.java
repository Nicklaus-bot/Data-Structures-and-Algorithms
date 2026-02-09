import java.io.*;
import java.util.*;
public class MinStack{
    public static class MS{
        Stack<Integer>ms;
        Stack<Integer>hs;

        public MS(){
            ms = new Stack<>();
            hs = new Stack<>();
        }

        void push(int val){
            ms.push(val);

            if(hs.size()==0 || val <= hs.peek()){
                hs.push(val);
            }
        }

        int size(){
            return ms.size();
        }

        int pop(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                if(ms.peek() == hs.peek()){
                    hs.pop();
                }
                return ms.pop();
            }
        }

        int top(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return ms.peek();
            }
        }

        int min(){
            if(ms.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return hs.peek();
            }
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MS st = new MS();

        String str = br.readLine();

        while(str.equals("quit")==false){
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