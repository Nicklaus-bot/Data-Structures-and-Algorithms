import java.io.*;
import java.util.*;
public class StackAdapter{
    public static class LLSA{
        LinkedList<Integer> list;
        
        public LLSA(){
            list = new LinkedList<>();
        }

        public int size(){
            return list.size();
        }
        void push(int val){
            list.addFirst(val);
        }
        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return list.removeFirst();
            }
        }
        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
            return list.getFirst();
            }
        }

    }
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LLSA st = new LLSA();

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
            str = br.readLine();
        }
    }
}