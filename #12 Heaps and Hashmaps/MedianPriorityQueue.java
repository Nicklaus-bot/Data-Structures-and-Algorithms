import java.io.*;
import java.util.*;
public class MedianPriorityQueue{
    public static class MedianPriorityQu{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQu(){
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        void add(int val){
            if(!right.isEmpty() && right.peek() < val){
                right.add(val);
            }
            else{
                left.add(val);
            }

            if(left.size() - right.size() == 2){
                right.add(left.remove());
            }
            if(right.size() - left.size() == 2){
                left.add(right.remove());
            }
        }

        int peek(){
            if(this.size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                if(left.size() >= right.size()){
                    return left.peek();
                }
                else{
                    return right.peek();
                }
            }
        }

        int remove(){
            if(this.size() == 0){
                System.out.println("Queue Underflow");
                return -1;
            }
            else{
                if(left.size() >= right.size()){
                    return left.remove();
                }
                else{
                    return right.remove();
                }
            }

        }

        int size(){
            return (left.size() + right.size());
        }

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQu qu = new MedianPriorityQu();
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
            str = br.readLine();
        }
    }
}