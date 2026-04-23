import java.io.*;
public class FullLL{
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        int size;
        Node head;
        Node tail;

        public LinkedList(){
            head = null;
            tail = null;
            size = 0;
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
            size++;
        }

        void display(){
            for(Node temp = head ; temp != null ; temp = temp.next){
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        int size(){
            return size;
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
                size -- ;
            }
        }

        int getFirst(){
            if(size == 0){
                System.out.println("List is Empty");
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
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }
            else if(idx < 0 || idx>=size){
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
            temp.next = head;
            head = temp;
            if(size == 0){
                tail = temp;
            }
            size++;
        }

        void addAt(int val , int idx){
            if(idx == 0){
                addFirst(val);
            }
            else if(idx == size){
                addLast(val);
            }
            else if(idx<0 || idx>size){
                System.out.println("Invalid Argument");
            }
            else{
                Node temp = head;
                for(int i=0 ; i<idx-1 ; i++){
                    temp = temp.next;
                }
                Node node = new Node();
                node.data = val;
                node.next = temp.next;
                temp.next = node;
                size ++;
            }
        }

        void removeLast(){
            if(size == 0){
                System.out.println("List is Empty");
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
                temp.next = null;
                tail = temp;
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

            while(li < ri){
                Node left = getNode(li);
                Node right = getNode(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

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
            head = prev;
            tail = temp;
        }

        int KthEnd(int k){
            if(k<0 || k>=size){
                System.out.println("Invalid Argument");
                return -1;
            }
            else{
            Node f = head;
            Node s = head;
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

        int middle(){
            Node f = head;
            Node s = head;
            while(f.next != null && f.next.next != null){
                f = f.next.next;
                s = s.next;
            }
            return s.data;
        }

        LinkedList sortLL(LinkedList l1 , LinkedList l2){
            LinkedList sorted = new LinkedList();
            Node one = l1.head;
            Node two = l2.head;

            while(one != null && two != null){
                if(one.data <= two.data){
                    sorted.addLast(one.data);
                    one = one.next;
                }
                else{
                    sorted.addLast(two.data);
                    two = two.next;
                }
            }

            while(one != null){
                sorted.addLast(one.data);
                one = one.next;
            }

            while(two != null){
                sorted.addLast(two.data);
                two = two.next;
            }
            return sorted;
        }

        Node midNode(Node head , Node tail){
            Node f = head;
            Node s = head;
            while(f.next != tail && f != tail){
                f = f.next.next;
                s = s.next;
            }
            return s;
        }

        LinkedList sort(Node head , Node tail){
            if(head == tail){
                LinkedList bres = new LinkedList();
                bres.addLast(head.data);
                return bres;
            }
            Node mid = midNode(head , tail);
            LinkedList fsh = sort(head , mid);
            LinkedList ssh = sort(mid.next , tail);
            LinkedList res = sortLL(fsh , ssh);

            return res;
        }

        void removeDuplicate(){
            LinkedList res = new LinkedList();

            while(this.size>0){
                int val = this.getFirst();
                this.removeFirst();

                if(res.size==0 || res.tail.data != val){
                    res.addLast(val);
                }
            }
            this.size = res.size;
            this.head = res.head;
            this.tail =res.tail;
        }

        void oddEven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(val%2==0){
                    even.addLast(val);
                }
                else{
                    odd.addLast(val);
                }
            }
            if(odd.size > 0 && even.size > 0){
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }
            else if(odd.size > 0){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else if(even.size > 0){
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        void kReverse(int k){
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

        void displayReverseHelper(Node node){
            if(node == null){
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        void reversePRHelper(Node node){
            if(node == tail){
                return;
            }
            reversePRHelper(node.next);
            node.next.next = node;
            node.next = null;
        }

        void reversePR(){
            reversePRHelper(head);
            Node temp = head;
            head = tail;
            tail = temp;
        }

        void reverseDRHelper(Node right , int floor){
            if(right == null){
                return;
            }
            reverseDRHelper(right.next , floor + 1);

            if(floor>=size/2){
                int temp = rleft.data;
                rleft.data = right.data;
                right.data = temp;

                rleft = rleft.next;
            }
        }

        Node rleft;
        void reverseDR(){
            rleft = head;
            reverseDRHelper(head , 0);
        }

        boolean palindronehelper(Node right){
            if(right == null){
                return true;
            }
            boolean pres = palindronehelper(right.next);

            if(pres == false){
                return false;
            }
            else if(pleft.data != right.data){
                return false;
            }
            else{
                pleft = pleft.next;
                return true;
            }
        }

        Node pleft;
        boolean palindrone(){
            pleft = head;
            return palindronehelper(head);
        }

        void foldhelper(Node right , int floor){
            if(right == null){
                return;
            }
            foldhelper(right.next , floor + 1);

            if(floor > size/2){
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;
                fleft = temp;
            }
            else if( floor == size/2){
                tail = right;
                tail.next = null;
            }
        }

        Node fleft;
        void fold(){
            fleft = head;
            foldhelper(head , 0);
        }

        int addhelper(Node one , int pv1 , Node two , int pv2 , LinkedList res){
            if(pv1==0 && pv2==0){
                return 0;
            }
            int data = 0;

            if(pv1 < pv2){
                int oc = addhelper(one , pv1 , two.next , pv2 - 1 , res);
                data = two.data + oc;
            }
            else if(pv1 > pv2){
                int oc = addhelper(one.next , pv1-1 , two , pv2 , res);
                data = one.data + oc;
            }   
            else{
                int oc = addhelper(one.next , pv1-1 , two.next , pv2-1 , res);
                data = one.data + two.data + oc;
            }

            int np = data%10;
            int nc = data/10;
            res.addFirst(np);
            return nc;
        }

        LinkedList addLL(LinkedList one , LinkedList two){
            LinkedList res = new LinkedList();
            int oc = addhelper(one.head , one.size , two.head , two.size , res);
            if(oc>0){
                res.addFirst(oc);
            }
            return res;
        }

        int intersection(LinkedList one , LinkedList two){
            Node a = one.head;
            Node b = two.head;

            int delta = Math.abs(one.size() - two.size());

            if(one.size() > two.size()){
                for(int i=0 ; i<delta ; i++){
                    a = a.next;
                }
            }
            else{
                for(int i=0 ; i<delta ; i++){
                    b = b.next;
                }
            }

            while(a!=null && b!=null){
                if(a == b){
                    return a.data;
                }
                else{
                   a =  a.next;
                   b =  b.next;
                }
            }

            return -1;
        }
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            else if(str.startsWith("display")){
                list.display();
            }
            else if(str.startsWith("size")){
                int val = list.size();
                System.out.println(val);
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
                int idx = Integer.parseInt(br.readLine());
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
                String [] values = str.split(" ");
                int val = Integer.parseInt(values[1]);
                int idx = Integer.parseInt(values[2]);

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
            else if(str.startsWith("KthEnd")){
                int k = Integer.parseInt(str.split(" ")[1]);
                int val = list.KthEnd(k);
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("middle")){
                System.out.println(list.middle());
            }

            // merge sorted LinkedList

            else if(str.startsWith("sort")){
                list.sort(list.head , list.tail);
                list.display();
            }
            else if(str.startsWith("removeDuplicates")){
                list.removeDuplicate();
                list.display();
            }
            else if(str.startsWith("oddEven")){
                list.oddEven();
                list.display();
            }
            else if(str.startsWith("kReverse")){
                int k = Integer.parseInt(str.split(" ")[1]);
                list.kReverse(k);
                list.display();
            }
            else if(str.startsWith("displayReverse")){
                list.displayReverse();
            }
            else if(str.startsWith("reversePR")){
                list.reversePR();
                list.display();
            }
            else if(str.startsWith("reverseDR")){
                list.reverseDR();
                list.display();
            }
            else if(str.startsWith("palindrone")){
                boolean val = list.palindrone();
                System.out.println(val);
            }
            else if(str.startsWith("fold")){
                list.fold();
                list.display();
            }
            else if(str.startsWith("intersection")){
                int val = list.intersection(list1 , list2);
                System.out.println(val);
            }
            else if(str.startsWith("addLL")){
                LinkedList add = list.addLL(list1 , list2);
                add.display();
            }
            str = br.readLine();
        }
    }
}