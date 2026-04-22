import java.io.*;
public class BuildDynamicStack{
    public static class DynamicStack{
        int [] data;
        int tos;

        public DynamicStack(int cap){
            data = new int [cap];
            tos = -1;
        }
        void push(int val){
            if(tos == data.length - 1){
                int [] ndata = new int [2 * data.length];
                for(int i=0 ; i<data.length ; i++){
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                ndata[tos] = val;
            }
            else{
                tos++;
                data[tos] = val;
            }
        }
        void display(){
            for(int i=tos ; i>=0 ; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        int size(){
            return tos + 1;
        }
        int pop(){
            if(tos == -1){
                System.out.println("StackUnderflow");
                return -1;
            }
            else{
                int val = data[tos];
                tos--;
                return val;
            }

        }
        int top(){
            if(tos == -1){
                System.out.println("StackUnderflow");
                return -1;
            }
            else{
                return data[tos];
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
                int val = Integer.parseInt(str.split( " ")[1]);
                st.push(val);
            }
            else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            else if(str.startsWith("display")){
                st.display();
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
            str = br.readLine();
        }
    }
}