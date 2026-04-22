import java.io.*;
import java.util.*;
public class BinaryTreesFull{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node ; 
        int state;

        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer [] arr){
        Node root = new Node(arr[0] , null , null);
        Pair rtp = new Pair(root , 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while(!st.isEmpty()){
            Pair top = st.peek();

            if(top.state == 1){
                idx ++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx] , null , null);
                    Pair lp = new Pair(top.node.left , 1);
                    st.push(lp);
                }
                else{
                    top.node.left = null;
                }

                top.state ++;
            }
            else if(top.state == 2){
                idx ++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx] , null , null);
                    Pair rp = new Pair(top.node.right , 1);
                    st.push(rp);
                }
                else{
                    top.node.right = null;
                }

                top.state++;
            }
            else{
                st.pop();
            }
        }
        return root;
    } 

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left==null? "." : node.left.data;
        str += " <-- " + node.data + " --> ";
        str += node.right==null? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int size = 0;
        size = size(node.left) + size(node.right) + 1;
        return size;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int sum = 0;
        sum = sum(node.left) + sum(node.right) + node.data;
        return sum;
    }

    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int max = 0;
        int lm = max(node.left);
        int rm = max(node.right);
        max = Math.max(Math.max(lm , rm) , node.data);
        return max;
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }

        int ht = 0;
        int lh = height(node.left);
        int rh = height(node.right);
        ht = Math.max(lh , rh) + 1;
        return ht;
    }

    public static void traversals(Node node){
        if(node == null){
            return;
        }

        System.out.println("Preorder in " + node.data);
        traversals(node.left);
        System.out.println("Inorder in " + node.data);
        traversals(node.right);
        System.out.println("Postorder in " + node.data);
    }

    public static void levelOrder(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while(!mq.isEmpty()){
            int size = mq.size();
            for(int i=0 ; i<size ; i++){
                node = mq.remove();
                System.out.print(node.data + "\t");

                if(node.left != null){
                    mq.add(node.left);
                }
                if(node.right != null){
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void iterative(Node node){
        String pre = "";
        String in = "";
        String post = "";

        Stack<Pair> ms = new Stack<>();
        Pair rtp = new Pair(node , 1);
        ms.push(rtp);

        while(!ms.isEmpty()){
            Pair top = ms.peek();

            if(top.state == 1){
                pre += top.node.data + " ";
                top.state++;
                if(top.node.left != null){
                    Pair lp = new Pair(top.node.left , 1);
                    ms.push(lp);
                }  
            }
            else if(top.state == 2){
                in += top.node.data + " ";
                top.state++;
                if(top.node.right != null){
                    Pair rp = new Pair(top.node.right , 1);
                    ms.push(rp);
                }
            }
            else{
                post += top.node.data + " ";
                ms.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static ArrayList<Node> nodetoroot ; 
    public static boolean nodetoroot(Node node , int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            //nodetoroot.add(node.data);
            return true;
        }
        boolean lv = nodetoroot(node.left , data);
        if(lv){
            //nodetoroot.add(node.data);
            return true;
        }
        boolean rv = nodetoroot(node.right , data);
        if(rv){
            //nodetoroot.add(node.data);
            return true;
        }
        return false;
    }

    public static void kLevels(Node node , int k , Node block){
        if(node==null || k<0 || node==block){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        kLevels(node.left , k - 1 , block);
        kLevels(node.right , k - 1 , block);

    }

    public static void RTL(Node node , String path , int sum , int lo , int hi){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum>=lo && sum<=hi){
                System.out.print(path + node.data + " ");
            }
            return;
        }

        RTL(node.left , path + node.data + " " , sum + node.data , lo , hi);
        RTL(node.right , path + node.data + " " , sum + node.data , lo , hi);
    }

    public static void kAway(Node node , int data , int k){
        if(node == null){
            return;
        }

        nodetoroot = new ArrayList<>();
        nodetoroot(node , data);

        for(int i=0 ; i<nodetoroot.size() ; i++){
            kLevels(nodetoroot.get(i) , k-i , i==0? null : nodetoroot.get(i-1));
        }


    }

    public static Node leftClone(Node node){
        if(node == null){
            return null;
        }

        Node lcr = leftClone(node.left);
        Node rcr = leftClone(node.right);

        Node nn = new Node(node.data , lcr , null);
        node.left = nn;
        node.right = rcr;

        return node;
    }

    public static Node leftCloneReverse(Node node){
        if(node == null){
            return null;
        }

        Node lcr = leftCloneReverse(node.left.left);
        Node rcr = leftCloneReverse(node.right);

        node.left = lcr;
        node.right = rcr;

        return node;
    }

    public static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    public static void singleChild(Node node , Node parent){
        if(node == null){
            return;
        }

        if(parent != null && parent.left == null && parent.right == node){
            System.out.print(node.data + " ");
        }
        if(parent != null && parent.left == node && parent.right == null){
            System.out.print(node.data + " ");
        }

        singleChild(node.left, node);
        singleChild(node.right, node);

    }

    public static int diameter1(Node node){
        if(node == null){
            return 0;
        }

        int dl = diameter1(node.left);
        int dr = diameter1(node.right);

        int f = height(node.left) + height(node.right) + 2;
        int d = Math.max(f , Math.max(dl , dr));
        return d;
    }

    public static  class diaP{
        int ht;
        int d;
    }

    public static diaP diameter2(Node node){
        if(node == null){
            diaP bp = new diaP();
            bp.ht = -1;
            bp.d = 0;
            return bp;
        }

        diaP lp = diameter2(node.left);
        diaP rp = diameter2(node.right);

        diaP mp = new diaP();
        mp.ht = Math.max(lp.ht , rp.ht) + 1;

        int fes = lp.ht + rp.ht + 2;
        mp.d = Math.max(fes , Math.max(lp.d , rp.d));

        return mp;
    }

    static int tilt;
    public static int tiltTree(Node node){
        if(node == null){
            return 0;
        }

        int lt = tiltTree(node.left);
        int rt = tiltTree(node.right);

        int ltilt = Math.abs(lt - rt);
        tilt += ltilt;

        int ts = lt + rt + node.data;
        return ts;
    }

    public static class BSTPair{
        Boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node){
        if(node == null){
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;

            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (lp.max<=node.data && node.data <=rp.min);
        mp.min = Math.min(node.data , Math.min(lp.min , rp.min));
        mp.max = Math.max(node.data , Math.max(lp.max , rp.max));

        return mp;
    }

    static boolean isBT = true;
    public static int balanceTree1(Node node){
        if(node == null){
            return 0;
        }

        int lh = balanceTree1(node.left);
        int rh = balanceTree1(node.right);

        if(Math.abs(lh - rh) > 1){
            isBT = false;
        }

        int h = Math.max(lh , rh) + 1;
        return h;
    }

    public static class BalancePair{
        int h;
        boolean isBT;
    }
    public static BalancePair balanceTree2(Node node){
        if(node == null){
            BalancePair bp = new BalancePair();
            bp.h = 0;
            bp.isBT = true;

            return bp;
        }

        BalancePair lp = balanceTree2(node.left);
        BalancePair rp = balanceTree2(node.right);

        BalancePair mp = new BalancePair();
        mp.isBT = lp.isBT && rp.isBT && (Math.abs(lp.h - rp.h)<=1);
        mp.h = Math.max(lp.h , rp.h) + 1;

        return mp;
    }

    public static class LBSTPair{
        Boolean isBST;
        int min;
        int max;
        Node lbstr;
        int lbstsize;
    }
    public static LBSTPair lbst(Node node){
        if(node == null){
            LBSTPair bp = new LBSTPair();
            bp.isBST = true;
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.lbstr = null;
            bp.lbstsize = 0;

            return bp;
        }

        LBSTPair lp = lbst(node.left);
        LBSTPair rp = lbst(node.right);

        LBSTPair mp = new LBSTPair();
        mp.isBST = lp.isBST && rp.isBST && (lp.max < node.data && node.data < rp.min);
        mp.max = Math.max(Math.max(lp.max , rp.max) , node.data);
        mp.min = Math.min(Math.min(lp.min , rp.min) , node.data);

        if(mp.isBST){
            mp.lbstr = node;
            mp.lbstsize = lp.lbstsize + rp.lbstsize + 1;
        }
        else if(lp.lbstsize > rp.lbstsize){
            mp.lbstr = lp.lbstr;
            mp.lbstsize = lp.lbstsize;
        }
        else{
            mp.lbstr = rp.lbstr;
            mp.lbstsize = rp.lbstsize;
        }
        return mp;
    }




    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer [n];
        String [] values = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            if(values[i].equals("n") == false){
                arr[i] = Integer.parseInt(values[i]);
            }
            else{
                arr[i] = null;
            }
        }

        //int data = Integer.parseInt(br.readLine());
        //int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);

        //display(root);

        //int size = size(root);
        //System.out.println(size);

        //int sum = sum(root);
        //System.out.println(sum);

        //int max = max(root);
        //System.out.println(max);

        //int ht = height(root);
        //System.out.println(ht);

        //traversals(root);

        //levelOrder(root);

        //iterative(root);

        //nodetoroot = new ArrayList<>();
        //nodetoroot(root, data);
        //System.out.println(nodetoroot);

        //kLevels(root , data);

        //RTL(root , "" , 0 , 20 , 1000);

        //kAway(root , data , k);

        //Node root2 = leftClone(root);
        //display(root2);

        //Node root3 = leftCloneReverse(root2);
        //display(root3);

        //Node root4 = removeLeaves(root);
        //display(root4);

        //singleChild(root , null);

        //int dia1 = diameter1(root);
        //System.out.println(dia1);

        //diaP np = diameter2(root);
        //System.out.println(np.d);

        //tilt = 0;
        //tiltTree(root);
        //System.out.println(tilt);

        //BSTPair pair = isBST(root);
        //System.out.println(pair.isBST);

        //balanceTree1(root);
        //System.out.println(isBT);

        //BalancePair pair = balanceTree2(root);
        //System.out.println(pair.isBT);

        LBSTPair pair = lbst(root);
        System.out.println(pair.lbstr.data + " @ " + pair.lbstsize);
    }
}