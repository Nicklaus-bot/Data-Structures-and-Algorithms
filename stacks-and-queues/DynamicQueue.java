import java.io.*;
import java.util.*;
public class DynamicQueue{
    public static class DQ{
        int [] arr;
        int size;
        int front;

        public DQ(int cap){
            arr = new int [cap];
            size = 0;
            front = 0;
        }

        public void add(int val){
            //code here
        }

        public int size(){
            //code here
        }

        public int remove(){
            //code here
        }

        public int peek(){
            //code here
        }

        public void display(){
            //code here
        }
        
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        DQ que = new DQ(n);
        String str = br.readLine();

        while(str.equals("quit")==false){
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
            else if(str.startsWith("size")){
                System.out.println(que.size());
            }
            else if(str.startsWith("peek")){
                int val = que.peek();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("dsplay")){
                que.display();
            }
            str = br.readLine();
        }
    }
}