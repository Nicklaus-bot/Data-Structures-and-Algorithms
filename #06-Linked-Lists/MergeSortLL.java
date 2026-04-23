import java.io.*;
public class MergeSortLL{
    public static class Node{
        Node next;
        int data;
    }
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

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

        public static Node midnode(Node head , Node tail){
            Node f = head;
            Node s = head;

            while(f != tail && f.next != tail){
                s = s.next;
                f = f.next.next;
            }
            return s;
        }

        public static LinkedList mergesortedLL(LinkedList l1 , LinkedList l2){
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();

            while(one != null && two != null){
                if(one.data > two.data){
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

        public static LinkedList mergesort(Node head , Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addlast(head.data);
                return br;
            }

            Node mid = midnode(head , tail);
            LinkedList fsh = mergesort(head , mid);
            LinkedList ssh = mergesort(mid.next , tail);
            LinkedList cp = mergesortedLL(fsh , ssh);
            return cp;

        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] str = br.readLine().split(" ");

        LinkedList list = new LinkedList();

        for(int i=0 ; i<n ; i++){
            list.addlast(Integer.parseInt(str[i]));
        }

        LinkedList sort = LinkedList.mergesort(list.head , list.tail);
        sort.display(); 
        System.out.println(sort.size());
    }
}