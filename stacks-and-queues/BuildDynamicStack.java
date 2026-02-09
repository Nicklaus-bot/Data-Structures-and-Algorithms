import java.io.*;
public class BuildDynamicStack{

    public static class DynamicStack{
        int tos;
        int [] arr;

        public DynamicStack(int cap){
            tos = -1;
            arr = new int [cap]; 
        }

        void push(int val){
            if(tos == arr.length-1){
                int [] da = new int [2* arr.length];
                for(int i=0 ; i<arr.length ; i++){
                    da[i] = arr[i];
                }
                arr = da;
                tos++;
                arr[tos] = val;
            }
            else{
                tos++;
                arr[tos] = val;
            }
        }

        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return arr[tos];
            }
        }

        int pop(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = tos;
                tos--;
                return arr[val];
            }
        }

        int size(){
            return tos + 1;
        }

        void display(){
            for(int i=tos ; i>=0 ; i--){
                System.out.print(arr[i] + "\t");
            }
        }

    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        DynamicStack st = new DynamicStack(n);

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