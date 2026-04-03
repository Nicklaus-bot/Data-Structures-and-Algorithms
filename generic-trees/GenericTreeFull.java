import java.io.*;
import java.util.*;
public class GenericTreeFull{
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
        if(node == null){
            return;
        }

        String str = node.data + " --> ";

        for(Node child : node.children){
            str += child.data + " , ";
        }
        System.out.println(str + " . ");
        for(Node child : node.children){
            display(child);
        }
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int s = 0;
        for(Node child : node.children){
            s += size(child);
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
            System.out.println("Pre Edge " + node.data + " -- "  +  child.data);
            traversal(child);
            System.out.println("Post Node " + child.data + " -- " +  node.data);
        }
        System.out.println("Post Node " + node.data);
    }

    public static void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(!q.isEmpty()){
            node = q.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children){
                q.add(child);
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



    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        // 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

        Node root = construct(arr);

        display(root);

        int s = size(root);
        System.out.println(s);

        int m = max(root);
        System.out.println(m);

        int h = height(root);
        System.out.println(h);

        traversal(root);

        levelOrder(root);

        linewise1(root);

        zigzag(root);

        linewise2(root);

        linewise3(root);

        linewise4(root);

        mirror(root);

        removeleaves(root);

        






    }
}