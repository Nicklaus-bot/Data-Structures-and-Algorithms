import java.io.*;
public class RemoveDuplicates{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public void addlast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;    
        }
        public void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

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

        public void removeduplicates(){
            LinkedList res = new LinkedList();
            while(this.size>0){
                int val = this.getfirst();
                this.removefirst();

                if(res.size == 0  || res.tail.data != val){
                    res.addlast(val);
                }
            }
            this.size = res.size;
            this.head = res.head;
            this.tail = res.tail;
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList list = new LinkedList();
        String [] values = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++){
            int d = Integer.parseInt(values[i]);
            list.addlast(d);
        }
        list.display();
        list.removeduplicates();
        list.display();
    }
}