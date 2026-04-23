import java.io.*;
public class AddLL{
    public static class Node{
        Node next; 
        int data;
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

        public void addlast(int val){
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

        public int size(){
            return size;
        }

        public void display(){
            for(Node temp = head ; temp!=null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void addfirst(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if(size == 0){
                tail = temp;
            }
            size ++;
        }

        private static int addLLHelper(Node one , int pv1 , Node two , int  pv2 , LinkedList res){
            if(one == null && two == null){
                return 0;
            }
            int data = 0;

            if(pv1 > pv2){
                int oc = addLLHelper(one.next , pv1 - 1 , two , pv2 , res); 
                data = one.data + oc;
            }
            else if(pv1 < pv2){
                int oc = addLLHelper(one , pv1 , two.next , pv2 - 1 , res);
                data = two.data + oc;
            }
            else{
                int oc = addLLHelper(one.next , pv1-1 , two.next , pv2-1 , res);
                data = one.data + two.data + oc;
            }

            int np = data%10;
            int nc = data/10;
            res.addfirst(np);
            return nc;
        }

        
        public static LinkedList addLL(LinkedList one , LinkedList two){
            LinkedList res = new LinkedList();
            int oc = addLLHelper(one.head , one.size , two.head , two.size , res);
            return res;
        }

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedList list = new LinkedList();

        while(str.equals("quit") == false){
            if(str.startsWith("addlast")){  
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addlast(val);
            }
            else if (str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("size")){
                System.out.println(list.size());
            }
            else if(str.startsWith("addfirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addfirst(val);
            }
            else if(str.startsWith("addLL")){
                
            }
        str = br.readLine();    
        }
    }
}