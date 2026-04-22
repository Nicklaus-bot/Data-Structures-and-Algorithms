import java.io.*;
import java.util.*;
public class LineWise2{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        public Node(){
        }

        public Node(int data){
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

    public static void lineWise2(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));
        while(q.size() > 0){
            node = q.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    q.add(child);
                }
            }
            else{
                if(q.size() > 0){
                    q.add(new Node(-1));
                }
                System.out.println();
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

        lineWise2(root);
    }
}