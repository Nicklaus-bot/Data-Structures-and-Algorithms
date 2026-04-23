import java.io.*;
import java.util.*;
public class Linewise{
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

    public static void linewise(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        while(!mq.isEmpty()){
            node = mq.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children){
                cq.add(child);
            }
            if(mq.isEmpty()){
                mq = cq;
                cq = new ArrayDeque<>();
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
        linewise(root);

    }
}