import java.io.*;
public class DisplayReverse{
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

        private void displayreversehelper(Node node){
            if(node == null){
                return;
            }
            displayreversehelper(node.next);
            System.out.print(node.data + " ");
        }

        public void displayreverse(){
            displayreversehelper(head);
            System.out.println();
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
            else if(str.startsWith("displayreverse")){
                list.displayreverse();
            }
        str = br.readLine();    
        }
    }
}