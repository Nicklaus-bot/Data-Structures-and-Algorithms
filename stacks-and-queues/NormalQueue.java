import java.io.*;
public class NormalQueue{
    public static class NQ{
        int [] arr;
        int size;
        int front;

        public NQ(int cap){
            arr = new int [cap];
            size = 0;
            front = 0;
        }

        public void add(int val){
            if(size == arr.length){
                System.out.println("Queue Overflow");
            }
            else{
                int rear = (front + size)%arr.length;
                arr[rear] = val;
                size++;
            }
        }

        public int size(){
            return size;
        }

        public int remove(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                int val = arr[front];
                front = (front+1)%arr.length;
                size--;
                return val;
            }
        }

        public int peek(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                return arr[front];
            }
        }

        public void display(){
            for(int i=0 ; i<size ; i++){
                int idx = (front + i) % arr.length;
                System.out.print(arr[idx] + " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        NQ que = new NQ(n);
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
            else if(str.startsWith("display")){
                que.display();
            }
            str = br.readLine();
        }
    }
}