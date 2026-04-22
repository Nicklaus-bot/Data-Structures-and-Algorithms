import java.io.*;
public class TwoStacksInArray{
    public static class TwoStacks{
        int tos1;
        int tos2;
        int [] data;

        public TwoStacks(int cap){
            tos1 = -1;
            tos2 = cap;
            data = new int [cap];
        }
        void push1(int val){
            if(tos2 == tos1 + 1){
                System.out.println("Stack Overflow");
            }
            else{
                tos1++;
                data[tos1] = val; 
            }
        }
        void push2(int val){
            if(tos2 == tos1 + 1){
                System.out.println("Stack Overflow");
            }
            else{
                tos2--;
                data[tos2] = val;
            }
        }
        int size1(){
            return tos1 + 1;
        }
        int size2(){
            return data.length - tos2;
        }
        int pop1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos1];
                tos1--;
                return val;
            }
        }
        int pop2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos2];
                tos2++;
                return val;
            }
        }
        int get1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos1];
                return val;
            }
        }
        int get2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val = data[tos2];
                return val;
            }
        }

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        TwoStacks st = new TwoStacks(n);

        while(str.equals("quit") == false){
            if(str.startsWith("push1")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            }
            else if(str.startsWith("push2")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            }
            else if(str.startsWith("size1")){
                System.out.println(st.size1());
            }
            else if(str.startsWith("size2")){
                System.out.println(st.size2());
            }
            else if(str.startsWith("pop1")){
                int val = st.pop1();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("pop2")){
                int val = st.pop2();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("get1")){
                int val = st.get1();
                if(val != -1){
                    System.out.println(val);
                }   
            }
            else if(str.startsWith("get2")){
                int val = st.get2();
                if(val != -1){
                    System.out.println(val);
                }
            }
        str = br.readLine();    
        }
    }
}