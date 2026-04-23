import java.io.*;
import java.util.*;
public class RemoveLeaves{

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

                if(st.size() > 0){
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
        String str = node.data + " ";
        for(Node child : node.children){
            str += child.data + " , ";
        }
        str += " . ";
        System.out.println(str);

        for(Node child : node.children){
            display(child);
        }
    }

    public static void removeleaves(Node node){
        for(int i=node.children.size()-1 ; i>=0 ; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for(Node child : node.children){
            removeleaves(child);
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
        removeleaves(root);
        display(root);
    }
}
