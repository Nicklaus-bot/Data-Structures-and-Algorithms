import java.io.*;
public class BSTFull{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int [] arr , int lo , int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo + hi)/2;
        int data = arr[mid];

        Node lc = construct(arr , lo , mid - 1);
        Node rc = construct(arr , mid + 1 , hi);

        Node node = new Node(data , lc , rc);

        return node;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left != null ? node.left.data : 0;
        str += " --> " + node.data + " <-- ";
        str += node.right != null ? node.right.data : 0;
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);

        int size = ls + rs + 1;
        return size;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);
        int sum = ls + rs + node.data;
        return sum;
    }

    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }

    public static int min(Node node){
        if(node.left != null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }

    public static Boolean find(Node node , int data){
        if(node == null){
            return false;
        }
        if(node.data > data){
            return find(node.left , data);
        }
        else if(node.data < data){
            return find(node.right , data);
        }
        else{
            return true;
        }
    }

    public static Node addNode(Node node , int data){
        if(node == null){
            return new Node(data , null , null);
        }

        if(data > node.data){
            node.right = addNode(node.right , data);
        }
        else if(data < node.data){
            node.left = addNode(node.left , data);
        }
        return node;
    }

    public static Node removeNode(Node node , int data){
        if(node == null){
            return null;
        }

        if(data > node.data){
            node.right = removeNode(node.right , data);
        }
        else if(data < node.data){
            node.left = removeNode(node.left , data);
        }
        else{
            if(node.left != null && node.right != null){
                int max = max(node.left);
                node.data = max;
                node.left = removeNode(node.left , max);
                return node;
            }
            else if(node.left != null){
                return node.left;
            }   
            else if(node.right != null){
                return node.right;
            }
            else{
                return null;
            }
        }
        return node;
    }

    static int rsum = 0;
    public static void rsol(Node node){
        if(node == null){
            return;
        }
        rsol(node.right);

        int od = node.data;
        node.data = rsum;
        rsum += od;

        rsol(node.left);
    }

    public static int LCA(Node node , int d1 , int d2){
        if(d1<node.data && d2<node.data){
            return LCA(node.left , d1 ,d2);
        }
        else if(d1>node.data && d2>node.data){
            return LCA(node.right , d1 , d2);
        }
        else{
            return node.data;
        }
    }

    public static void pir(Node node , int d1 , int d2){
        if(node == null){
            return;
        }
        if(d1<node.data && d2<node.data){
            pir(node.left , d1 , d2);
        }
        else if(d1>node.data && d2>node.data){
            pir(node.right , d1 , d2);
        }
        else{
            pir(node.left , d1 , d2);
            if(node.data>=d1 && node.data<=d2){
                System.out.println(node.data);
            }
            pir(node.right , d1 , d2);
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

       //int d1 = Integer.parseInt(br.readLine());
       //int d2 = Integer.parseInt(br.readLine());
       // 12 25 37 50 62 75 87

        Node root = construct(arr , 0 , arr.length - 1);

        //int size = size(root);
        //System.out.println(size);

        //int sum = sum(root);
        //System.out.println(sum);

        //int max = max(root);
        //System.out.println(max);

        //int min = min(root);
        //System.out.println(min);

        //Boolean val = find(root , data);
        //System.out.println(val);

        //addNode(root , data);
        //removeNode(root , data);

        //rsum = 0;
        //rsol(root);
        //display(root);

        //int LCA = LCA(root , d1 , d2);
        //System.out.println(LCA);

        //pir(root , d1 , d2);
    }
}