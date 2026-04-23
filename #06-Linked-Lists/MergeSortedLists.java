import java.io.*;
public class MergeSortedLists{
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
            size ++;
        }
        int size(){
            return size;
        }

        void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1 , LinkedList l2){
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();

            while(one != null && two != null){
                if(one.data <= two.data){
                    res.addlast(one.data);
                    one = one.next;
                }
                else{
                    res.addlast(two.data);
                    two = two.next;
                }
            }

            while(one != null){
                res.addlast(one.data);
                one = one.next;
            }

            while(two != null){
                res.addlast(two.data);
                two = two.next;
            }

            return res;
        }
    }
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for(int i=0 ; i<n1 ; i++){
            int d = Integer.parseInt(values1[i]);
            l1.addlast(d);
        }

        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();
        String [] values2 = br.readLine().split(" ");
        for(int i=0 ; i<n2 ; i++){
            int d = Integer.parseInt(values2[i]);
            l2.addlast(d);
        }

        LinkedList merged = LinkedList.mergeTwoSortedLists(l1 , l2);
        merged.display();
        l1.display();
        l2.display();
    }
}
