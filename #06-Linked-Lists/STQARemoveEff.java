import java.io.*;
import java.util.*;
public class STQARemoveEff {
    public static class STQA{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public STQA(){
            mainS = new Stack<>();
            helperS = new Stack<>();
        }
        int size(){
            return mainS.size();
        }
        void add(int val){
            while(mainS.size()>0){
                helperS.push(mainS.pop());
            }
            mainS.push(val);
            while(helperS.size() > 0 ){
                mainS.push(helperS.pop());
            }
        }
        int remove(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
            return mainS.pop();
            }
        }
        int peek(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
            return mainS.peek();
            }
        }
    }    
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        STQA qu = new STQA();

        while(str.equals("quit")==false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            }
            else if(str.startsWith("size")){
                System.out.println(qu.size());
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
        str = br.readLine();    
        }
    }
}