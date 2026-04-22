public class ReverseListPointer{
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
        public int size(){
            return size;
        }
        public void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
        public void reverse(){
            Node prev = null;
            Node curr = head;

            while(curr!=null){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }
    }
    public static void main(String[]args)throws Exception{
        LinkedList list = new LinkedList();

        list.addlast(10);
        list.addlast(20);
        list.addlast(30);
        list.addlast(40);
        list.addlast(50);

        System.out.println("Original List");
        list.display();

        list.reverse();

        System.out.println("Reversed List");
        list.display();

    }
}