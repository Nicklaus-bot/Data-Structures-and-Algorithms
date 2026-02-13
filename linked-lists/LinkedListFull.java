import java.io.*;
public class LinkedListFull{
    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public LinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

        void addLast(int val){
            
        }




    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){

            }

            str = br.readLine();
        }
    }
}