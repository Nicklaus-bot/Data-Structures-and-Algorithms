import java.io.*;
public class Palindrome{
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

        public int size(){
            return size;
        }

        public void display(){
            for(Node temp = head ; temp!=null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
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

        private boolean palindromeHelper(Node right){
            if(right == null){
                return true;
            }
            boolean rres = palindromeHelper(right.next);

            if(rres == false){  
                return false;
            }
            else if (pleft.data != right.data) {
                return false;
            }
            else{
                pleft = pleft.next;
                return true;
            }
        }

        Node pleft;
        public boolean palindrome(){
            pleft = head;
            return palindromeHelper(head);
        }

    }
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList list = new LinkedList();

        while(str.equals("quit")==false){
            if(str.startsWith("addlast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addlast(val);
            }
            else if (str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("size")){
                System.out.println(list.size());
            }
            else if(str.startsWith("addfirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addfirst(val);
            }
            else if(str.startsWith("palindrome")){
                System.out.println(list.palindrome());
            }
        str = br.readLine();
        }
    }
}