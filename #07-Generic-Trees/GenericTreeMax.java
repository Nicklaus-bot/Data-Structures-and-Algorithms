import java.io.*;
import java.util.*;
public class GenericTreeMax{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node construct(int [] arr){
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

    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child : node.children){
            int cm = max(child);
            max = Math.max(cm , max);
        }
        max = Math.max(node.data ,max);
        return max;
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

            int m = max(root);
            System.out.println(m);
    }
}