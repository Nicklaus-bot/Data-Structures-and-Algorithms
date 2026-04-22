import java.io.*;
public class AddLast{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        void addlast(int val){
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
    }
    public static void testList(LinkedList list){
        for(Node temp = list.head ; temp!=null ; temp=temp.next){
            System.out.println(temp.data);
        }
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
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addlast(val);
            }
           str =  br.readLine();
        }
        testList(list);
    }

}