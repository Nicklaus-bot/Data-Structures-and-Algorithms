import java.io.*;
import java.util.*;
public class LinkedListToQueueAdapter{
    public static class LLQA{
        LinkedList<Integer> list = new LinkedList<>();

        void add(int val){
            list.addLast(val);
        }

        int size(){
            return list.size();
        }

        int peek(){
            if(list.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return list.getFirst();
            }
        }

        int remove(){
            if(list.isEmpty()){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return list.removeFirst();
            }
        }

        void display(){
            for(int i=0 ; i<list.size() ; i++){
                System.out.print(list.get(i) + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLQA qu = new LLQA();

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
                int val = qu.size();
                System.out.println(val);
            }
            else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }
}