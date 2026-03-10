import java.io.*;
import java.util.*;
public class STQAAddEfficient{
    public static class STQA{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> hs = new Stack<>();

        void add(int val){
            st.push(val);
        }

        int size(){
            return st.size();
        }

        int peek(){
            if(st.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                while(st.size() > 1){
                    hs.push(st.pop());
                }
                int val = st.peek();
                while(!hs.isEmpty()){
                    st.push(hs.pop());
                }
                return val;
            }
        }

        int remove(){
            if(st.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                while(st.size() > 1){
                    hs.push(st.pop());
                }
                int val = st.pop();
                while(!hs.isEmpty()){
                    st.push(hs.pop());
                }
                return val;
            }
        }

        void display(){
            while(!st.isEmpty()){
                hs.push(st.pop());
            }
            while(!hs.isEmpty()){
                int val = hs.pop();
                System.out.print(val + " ");
                st.push(val);
            }
            System.out.println();
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