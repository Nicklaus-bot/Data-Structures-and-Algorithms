import java.io.*;
import java.util.*;
public class Linearise{

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

    private static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearise1(Node node){
        for(Node child : node.children){
            linearise1(child);
        }
        while(node.children.size()>1){
            Node lc = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = getTail(sl);
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
            Node sl = node.children.get(node.children.size()  -1);
            Node slt = linearise2(sl);
            slt.children.add(last);
        }
        return lkt;
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
        linearise1(root);
        display(root);
        
    }
}
