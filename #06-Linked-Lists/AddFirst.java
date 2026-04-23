import java.io.*;
public class AddFirst{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public void addfirst(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if(size == 0){
                tail = temp;
            }

            size++;
        }
    }
    public static void testlist(LinkedList list){
        for(Node temp = list.head ; temp!=null ; temp = temp.next){
            System.out.print(temp.data);
        }
        System.out.println();
        System.out.println(list.size);
        if(list.size > 0){
            System.out.println(list.tail.data);
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();

        while(str.equals("quit")==false){
            if(str.startsWith("addfirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addfirst(val);
            }
            str = br.readLine();
        }
        testlist(list);
    }
}
