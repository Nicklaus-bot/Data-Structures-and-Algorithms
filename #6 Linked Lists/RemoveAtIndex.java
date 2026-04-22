import java.io.*;
public class RemoveAtIndex{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public int size(){
            return size;
        }
         public void removelast(){
            if(size == 0){
                System.out.println("List is Empty");
            }
            else if(size == 1){
                head = null;
                tail = null;
                size = 0;
            }
            else{
            Node temp = head;
            for(int i=0 ; i<size-2 ; i++){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            size --;
            }
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
        public void removeat(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
            }
            else if(idx == 0){
                removefirst();
            }
            else if(idx == size - 1){
                removelast();
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
    }
    public static void testlist(LinkedList list){
        System.out.println(list.size());

    for(Node temp = list.head ; temp!=null ; temp = temp.next){
        System.out.print(temp.data + " ");
    }
    System.out.println();

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList list = new LinkedList();

        while(str.equals("quit") == false){
            if(str.startsWith("size")){
                System.out.println(list.size());
            }
            else if(str.startsWith("removeat")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeat(idx);
            }
            str = br.readLine();
            }
            testlist(list);
        }
    }