public class ReverseListData{
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
        public void display(){
            for(Node temp = head ; temp != null ; temp= temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
        private Node getnodeat(int idx){
            if(idx<0 || idx>=size){
                return null;
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx ; i++){
                    temp = temp.next;
                }
                return temp;
            }
        }
        public void reverselist(){
            int le = 0;
            int ri = size - 1;

            while(le<ri){
                Node left = getnodeat(le);
                Node right = getnodeat(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                le++;
                ri--;
            }         
        }
    }
    public static void main(String[]args)throws Exception{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // String str = br.readLine();

        LinkedList list = new LinkedList();

        list.addlast(10);
        list.addlast(20);
        list.addlast(30);
        list.addlast(40);
        list.addlast(50);

        System.out.println("Original List");
        list.display();

        list.reverselist();

        System.out.println("Reversed List");
        list.display();

        
    }
}