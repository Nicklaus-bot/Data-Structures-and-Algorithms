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

        void removeFirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                Node temp = head;
                head = temp.next;                  
                size--;
            }
        }

        int getFirst(){
            if(size == 0){
                System.out.println("List is Empmpty");
                return -1;
            }
            else{
                return head.data;
            }
        }

        int getLast(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else{
                return tail.data;
            }
        }

        int getAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
                return -1;
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx ; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        void addFirst(int val){
            Node temp = new Node();
            temp.data = val;
            
            if(size == 0){
                head = tail = temp;
                temp.next = null;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size ++;
        }

        void addAt(int val , int idx){
            if(idx<0 || idx>size){
                System.out.println("Invalid Argument");
            }
            else if(idx == 0){
                addFirst(val);
            }
            else if(idx == size){
                addLast(val);
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                Node n = new Node();
                n.data = val;
                n.next = temp.next;
                temp.next = n;
                size ++;
            }
        }

        void removeLast(){
            if(size == 0){
                System.out.println("Invalid Argument");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                Node temp = head;
                for(int i=0 ; i<size-2 ; i++){
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }

        void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
            }
            else if(idx == 0){
                removeFirst();
            }
            else if(idx == size-1){
                removeLast();
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        //Data Iterative
        Node getNode(int idx){
            Node temp = head;
            for(int i=0 ; i<idx ; i++){
                temp = temp.next;
            }
            return temp;
        }

        void reverseDI(){
            int li = 0;
            int ri = size - 1;

            while(li<ri){
                Node left = getNode(li);
                Node right = getNode(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        //Pointer Iterative
        void reversePI(){
            Node curr = head;
            Node prev = null;

            while(curr != null){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        int kthEnd(int k){
            if(k<0 || k>=size){
                System.out.println("Invalid Argument");
                return -1;
            }
            else{
                Node slow = head;
                Node fast = head;
                for(int i=0 ; i<k ; i++){
                    fast = fast.next;
                }

                while(fast.next != null){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }

        public int mid(){
            Node s = head;
            Node f = head;
            while(f.next != null && f.next.next != null){
                s = s.next;
                f = f.next.next;
            }
            return s.data;
        }

        public LinkedList mergeSortedLL(LinkedList l1 , LinkedList l2){
            LinkedList sorted = new LinkedList();
            Node one = l1.head;
            Node two = l2.head;

            while(one.next != null && two.next != null){
                if(one.data <= two.data){
                    sorted.addLast(one.data);
                    one = one.next;
                }
                else{
                    sorted.addLast(two.data);
                    two = two.next;
                }
            }

            while(one.next != null){
                sorted.addLast(one.data);
                one = one.next;
            }

            while(two.next != null){
                sorted.addLast(two.data);
                two = two.next;
            }
            return sorted;
        }

        public Node midNode(Node head , Node tail){
            Node fast = head;
            Node slow = head;

            while(fast != tail && fast.next != tail){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public LinkedList sort(Node head , Node tail){
            if(head == tail){
                LinkedList bres = new LinkedList();
                bres.addLast(head.data);
                return bres;
            }
            Node mid = midNode(head , tail);

            LinkedList fsh = sort(head , mid);
            LinkedList ssh = sort(mid.next , tail);
            LinkedList res = mergeSortedLL(fsh , ssh);

            return res;
        }

        public void removeDuplicates(){
            LinkedList res = new LinkedList();
            while(this.size > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(this.size == 0 || res.tail.data != val){
                    res.addLast(val);
                }
                this.head = res.head;
                this.tail = res.tail;
                this.size = res.size;
            }
        }

        public void oddEven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(val%2 == 0){
                    even.addLast(val);
                }
                else{
                    odd.addLast(val);
                }
            }

            if(odd.size!=0 && even.size!=0){
                this.head = odd.head;
                odd.tail.next = even.head;
                this.tail = even.tail;
                this.size = even.size + odd.size;
            }
            else if(odd.size != 0){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }   
            else{
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        public void kReverse(int k){
            if(k<=0){
                System.out.println("Invalid Argument");
                return;
            }
            else{
                LinkedList prev = null;
                while(this.size > 0){
                    LinkedList curr = new LinkedList();

                    if(this.size>=k){
                        for(int i=0 ; i<k ; i++){
                            int val = this.getFirst();
                            this.removeFirst();
                            curr.addFirst(val);
                        }
                    }
                    else{
                        int os = this.size;
                        for(int i=0 ; i<os ; i++){
                            int val = this.getFirst();
                            this.removeFirst();
                            curr.addLast(val);
                        }
                    }

                    if(prev == null){
                        prev = curr;
                    }
                    else{
                        prev.tail.next = curr.head;
                        prev.tail = curr.tail;
                        prev.size += curr.size;
                    }
                }
                this.head = prev.head;
                this.tail = prev.tail;
                this.size = prev.size;
            }
        }

        private void displayReverseHelper(Node node){
            if(node == null){
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + "\t");
        }

        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        private void reverseLLPRHelper(Node node){
            if(node == tail){
                return;
            }
            reverseLLPRHelper(node.next);
            node.next.next = node;
            node.next = null;
        }

        public void reverseLLPR(){
            reverseLLPRHelper(head);
            Node temp = head;
            head = tail;
            tail = temp;
        }

        Node left = head;
        public void reverseLLDRHelper(Node node , int floor){
            if(node == null){
                return;
            }
            reverseLLDRHelper(node.next , floor + 1);

            if(floor>=size/2){
                int temp = left.data;
                left.data = node.data;
                node.data = temp;
                left = left.next;
            }
        }

        public void reverseLLDR(){
            reverseLLDRHelper(head , 0);
            Node temp = head;
            head = tail;
            tail = temp;

            display();
        }

        Node pleft;
        private boolean palindromeHelper(Node node){
            if(node == null){
                return true;
            }

            boolean val = palindromeHelper(node.next);

            if(val == true && pleft.data == node.data){
                pleft = pleft.next;
                return true;
            }
            else{
                return false;
            }
        }

        public boolean palindrome(){
            pleft = head;
            boolean val = palindromeHelper(head);
            return val;
        }

        Node fleft;
        private void foldLLHelper(Node node , int floor){
            if(node == null){
                return;
            }

            foldLLHelper(node.next , floor + 1);

            if(floor > size/2){
                Node temp = fleft.next;
                fleft.next = node;
                node.next = temp;
                fleft = temp;
            }
            else if(floor == size/2){
                fleft.next = null;
                tail = fleft;
            }
        }

        public void foldLL(){
            fleft = head;
            foldLLHelper(head , 0);
            display();
        }


    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        LinkedList list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.addLast(40);
        list2.addLast(50);

        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            else if(str.startsWith("size")){
                System.out.println(list.size());
            }
            else if(str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("removeFirst")){
                list.removeFirst();
            }
            else if(str.startsWith("getFirst")){
                int val = list.getFirst();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("getLast")){
                int val = list.getLast();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("getAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("addFirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            }
            else if(str.startsWith("addAt")){
                String [] v = str.split(" ");
                int val = Integer.parseInt(v[1]);
                int idx = Integer.parseInt(v[2]);
                list.addAt(val , idx);
            }
            else if(str.startsWith("removeLast")){
                list.removeLast();
            }
            else if(str.startsWith("removeAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }
            else if(str.startsWith("reverseDI")){
                list.reverseDI();
                list.display();
            }
            else if(str.startsWith("reversePI")){
                list.reversePI();
                list.display();
            }
            else if(str.startsWith("kthEnd")){
                int k = Integer.parseInt(str.split(" ")[1]);
                int val = list.kthEnd(k);
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("mid")){
                int val = list.mid();
                System.out.println(val);
            }

            else if(str.startsWith("mergeSortedLL")){
                LinkedList sorted = list.mergeSortedLL(list , list2);
                sorted.display();
            }

            else if(str.startsWith("sort")){
                LinkedList sorted = list.sort(list.head , list.tail);
                sorted.display();
            }
            else if(str.startsWith("removeDuplicates")){
                list.removeDuplicates();
                list.display();
            }
            else if(str.startsWith("oddEven")){
                list.oddEven();
                list.display();
            }
            else if(str.startsWith("kReverse")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.kReverse(val);
                list.display();
            }
            else if(str.startsWith("displayReverse")){
                list.displayReverse();
            }
            else if(str.startsWith("reverseLLPR")){
                list.reverseLLPR();
                list.display();
            }
            else if(str.startsWith("reverseLLDR")){
                list.reverseLLDR();
            }
            else if(str.startsWith("palindrome")){
                boolean val = list.palindrome();
                System.out.println(val);
            }
            else if(str.startsWith("foldLL")){
                list.foldLL();
            }

            str = br.readLine();
        }
    }
}