import java.io.*;
import java.util.*;
public class Traversal{

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

    public static void traversal(Node node){
        System.out.println("Pre Node " + node.data);
        for(Node child : node.children){
            System.out.println("Edge Pre " + node.data + " " + child.data);
            traversal(child);
            System.out.println("Edge Post " + node.data + " " + child.data);
        }
        System.out.println("Post Node " + node.data);
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
        traversal(root);
    }
}