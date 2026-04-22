public class IntersectionPointLL{
    public static class Node{
        Node next;
        int data;
    }
    public static class LinkedList{
        int size;
        Node head;
        Node tail;

         public void addLast(int val){
            Node temp = new Node();
            temp.next = null;
            temp.data = val;
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

        public static int intersection(LinkedList l1 , LinkedList l2){
            Node n1 = l1.head;
            Node n2 = l2.head;

            int delta = Math.abs(l1.size - l2.size);

            if(l1.size > l2.size){
                for(int i=0 ; i<delta ; i++){
                    n1 = n1.next;
                }
            }
            else{
                for(int i=0 ; i<delta ; i++){
                    n2 = n2.next;
                }
            }
            while(n1!=null && n2!= null){
                if(n1 == n2){
                    return n1.data;
                }
                else{
                n1 = n1.next;
                n2 = n2.next;
                }
            }
            return 0;
        }
    public static void main(String[]args)throws Exception{
        LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();
    
    l1.addLast(1);
    l1.addLast(2);
    l1.addLast(3);
    l1.addLast(4);
    l1.addLast(5);

    l2.addLast(9);
    l2.addLast(10);

    Node temp = l1.head;
    while (temp.data != 3) {
        temp = temp.next;
    }

    l2.tail.next = temp;
    l2.tail = l1.tail;
    l2.size += (l1.size - 2); 

    int inter = intersection(l1, l2);

    if (inter != 0) {
        System.out.println("Intersection at node with data: " + inter);
    } else {
        System.out.println("No intersection");
    }
    }
}