import java.io.*;
public class KthElementEnd{
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

        public int size(){
            return size;
        }

        public int elementfromend(int k){
            Node s = head;
            Node f = head;

            for(int i=0 ; i<k ; i++){
                f = f.next;
            }
            while(f.next != null){
                s = s.next;
                f = f.next;
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

        int k = Integer.parseInt(br.readLine());

        System.out.print(list.elementfromend(k));

    }
}