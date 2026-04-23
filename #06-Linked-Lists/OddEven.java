import java.io.*;
public class OddEven{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public void removefirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }
            else if(size == 1){
                head = null;
                tail = null;
                size = 0;
            }
            else{
                head = head.next;
                size--;
            }
        }

        public int getfirst(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else{
                return head.data;
            }
        }

        public void display(){
            for(Node temp = head ; temp!=null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void addlast(int val){
            Node temp = new Node();
            temp.next = null;
            temp.data = val;
            if(size == 0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public void oddeven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while(this.size != 0){
                int val = this.getfirst();
                this.removefirst();

                if(val % 2 == 0){
                    even.addlast(val);
                }
                else{
                    odd.addlast(val);
                }
            }
            if(odd.size>0 && even.size>0){
            odd.tail.next = even.head;
            this.size = odd.size + even.size;
            this.head = odd.head;
            this.tail = even.tail;
            }
            else if(odd.size>0){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else if(even.size>0){
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }
    }
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        String str = br.readLine();

        while(str.equals("quit") == false){
             if(str.startsWith("addlast")){  
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addlast(val);
            }
            else if (str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("oddeven")){
                list.oddeven();
            }
        str = br.readLine();
        }
    }
}