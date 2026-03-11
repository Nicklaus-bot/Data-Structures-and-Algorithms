import java.io.*;
import java.util.*;
public class STQARemoveEfficient{
    public static class STQA{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> hs = new Stack<>();

        void add(int val){  
            while(!st.isEmpty()){
                hs.push(st.pop());
            }
            st.push(val);
            while(!hs.isEmpty()){
                st.push(hs.pop());
            }
        }

        int peek(){
            if(st.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return st.peek();
            }
        }

        int remove(){
            if(st.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return st.pop();
            }
        }

        int size(){
            return st.size();
        }

        void display(){
            while(!st.isEmpty()){
                int val = st.pop();
                System.out.print(val + " ");
                hs.push(val);
            }

            while(!hs.isEmpty()){
                st.push(hs.pop());
            }
        }

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        STQA qu = new STQA();
        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            }
            else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size")){
                System.out.println(qu.size());
            }
            else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }
}