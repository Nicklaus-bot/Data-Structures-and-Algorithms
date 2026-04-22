import java.io.*;
public class GetValue{
    public static class Node{
        Node next;
        int data;
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
            size ++;
        }
        public int size(){
            return size;
        }
        public void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.println(temp.data + " ");
            }
            System.out.println();
        }
        public void removefirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }
            else if(size == 1){
                head  =null;
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
        public int getlast(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else{
                return tail.data;
            }
        }
        public int getindex(int idx){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else if(idx<0 || idx >= size){
                System.out.println("Invalid Argument");
                return -1;
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx ; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }
    }
        public static void testlist(LinkedList list){
            for(Node temp = list.head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
            System.out.println(list.size);
            if(list.size>0){
                System.out.println(list.tail.data);
            }
        }
        public static void main(String[]args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            LinkedList list = new LinkedList();

            while(str.equals("quit")==false){
                if(str.startsWith("addlast")){
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addlast(val);
                }
                if(str.startsWith("size")){
                    System.out.println(list.size());
                }
                if(str.startsWith("display")){
                    list.display();
                }
                if(str.startsWith("removefirst")){
                    list.removefirst();
                }
                if(str.startsWith("getfirst")){
                    int val = list.getfirst();
                    if(val != -1){
                        System.out.println(val);
                    }
                }
                if(str.startsWith("getlast")){
                    int val = list.getlast();
                    if(val != -1){
                        System.out.println(val);
                    }
                }
                if(str.startsWith("getindex")){
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    int val = list.getindex(idx);
                    if(val != -1){
                        System.out.println(val);
                    }
                }
            str = br.readLine();
            }
            testlist(list);
        }
        
    }