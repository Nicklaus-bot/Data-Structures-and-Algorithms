import java.io.*;
import java.util.*;
public class QueueAdapter{
    public static class LLQA{
        LinkedList<Integer> list;

        public LLQA(){
        list = new LinkedList<>();
        }
        void add(int val){
            list.addLast(val);
        }
        int size(){
            return list.size();
        }
        int remove(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
              return list.removeFirst();
            }

        }
        int peek(){
            if(size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return list.getFirst();
            }
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LLQA que = new LLQA();

        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                que.add(val);
            }
            else if(str.startsWith("remove")){
                int val = que.remove();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("peek")){
                int val = que.peek();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size")){
                System.out.println(que.size());
            }
            str = br.readLine();
        }
    }
}