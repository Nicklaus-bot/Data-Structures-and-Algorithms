import java.io.*;
public class KReverse{
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

        public void display(){
            for(Node temp = head ; temp!=null ; temp = temp.next){
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

        public void addfirst(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if(size == 0){
                tail = temp;
            }
            size ++;
        }

        public void kreverse(int k){
            LinkedList prev = null;

            while(this.size > 0){
                LinkedList curr = new LinkedList();
                if(this.size >= k){
                    for(int i=0 ; i<k ; i++){
                    int val = this.getfirst();
                    this.removefirst();
                    curr.addfirst(val);
                    }
                }
                else{
                    int os = this.size;
                    for(int i=0 ; i<os ; i++){
                        int val = this.getfirst();
                        this.removefirst();
                        curr.addlast(val);
                    }
                }
                if(prev == null){
                    prev = curr;
                }
                else{
                    prev.tail.next = curr.head;
                    prev.size += curr.size;
                    prev.tail = curr.tail;
                }
            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
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
             else if(str.startsWith("removefirst")){
                list.removefirst();
            }
            else if(str.startsWith("getfirst")){
                int val = list.getfirst();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("addfirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addfirst(val);
            }
            else if (str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("kreverse")){
                int k = Integer.parseInt(str.split(" ")[1]);
                list.kreverse(k);
            }
            str = br.readLine();
        }
    }
}