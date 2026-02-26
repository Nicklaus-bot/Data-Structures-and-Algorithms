import java.io.*;
import java.util.*;
public class LinkedListToStackAdapter{
    public static class LLSA{
        LinkedList<Integer> list = new LinkedList<>();

        void push(int val){
            list.addFirst(val);
        }

        int size(){
            return list.size();
        }

        int pop(){
            if(list.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return list.removeFirst();
            }
        }

        int top(){
            if(list.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return list.getFirst();
            }
        }

        void display(){
            for(int i=0 ; i<list.size() ; i++){
                System.out.print(list.get(i) + "\t");
            }
            System.out.println();
        }

    }
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LLSA st = new LLSA();

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
                int val = st.size();
                System.out.println(val);
            }
            else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}