import java.io.*;
public class Middle{
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
                head =tail = temp;
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

        public int middle(){
            Node f = head;
            Node s = head;

            while(f.next != null && f.next.next != null ){
                f = f.next.next;
                s = s.next;
            }
            return s.data;
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList list = new LinkedList();

        for(int i=0 ; i<n ; i++){
            list.addlast(Integer.parseInt(br.readLine()));
        }

        System.out.println(list.middle());

    }
}