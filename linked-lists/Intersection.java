import java.io.*;
public class Intersection{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
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
            size ++;
        }

        int size(){
            return size;
        }

        void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        void removeFirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                Node temp = head;
                head = temp.next;                  
                size--;
            }
        }

        public int intersection(LinkedList l1 , LinkedList  l2){
            Node one = l1.head;
            Node two = l2.head;

            int mod = Math.abs(l1.size - l2.size);
            for(int i=0 ; i<mod ; i++){
                if(l1.size > l2.size){
                    one = one.next;
                }
                else if(l1.size < l2.size){
                    two = two.next;
                }
            }

            while(one != null && two != null){
                if(one == two){
                    return one.data;
                }
                else{
                    one = one.next;
                    two = two.next;
                }
            }
            return -1;
        }
    }

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        
        l2.addLast(60);
        l2.addLast(70);

        Node temp = l1.head;
        while(temp.data != 30){
            temp = temp.next;
        }

        l2.tail.next = temp;
        l2.tail = l1.tail;
        l2.size += 2;

        int data = l1.intersection(l1 , l2);
        System.out.println(data);
    }
}