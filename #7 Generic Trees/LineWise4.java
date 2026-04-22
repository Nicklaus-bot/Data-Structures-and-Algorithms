import java.io.*;
import java.util.*;
public class LineWise4{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

                if(st.size()>0){
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

    private static class pair{
        Node node;
        int level;

        pair(Node node , int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void lineWise4(Node node){
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(node , -1));
        int lvl = 1;
        while(q.size() > 0){
            pair p = q.remove();
            if(p.level > lvl){
                System.out.println();
                lvl = p.level;
            }

            System.out.println(p.node.data + " ");
            for(Node child : node.children){
                pair cp = new pair(child , p.level + 1);
                q.add(cp);
            }
        }
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] values = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);

        lineWise4(root);
    }
}