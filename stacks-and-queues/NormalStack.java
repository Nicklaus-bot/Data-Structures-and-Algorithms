import java.io.*;
public class NormalStack{
    public static class NS{
        int tos;
        int [] arr;

        public NS(int cap){
            tos = -1;
            arr = new int [cap];
        }

        int size(){
            return tos+1;
        }

        void display(){
            for(int i=tos ; i>=0 ; i--){
                System.out.println(arr[i]);
            }
        }

        void push(int val){
            if(tos == arr.length - 1){
                System.out.println("Stack Overflow");
            }
            else{
                tos++;
                arr[tos] = val;
            }
        }

        int pop(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = arr[tos];
                tos--;
                return val;
            }
        }

        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = tos;
                return arr[val];
            }
        }
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        NS st = new NS(n);

        String str = br.readLine();

        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            }
            else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            else if(str.startsWith("display")){
                st.display();
            }

            str = br.readLine();
        }
    }
}