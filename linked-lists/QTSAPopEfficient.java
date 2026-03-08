import java.io.*;
import java.util.*;
public class QTSAPopEfficient{
    public static class QTSA{
        Queue<Integer> qu = new ArrayDeque<>();
        Queue<Integer> hq = new ArrayDeque<>();

        void push(int val){
                while(!qu.isEmpty()){
                    int v = qu.remove();
                    hq.add(v);
                }
                qu.add(val);

                while(!hq.isEmpty()){
                    int v = hq.remove();
                    qu.add(v);
                }
            }

        int pop(){
            if(qu.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return qu.remove();
            }
        }

        int top(){
            if(qu.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return qu.peek();
            }
        }

        int size(){
            return qu.size();
        }

        void display(){
            for(int val : qu){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        QTSA st = new QTSA();

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
            else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}