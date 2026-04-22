import java.io.*;
import java.util.*;
public class FullGenericTree{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){

        } 

        Node(int data){
            this.data = data;
        }
    }

    public static Node construct(int [] arr){
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node t = new Node();
                t.data = arr[i];

                if(!st.isEmpty()){
                    st.peek().children.add(t);
                }
                else{
                    root = t;
                }
                st.push(t);    
            }
        }
        return root;
    }

    public static void display(Node node){
        String str = node.data + " ---> ";
        for(Node child : node.children){
            str += child.data + " , ";
        }
        str += " . ";
        System.out.println(str);

        for(Node child : node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int s = 0;
        for(Node child : node.children){
            int cs = size(child);
            s = s + cs;
        }
        s += 1;
        return s;
    }

    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child : node.children){
            int cm = max(child);
            max = Math.max(max , cm);
        }
        max = Math.max(max , node.data);
        return max;
    }

    public static int height(Node node){
        int ht = -1;
        for(Node child : node.children){
            int ch = height(child);
            ht = Math.max(ht , ch);
        }
        ht += 1;
        return ht;
    }

    public static void traversal(Node node){
        System.out.println("Pre Node " + node.data);
        for(Node child : node.children){
            System.out.println("Pre Edge "  + node.data +" " + child.data);
            traversal(child);
            System.out.println("Post Edge " + child.data + " " + node.data);
        }
        System.out.println("Post Node " + node.data);
    }

    public static void levelOrder(Node node){
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);

        while(qu.size() > 0){
            node = qu.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children){
                qu.add(child);
            }
        }
        System.out.print(" . ");
    }

    public static void linewise1(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(node);

        while(mq.size() > 0){
            node = mq.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children){
                cq.add(child);
            }
            if(mq.size() == 0){
                System.out.println();
                mq = cq;
                cq = new ArrayDeque<>();
                }
        }
    }

    public static void zigzag(Node node){
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>(); 
        int lvl = 1;

        ms.push(node);
        while(ms.size() > 0){
            node = ms.pop();
            System.out.print(node.data + " ");

            if(lvl % 2 != 0){
                for(int i=0 ; i<node.children.size() ; i++){
                    cs.push(node.children.get(i));
                }
            }
            else{
                for(int i=node.children.size() - 1 ; i>=0 ; i--){
                    cs.push(node.children.get(i));
                }
            }

            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                lvl++;
                System.out.println();
            }
        }
    }

    public static void linewise2(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));

        while(mq.size() > 0){
            node = mq.remove();

            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    mq.add(child);
                }
            }
            else{
                System.out.println();
                if(mq.size() > 0){
                mq.add(new Node(-1));
                }
            }
        }
    }

    public static void linewise3(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while(mq.size() > 0){
            int size = mq.size();
            for(int i=0 ; i<size ; i++){
                node = mq.remove();
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair{
        Node node;
        int data;

        Pair(Node node ,int data){
            this.node = node;
            this.data = data;
        }
    }

    public static void linewise4(Node node){
        Queue<Pair> mq = new ArrayDeque<>();
        Pair p = new Pair(node , 1);
        int lvl = 1;
        mq.add(p);

        while(mq.size() > 0){
            p = mq.remove();

            if(p.data > lvl){
                lvl = p.data;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for(Node child : p.node.children){
                Pair cp = new Pair(child , p.data + 1);
                mq.add(cp);
            }
        }
    }

    public static void mirror(Node node){
        for(Node child : node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeleaves(Node node){
        for(int i = node.children.size()-1 ; i>=0 ; i--){
            Node child = node.children.get(i);
            
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for(Node child : node.children){
            removeleaves(child);
        }
    }

    private static Node getLast(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }
    public static void linearise1(Node node){
        for(Node child : node.children){
            linearise1(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size() -1 );
            Node slc = node.children.get(node.children.size() - 1);
            Node slt = getLast(slc);
            slt.children.add(lc);
        }
    }

    public static Node linearise2(Node node){
        if(node.children.size() == 0){
            return node;
        }

        Node lkt = linearise2(node.children.get(node.children.size() - 1));
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = linearise2(sl);
            slt.children.add(last);
        }
        return lkt;
    }

    public static boolean findnode(Node node , int data){
        if(node.data == data){
            return true;
        }

        for(Node child : node.children){
            if(findnode(child , data)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodetoroot(Node node , int data){
        if(node.data == data){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for(Node child : node.children){
            ArrayList<Integer> ptc = nodetoroot(child , data);
            if(ptc.size() > 0){
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int lowestcommonancestor(Node node , int data1 , int data2){
        ArrayList<Integer> l1 = nodetoroot(node , data1);
        ArrayList<Integer> l2 = nodetoroot(node , data2);

        int i = l1.size()-1;
        int j = l2.size()-1;

        while(i>=0 && j>=0 && l1.get(i)==l2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return l1.get(i);
    }

    public static int distance(Node node , int data1 , int data2){
        ArrayList<Integer> l1 = nodetoroot(node , data1);
        ArrayList<Integer> l2 = nodetoroot(node , data2);

        int i = l1.size() - 1;
        int j = l2.size() - 1;

        while(i>=0 && j>=0 && l1.get(i)==l2.get(j)){
            i--;
            j--;
        }

        i++;
        j++;

        int d = i+j;
        return d;
    }

    public static boolean similartrees(Node n1 , Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i=0 ; i<n1.children.size() ; i++){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if(similartrees(c1 , c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean mirrortrees(Node n1 , Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i=0 ; i<n1.children.size() ; i++){
            int j = n2.children.size() - 1 - i;

            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);

            if(mirrortrees(c1 , c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean symmetric(Node node){
        return mirrortrees(node , node);
    }


    static int size;
    static int height;
    static int max;
    static int min;
    public static void multisolver(Node node , int depth){
        size++;
        height = Math.max(depth , height);
        max = Math.max(max , node.data);
        min = Math.min(min , node.data);

        for(Node child : node.children){
            multisolver(child , depth++);
        }

    }

    static int state;
    static Node p;
    static Node s;
    public static void predecessorandsuccessor(Node node , int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            }
            else{
                p = node;
            }
        }
        else if(state == 1){
            s = node;
            state = 2;
        }

        for(Node child : node.children){
            predecessorandsuccessor(child , data);
        }
    }

    static int ceil;
    static int floor;
    public static void ceilandfloor(Node node , int data){
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }

        for(Node child : node.children){
            ceilandfloor(child , data);
        }
    }

    public static int  kthlargest(Node node , int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for(int i=0 ; i<k ; i++){
            ceilandfloor(node , factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }

    static int msn = 0;
    static int ms = Integer.MIN_VALUE;
    public static int maxsumsubtree(Node node){
        int sum = 0;

        for(Node child : node.children){
            int cs = maxsumsubtree(child);
            sum += cs;
        }
        sum += node.data;

        if(sum>ms){
            ms = sum;
            msn = node.data;
        }
        return sum;
    }

    static int d = 0;
    static int diameter(Node node){
        int dh = -1;
        int sdh = -1;

        for(Node child : node.children){
            int ch = diameter(child);
            if(ch > dh){
                sdh = dh;
                dh = ch;
            }
            else if(ch > sdh){
                sdh = ch;
            }
        }
        if(dh + sdh + 2 > d){
            d = dh + sdh + 2;
        }
        dh += 1;
        return dh;
    }

    public static void prepostorder(Node node){
        Stack <Pair> st = new Stack<>();
        st.push(new Pair(node , -1));

        String pre = " ";
        String post = " ";

        while(st.size() > 0){
            Pair top = st.peek();
            if(top.data == -1){
                pre += top.node.data + " ";
                top.data++;
            }
            else if(top.data == top.node.children.size()){
                post += top.node.data + " ";
                st.pop();
            }
            else{
                Pair cp = new Pair(top.node.children.get(top.data) , -1);
                st.push(cp);
                top.data++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] values = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(values[i]);
        }

        //int n2 = Integer.parseInt(br.readLine());
        //int [] arr2 = new int [n2];
        //String [] values2 = br.readLine().split(" ");
        //for(int i=0 ; i<arr2.length ; i++){
        //    arr2[i] = Integer.parseInt(values[i]);
        //}


        //int data = Integer.parseInt(br.readLine());
        //int data2 = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        //Node root2 = construct(arr2);

        //display(root);

        //int s = size(root);
        //System.out.println("Size is " + s);

        //int max = max(root);
        //System.out.println("Max is " + max);

        //int ht = height(root);
        //System.out.println("Height is " + ht);

        //traversal(root);

        //levelOrder(root);

        //linewise1(root);

        //zigzag(root);

        //linewise2(root);

        //linewise3(root);

        //linewise4(root);

        //mirror(root);

        //removeleaves(root);

        //linearise1(root);

        //display(root);

        //linearise2(root);

        //display(root);

        //boolean val = findnode(root , data);
        //System.out.println(val);

        //ArrayList<Integer> path = nodetoroot(root , data);
        //System.out.println(path);

        //int lca = lowestcommonancestor(root , data , data2);
        //System.out.println(lca);

        //int d = distance(root , data ,data2);
        //System.out.println(d);

        //boolean val = similartrees(root , root2);
        //System.out.println(val);

        //boolean val = mirrortrees(root , root2);
        //System.out.println(val);

        //boolean val = symmetric(root);
        //System.out.println(val);

        //size = 0;
        //height = 0;
        //max = Integer.MIN_VALUE;
        //min = Integer.MAX_VALUE;

        //multisolver(root , 0);
        //System.out.println("Size is " + size);
        //System.out.println("Height is " + height);
        //System.out.println("Maximum is " + max);
        //System.out.println("Minimum is " + min);

        //predecessorandsuccessor(root , 50);
        //System.out.println(p.data + " + " + s.data);

        //ceil = Integer.MAX_VALUE;
        //floor = Integer.MIN_VALUE;
        //ceilandfloor(root , data);
        //System.out.println("Ceil is " + ceil + "\nFloor is " + floor);

        //int kthlargest = kthlargest(root ,3);
        //System.out.println(kthlargest);

       // maxsumsubtree(root);
        //System.out.println(msn + " " + ms);

        //diameter(root);
        //System.out.println(d);

        //prepostorder(root);

    }
}