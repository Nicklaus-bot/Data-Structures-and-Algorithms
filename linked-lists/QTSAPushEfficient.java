import java.io.*;
import java.util.*;
public class QTSAPushEfficient{
    public static class QTSA{
        Queue<Integer> qu = new ArrayDeque<>();
        Queue<Integer> hq = new ArrayDeque<>();

        void push(int val){
            qu.add(val);
        }

        int size(){
            return qu.size();
        }

        int pop(){
            if(qu.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                while(qu.size() > 1){
                    hq.add(qu.remove());
                }

                int val = qu.remove();

                while(!hq.isEmpty()){
                    qu.add(hq.remove());
                }
                return val;
            }
        }

        int top(){
            if(qu.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                while(qu.size() > 1){
                    hq.add(qu.remove());
                }
                int val = qu.remove();
                hq.add(val);
                while(!hq.isEmpty()){
                    qu.add(hq.remove());
                }
                return val;
            }
        }

    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QTSA st = new QTSA();

        String str = br.readLine();

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