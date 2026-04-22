import java.io.*;
import java.util.*;
public class DistanceTwoNodes{
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
        String str = node.data + "--->";
        for(Node child : node.children){
            str += child.data +  " , ";
        }
        str += ".";
        System.out.println(str);

        for(Node child : node.children){
            display(child);
        }
    }

    public static ArrayList<Integer> nodetorootpath(Node node , int data){
        if(node.data == data){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }
        for(Node child : node.children){
            ArrayList<Integer> ptc = nodetorootpath(child , data);
            if(ptc.size() > 0){
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int distance(Node node , int a , int b){
        ArrayList<Integer> p1 = nodetorootpath(node , a);
        ArrayList<Integer> p2 = nodetorootpath(node , b);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while(i>=0 && j>=0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }

        i++;
        j++;

        int d = i+j;
        return d;
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
        display(root);

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int d = distance(root , a , b);
        System.out.println(d);

    }
}
