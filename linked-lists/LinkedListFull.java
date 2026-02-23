import java.io.*;
public class LinkedListFull{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public LinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

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

        int getFirst(){
            if(size == 0){
                System.out.println("List is Empmpty");
                return -1;
            }
            else{
                return head.data;
            }
        }

        int getLast(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else{
                return tail.data;
            }
        }

        int getAt(int idx){
            if(idx<0 || idx>=size){
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

        void addFirst(int val){
            Node temp = new Node();
            temp.data = val;
            
            if(size == 0){
                head = tail = temp;
                temp.next = null;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size ++;
        }

        void addAt(int val , int idx){
            if(idx<0 || idx>size){
                System.out.println("Invalid Argument");
            }
            else if(idx == 0){
                addFirst(val);
            }
            else if(idx == size){
                addLast(val);
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                Node n = new Node();
                n.data = val;
                n.next = temp.next;
                temp.next = n;
                size ++;
            }
        }

        void removeLast(){
            if(size == 0){
                System.out.println("Invalid Argument");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                Node temp = head;
                for(int i=0 ; i<size-2 ; i++){
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }

        void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
            }
            else if(idx == 0){
                removeFirst();
            }
            else if(idx == size-1){
                removeLast();
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
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            else if(str.startsWith("size")){
                System.out.println(list.size());
            }
            else if(str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("removeFirst")){
                list.removeFirst();
            }
            else if(str.startsWith("getFirst")){
                int val = list.getFirst();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("getLast")){
                int val = list.getLast();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("getAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("addFirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            }
            else if(str.startsWith("addAt")){
                String [] v = str.split(" ");
                int val = Integer.parseInt(v[1]);
                int idx = Integer.parseInt(v[2]);
                list.addAt(val , idx);
            }
            else if(str.startsWith("removeLast")){
                list.removeLast();
            }
            else if(str.startsWith("removeAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }


            str = br.readLine();
        }
    }
}