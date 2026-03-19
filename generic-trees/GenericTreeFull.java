import java.io.*;
import java.util.*;
public class GenericTreeFull{
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



    }
}