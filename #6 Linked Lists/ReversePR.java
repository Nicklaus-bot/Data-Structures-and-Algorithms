import java.io.*;
public class ReversePR{
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
            size++;
        }

        public void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        private void reversePRhelper(Node node){
            if(node == tail){
                return;
            }

            reversePRhelper(node.next);
                node.next.next = node;
                node.next = null;
        }

        public void reversePR(){
            reversePRhelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
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
            else if(str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("reversePR")){
                list.reversePR();
                list.display();
            }
            str = br.readLine();
        }
    }
}
