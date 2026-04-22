import java.io.*;
public class AddAt{
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
        public void addat(int idx , int val){
            if(idx<0 || idx>size){
                System.out.println("Invalid Arguments");
            }
            else if(idx == 0){
                addfirst(val);
            }
            else if(idx == size){
                addlast(val);
            }
            else{
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size ++;
            }
        }

    }
    public static void testlist(LinkedList list){
        System.out.println(list.size());

    for(Node temp = list.head ; temp != null ; temp = temp.next){
        System.out.print(temp.data + " ");
    }
    System.out.println();
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedList list = new LinkedList();

        while(str.equals("quit")== false){
            if(str.startsWith("addat")){
                String [] parts = str.split(" ");
                int idx = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                list.addat(idx , val);
            }
            str = br.readLine();
        }
        testlist(list);
    }
}
