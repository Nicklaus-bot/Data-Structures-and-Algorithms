import java.io.*;
public class DisplaySize{
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
        public void display(){
            for(Node temp = head ; temp!=null ; temp = temp.next){
                System.out.print(temp.data + (" "));
            }
            System.out.println();
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
    }
    public static void testlist(LinkedList list){
        for(Node temp = list.head ; temp!=null ; temp = temp.next){
            System.out.print(temp.data +  " ");
        }
        System.out.println();
        System.out.println(list.size);
        if(list.size>0){
            System.out.println(list.tail.data);
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();

        while(str.equals("quit")==false){
            if(str.startsWith("addlast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            else if(str.startsWith("size")){
                System.out.println(list.size);
            }
            else if(str.startsWith("display")){
                list.display();
            }
            str = br.readLine();
        }
        testlist(list);
    }
}